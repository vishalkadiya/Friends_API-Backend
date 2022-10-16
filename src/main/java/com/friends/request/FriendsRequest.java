package com.friends.request;

import javax.validation.constraints.NotBlank;

public class FriendsRequest {

	@NotBlank(message = "userid is required")
	private Integer userid;
	
	@NotBlank(message = "Friends is required")
	private String friends;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getFriends() {
		return friends;
	}

	public void setFriends(String friends) {
		this.friends = friends;
	}

	public FriendsRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FriendsRequest(@NotBlank(message = "userid is required") Integer userid,
			@NotBlank(message = "Friends is required") String friends) {
		super();
		this.userid = userid;
		this.friends = friends;
	}

}
