 package com.fssa.turbotrip.model;

public class User {

	private int user_id;
	private String email;
	private String username;
	private String password;
	private String phone;
	private int isdeleted;
	private boolean isdriver;

//	public User(long id, String username, String email, String phone, String password, int isdeleted, boolean isdriver) {
//		this.email = email;
//		this.username = username; 
//		this.password = password;
//		this.phone = phone;
//		this.setIsdeleted(isdeleted);
//		this.setIsdriver(isdriver);
//		
//	}
	
	public User(String username, String email, String phone, String password, int isdeleted, boolean isdriver) {
	
		this.email = email;
		this.username = username; 
		this.password = password;
		this.phone = phone;
		this.setIsdeleted(isdeleted);
		this.setIsdriver(isdriver);
		
	}
	// This is getters and setters for UserModel
 
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public User() {
	
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + username + ", password=" + password + "]";
	}

	public boolean getIsdriver() {
		return isdriver;
	}

	public void setIsdriver(boolean isdriver) {
		this.isdriver = isdriver;
	}

	public int getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(int isdeleted) {
		this.isdeleted = isdeleted;
	}
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
