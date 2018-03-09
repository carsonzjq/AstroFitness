package com.astrofitness.bean;

import java.sql.Date;
import java.sql.Timestamp;

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
	private Timestamp comment_time;

	public Forum() {
		super();
	}
	public Forum(String forum_comment) {
		super();
		this.forum_comment = forum_comment;
	}
	public Forum(String forum_comment, Timestamp comment_time) {
		super();
		this.forum_comment = forum_comment;
		this.comment_time = comment_time;
	}
	public Forum(int forum_id, String forum_comment, Timestamp comment_time) {
		super();
		this.forum_id = forum_id;
		this.forum_comment = forum_comment;
		this.comment_time = comment_time;
	}

	public int getForum_id() {
		return forum_id;
	}

	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}

	public String getforum_comment() {
		return forum_comment;
	}

	public void setforum_comment(String forum_comment) {
		this.forum_comment = forum_comment;
	}

	public Timestamp getTimestamp() {
		return comment_time;
	}

	public void setTimestamp(Timestamp comment_time) {
		this.comment_time = comment_time;
	}


	@Override
	public String toString() {
		return "Forum [forum_id=" + forum_id + ", forum_comment=" + forum_comment + ", comment_time=" + comment_time + "]";
	}
	
	

}
