package com.classmates.classmates;

public class get_outbox {

	

		private String from_addr;
		private String from_image;
		private String from_name;
		private String to_addr;
		private String to_image;
		private String to_name;
		private String message;
		public get_outbox(String from_addr,String from_image,String from_name,String to_addr,String to_image,String to_name,String message){
			super();
			this.from_addr = from_addr;
			this.from_image = from_image;
			this.from_name = from_name;
			this.to_addr = to_addr;
			this.to_image = to_image;
			this.to_name = to_name;
			this.message = message;
		}
		public String getfrom_addr() {
			return from_addr;
		}
		public String getfrom_image() {
			return from_image;
		}
		public String getfrom_name() {
			return from_name;
		}
		public String getto_addr() {
			return to_addr;
		}
		public String getto_image() {
			return to_image;
		}
		public String getto_name() {
			return to_name;
		}
		public String getmessage() {
			return message;
		}
}
