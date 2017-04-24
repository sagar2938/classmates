package com.classmates.classmates;

public class get_notices  {

	private String image;
	private String college;
	private String batch;
	private String branch;
	private String subject;
	private String date;
	private String name;
	private String time;
	private String venue;
	private String notice;
	public get_notices(String image,String college,String batch,String branch,String subject,String date,String name,String time,String venue,String notice){
		
		this.image = image;
		this.college = college;
		this.batch = batch;
		this.branch = branch;
		this.subject = subject;
		this.date = date;
		this.name = name;
		this.time = time;
		this.venue = venue;
		this.notice = notice;
	}
	public String getImage() {
		return image;
	}
	public String getNotice() {
		return notice;
	}
	public String getCollege() {
		return college;
	}
	public String getBatch() {
		return batch;
	}
	public String getBranch() {
		return branch;
	}
	public String getSubject() {
		return subject;
	}
	public String getDate() {
		return date;
	}
	public String getName() {
		return name;
	}
	public String getTime() {
		return time;
	}
	public String getVenue() {
		return venue;
	}
	
	
	
}
