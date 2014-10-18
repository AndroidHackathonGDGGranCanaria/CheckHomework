package com.androidhackathongdggrancanaria.checkhomework;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Task{
	
	@SerializedName("_id")
	private Long _id;
	@SerializedName("subject")
	private String subject;
	@SerializedName("limit")
	private Date limit;
	@SerializedName("description")
	private String description;
	@SerializedName("sonId")
	private Long sonId;
	@SerializedName("done")
	private Boolean done;
	
	
	
	public Task() {
	
	}
	public Task(long _id, String subject, Date limit, String description,
			long sonId, boolean done) {
		this._id = _id;
		this.subject = subject;
		this.limit = limit;
		this.description = description;
		this.sonId = sonId;
		this.done = done;
	}
	public long get_id() {
		return _id;
	}
	public void set_id(long _id) {
		this._id = _id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getLimit() {
		return limit;
	}
	public void setLimit(Date limit) {
		this.limit = limit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getSonId() {
		return sonId;
	}
	public void setSonId(long sonId) {
		this.sonId = sonId;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	
}
