package com.classmates.classmates;

public class get_profile_posts {
	
	private String image;
	private String post;
	private int pid;
	public get_profile_posts(String image,String post,int pid){
		super();
		this.image = image;
		this.post = post;
		this.pid = pid;
	}
	public int getPid() {
		return pid;
	}
	public String getImage() {
		return image;
	}
	public String getPost() {
		return post;
	}
	

}
