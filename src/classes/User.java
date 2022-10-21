/**
 * 
 */
package classes;

import java.util.Random;

/**
 * @author Brijesh Patel
 *
 */
public class User {
	private String id;
	private String user_name;
	private String first_name;
	private String last_name;
	private String password;
	private String email;
	private String phone_number;
	
	
	
	
	/**Constructor
	 * @param id
	 * @param user_name
	 * @param first_name
	 * @param last_name
	 * @param password
	 * @param email
	 * @param phone_number
	 */
	public User(String id, String user_name, String first_name, String last_name, String password, String email, String phone_number) {
		
		if(id != "") {
			this.id = id;
		}else {
			this.id = User.generateId();
		}
		this.user_name = user_name;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.email = email;
		this.phone_number = phone_number;
	}

	/** Class main test function
	 * @param args
	 */
	public static void main(String[] args) {
//		String user_id = "U-12345";
//		String user_name = "brijesh";
//		String first_name = "Brijesh";
//		String last_name = "Patel";
//		String password = "qwerty123";
//		String email = "brijesh@email.com";
//		String phone_number = "123-456-7890";
//
//		User user = new User(user_id, user_name, first_name, last_name, password, email, phone_number);
//		System.out.println("User:");
//		System.out.println("user_id: " + user.getId());
//		System.out.println("User Name: " + user.getUser_name());
//		System.out.println("First Name: " + user.getFirst_name());
//		System.out.println("Last Name: " + user.getLast_name());
//		System.out.println("Password: " + user.getPassword());
//		System.out.println("Email: " + user.getEmail());
//		System.out.println("Phone: " + user.getPhone_number());
	}
	/**
	 * @return generated user_id
	 */
	private static String generateId() {
		Random rnd = new Random();
		return "U-" + rnd.nextInt(9) + rnd.nextInt(9) + rnd.nextInt(9) + rnd.nextInt(9) + rnd.nextInt(9);
	}
	/**
	 * @return the id
	 */
	protected String getId() {
		return id;
	}
	/**
	 * @return gets the user_name
	 */
	protected String getUser_name() {
		return user_name;
	}
	/**
	 * @param  sets the user_name
	 */
	protected void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	/**
	 * @return the first_name
	 */
	protected String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	protected void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	protected String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	protected void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @return the password
	 */
	protected String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	protected void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the email
	 */
	protected String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	protected void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone_number
	 */
	protected String getPhone_number() {
		return phone_number;
	}
	/**
	 * @param phone_number the phone_number to set
	 */
	protected void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	
	
	
}
