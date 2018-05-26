import * as vscode from 'vscode';
import {initialize,updateIfEnabled,BDDChecks} from './bddCheck'



export function activate(context: vscode.ExtensionContext) {
   let test = new BDDChecks(context);
}

