package com.astrofitness.bean;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FORUM")
public class Forum {
	
	@Id
	@Column
	@SequenceGenerator(sequenceName="FORUM_SEQ", name="FORUM_SEQ")
	@GeneratedValue(generator="FORUM_SEQ", strategy=GenerationType.SEQUENCE)
	private int forum_id;
	@Column
	private String forum_comment;
	@Column
	private String comment_time;
	@Column
	private String comment_date;

	public Forum() {
		super();
	}
	public Forum(String forum_comment) {
		super();
		this.forum_comment = forum_comment;
	}
	
	public Forum(String forum_comment, String comment_time, String comment_date) {
		super();
		this.forum_comment = forum_comment;
		this.comment_time = comment_time;
		this.comment_date = comment_date;
	}
	
	public Forum(int forum_id, String forum_comment, String comment_time, String comment_date) {
		super();
		this.forum_id = forum_id;
		this.forum_comment = forum_comment;
		this.comment_time = comment_time;
		this.comment_date = comment_date;
	}
	public int getForum_id() {
		return forum_id;
	}
	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}
	public String getForum_comment() {
		return forum_comment;
	}
	public void setForum_comment(String forum_comment) {
		this.forum_comment = forum_comment;
	}
	public String getComment_time() {
		return comment_time;
	}
	public void setComment_time(String comment_time) {
		this.comment_time = comment_time;
	}
	public String getComment_date() {
		return comment_date;
	}
	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}
	@Override
	public String toString() {
		return "Forum [forum_id=" + forum_id + ", forum_comment=" + forum_comment + ", comment_time=" + comment_time
				+ ", comment_date=" + comment_date + "]";
	}

	
	

}
