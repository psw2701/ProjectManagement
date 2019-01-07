package com.yi.project.model;

import java.util.Date;

public class ProjectManagement {
	private int no;
	private String name;
	private String start_date;
	private String end_date;
	private String progress;
	public ProjectManagement() {
		// TODO Auto-generated constructor stub
	}
	public ProjectManagement(int no, String name, String start_date, String end_date, String progress) {
		this.no = no;
		this.name = name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.progress = progress;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	@Override
	public String toString() {
		return "ProjectManagement [no=" + no + ", name=" + name + ", start_date=" + start_date + ", end_date="
				+ end_date + ", progress=" + progress + "]";
	}
	
	
	
}
