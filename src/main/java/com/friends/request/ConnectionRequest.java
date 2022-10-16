package com.friends.request;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.friends.entity.User;

public class ConnectionRequest {

	private Integer senderid;
	
	private Integer receiverid;
	
	public Integer getSenderid() {
		return senderid;
	}
	public void setSenderid(Integer senderid) {
		this.senderid = senderid;
	}
	public Integer getReceiverid() {
		return receiverid;
	}
	public void setReceiverid(Integer receiverid) {
		this.receiverid = receiverid;
	}
}
