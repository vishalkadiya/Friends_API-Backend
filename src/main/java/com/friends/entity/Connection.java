package com.friends.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Connection")
public class Connection {
	
	@Id
	@Column(name="connection_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="sender_id")
	private User senderid;
	@ManyToOne
	@JoinColumn(name="receiver_id")
	private User receiverid;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getSenderid() {
		return senderid;
	}
	public void setSenderid(User senderid) {
		this.senderid = senderid;
	}
	public User getReceiverid() {
		return receiverid;
	}
	public void setReceiverid(User receiverid) {
		this.receiverid = receiverid;
	}
	
	public Connection(Integer id, User senderid, User receiverid) {
		super();
		this.id = id;
		this.senderid = senderid;
		this.receiverid = receiverid;
	}
	public Connection() {
		// TODO Auto-generated constructor stub
	}
}
