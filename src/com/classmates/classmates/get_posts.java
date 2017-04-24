package com.classmates.classmates;

public class get_posts {
	
	private String image;
	private String college;
	private String batch;
	private String branch;
	private String from_add;
	private String post;
	private String name;
	private int pid;
	public get_posts(String name,String image, String college, String batch, String branch,
			String from_add, String post,int pid) {
		super();
		this.name = name;
		this.image = image;
		this.college = college;
		this.batch = batch;
		this.branch = branch;
		this.from_add = from_add;
		this.post = post;
		this.pid = pid;
	}
	public int getPid() {
		return pid;
	}
	public String getName() {
		return name;
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
	public String getPost() {
		return post;
	}
	
	
	

}
