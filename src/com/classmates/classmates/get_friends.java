package com.classmates.classmates;

public class get_friends {

	private String fimage;
	private String fcollege;
	private String fbatch;
	private String fbranch;
	private String femail;
	private String fname;
	private String lname;
	public get_friends(String fimage,String fcollege,String fbatch,String fbranch,String femail,String fname,String lname){
		super();
		this.fimage = fimage;
		this.fcollege = fcollege;
		this.fbatch = fbatch;
		this.fbranch = fbranch;
		this.femail = femail;
		this.fname = fname;
		this.lname = lname;
	}
	public String getfimage() {
		return fimage;
	}
	public String getfcollege() {
		return fcollege;
	}
	public String getfbatch() {
		return fbatch;
	}
	public String getfemail() {
		return femail;
	}
	public String getfname() {
		return fname;
	}
	public String getlname() {
		return lname;
	}
	public String getfbranch() {
		return fbranch;
	}


}
