'use strict';

import * as vscode from 'vscode';
import * as utils from './utils';


export class BDDChecks
{
    public static enabled = false;
    public static context = 0;
    public static opacity = 50;
    public static delay = 200;
    public static commandScope = true;
    
    constructor(context :vscode.ExtensionContext ){
        let configRegistration = vscode.workspace.onDidChangeConfiguration(initialize);
        let selectionRegistration = vscode.window.onDidChangeTextEditorSelection((e) => updateIfEnabled(e.textEditor));
        let textEditorChangeRegistration = vscode.window.onDidChangeActiveTextEditor((textEditor) => updateIfEnabled(textEditor));
        let commandRegistration = vscode.commands.registerCommand('dimmer.ToggleDimmer', () => {
            vscode.workspace.getConfiguration('dimmer').update("enabled", !BDDChecks.enabled, BDDChecks.commandScope);
        });
    
        initialize();
    
        context.subscriptions.push(selectionRegistration, configRegistration, commandRegistration, textEditorChangeRegistration);
    }
}

let dimDecoration: vscode.TextEditorDecorationType;
let normalDecoration = vscode.window.createTextEditorDecorationType(<vscode.DecorationRenderOptions> {
    textDecoration: 'none; opacity: 1'
});


let delayers: { [key: string]: utils.ThrottledDelayer<void> } = Object.create(null);

export function updateIfEnabled(textEditor: vscode.TextEditor) {
    if (BDDChecks.enabled) {
        setDecorations(textEditor);
    }
}

export function initialize()  {
    resetAllDecorations();

    readConfig();
    createDimDecorator();

    setAllDecorations();
}

function readConfig() {
    let config = vscode.workspace.getConfiguration('dimmer');
    BDDChecks.enabled = config.get('enabled', false);
    BDDChecks.commandScope = config.get('toggleDimmerCommandScope', 'user') === 'user';
    BDDChecks.opacity = config.get('opacity', 50);
    BDDChecks.context = config.get('context', 0);
    BDDChecks.delay = config.get('delay', 200);
    BDDChecks.delay = BDDChecks.delay < 0 ? 0 : BDDChecks.delay;
}

function resetAllDecorations() {
    vscode.window.visibleTextEditors.forEach(textEditor => {
        resetDecorations(textEditor);
    });
}

function resetDecorations(textEditor: vscode.TextEditor) {
        highlightSelections(textEditor, []);
        undimEditor(textEditor);
}

function setAllDecorations() {
    vscode.window.visibleTextEditors.forEach(updateIfEnabled);
}

function setDecorations(textEditor: vscode.TextEditor) {
    let filename = textEditor.document.fileName;
    let delayer = delayers[filename];
    if (!delayer) {
        delayer = new utils.ThrottledDelayer<void>(BDDChecks.delay);
        delayers[filename] = delayer;
    }
    delayer.trigger(() => {
        return Promise.resolve().then(() => {
            dimEditor(textEditor);
            highlightSelections(textEditor, textEditor.selections);
        });
    }, BDDChecks.delay);
}

function highlightSelections(editor: vscode.TextEditor, selections: vscode.Range[]) {
    if (!normalDecoration) return;

    let ranges: vscode.Range[] = [];
    selections.forEach(s => {
        if (BDDChecks.context < 0) {
            ranges.push(s);
        }
        else {
            ranges.push(new vscode.Range(
                new vscode.Position(Math.max(s.start.line - BDDChecks.context, 0), 0),
                new vscode.Position(s.end.line + BDDChecks.context, Number.MAX_VALUE)
            ));
        }
    });
    editor.setDecorations(normalDecoration, ranges);
}

export function createDimDecorator() {
    if (dimDecoration) {
        dimDecoration.dispose();
    }
    dimDecoration = vscode.window.createTextEditorDecorationType(<vscode.DecorationRenderOptions> {
        textDecoration: `none; opacity: ${BDDChecks.opacity / 100}`
    });    
}

function undimEditor(editor: vscode.TextEditor) {
    if (!dimDecoration) return;
    
    editor.setDecorations(dimDecoration, []);
}

function dimEditor(editor: vscode.TextEditor) {
    if (!dimDecoration) return;

    let startPosition = new vscode.Position(0, 0)
    let endPosition = new vscode.Position(editor.document.lineCount, Number.MAX_VALUE);
    editor.setDecorations(dimDecoration, [new vscode.Range(startPosition, endPosition)]);
}

export function deactivate() {
    resetAllDecorations();
}

