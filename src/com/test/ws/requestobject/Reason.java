package com.test.ws.requestobject;

import java.util.ArrayList;
import java.util.List;

import com.test.ws.constant.Constants;


	public class Reason {
		private String name;
		private String messages;
		private List<String> subReasons;
		private String remarks;

		public Reason(String name){
			this.name = name;
			this.messages = Constants.SUCCESS;
			this.subReasons = new ArrayList<String>();
			this.remarks = new String();
		}
		
		public Reason(){}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMessages() {
			return messages;
		}
		public void setMessages(String messages) {
			this.messages = messages;
		}
		public List<String> getSubReasons() {
			return subReasons;
		}

		public void addFailReason(List<String> subReasons) {
			this.getSubReasons().addAll(subReasons);
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
}