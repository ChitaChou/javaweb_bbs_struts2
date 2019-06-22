package com.discovery.model;

public class Threads {
	String thread_id;
	String writer_id;
	String by_forum_id;
	String create_time;
	String latest_post_time;
	String thread_title;
	String thread_text;
	
	public String getThread_id() {
		return thread_id;
	}
	public void setThread_id(String thread_id) {
		this.thread_id = thread_id;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public String getBy_forum_id() {
		return by_forum_id;
	}
	public void setBy_forum_id(String by_forum_id) {
		this.by_forum_id = by_forum_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getLatest_post_time() {
		return latest_post_time;
	}
	public void setLatest_post_time(String latest_post_time) {
		this.latest_post_time = latest_post_time;
	}
	public String getThread_title() {
		return thread_title;
	}
	public void setThread_title(String thread_title) {
		this.thread_title = thread_title;
	}
	public String getThread_text() {
		return thread_text;
	}
	public void setThread_text(String thread_text) {
		this.thread_text = thread_text;
	}	
}
