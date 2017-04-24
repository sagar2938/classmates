package com.classmates.classmates;

public class get_comments {

	private String image;
	private String college;
	private String batch;
	private String branch;
	private String from_add;
	private String comment;
	private String name;
	//private int pid;
	public get_comments(String image, String college, String batch,
			String branch, String from_add, String comment, String name) {
		super();
		this.image = image;
		this.college = college;
		this.batch = batch;
		this.branch = branch;
		this.from_add = from_add;
		this.comment = comment;
		this.name = name;
		//this.pid = pid;
	}
	public String getImage() {
		return image;
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
	public String getFrom_add() {
		return from_add;
	}
	public String getComment() {
		return comment;
	}
	public String getName() {
		return name;
	}
	
}
