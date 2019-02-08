package model.login;

public class User {

	private String username;
	private String password;
	private boolean admin;

	public User(String username, String password, boolean admin) {
		this.admin = admin;
		this.username = username;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public boolean isAdmin() {
		return admin;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	@Override
	public String toString() {
		return username + ";" + password + ";" + isAdmin();
	}
}
