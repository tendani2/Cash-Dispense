package fnb.coin.dispenser.resful.api;

import org.springframework.beans.factory.annotation.Value;

/**
 * LoginCredentials
 * @author Tendani
 *
 */
public class LoginCredentials {
	// Username
	private String username;
	// Password
	private String password;
	
	public LoginCredentials(){}
	
	/**
	 * Login Credentials
	 * @param username
	 * @param password
	 */
	public LoginCredentials(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Gets username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Sets username.
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * Gets password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
