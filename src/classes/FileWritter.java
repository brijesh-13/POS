/**
 * 
 */
package classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Brijesh Patel
 *
 */
class FileWritter {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String user_id = "U-12345";
//		String user_name = "brijesh";
//		String first_name = "Brijesh";
//		String last_name = "Patel";
//		String password = "qwerty123";
//		String email = "brijesh@email.com";
//		String phone_number = "123-456-7890";
//
//		User user = new User(user_id, user_name, first_name, last_name, password, email, phone_number);
//		String file_data = user.getId() + "," + user.getUser_name() + "," + user.getFirst_name() + "," + user.getLast_name() + "," + user.getPassword() + "," + user.getEmail() + "," + user.getPhone_number();
//		try {
//			write(Company.USER_FOLDER_PATH.concat("\\").concat(user.getId()).concat(".txt"), file_data);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	/**append function updates file data given the file name and file data
	 * @param file_name
	 * @param file_data
	 * @throws IOException
	 */
	public void append(String file_name, String file_data) throws IOException {
        // Creates a FileReader specifying the encoding 
		File file = new File(file_name);
		if(!file.exists()) {
			System.out.println("create new file...");
			file.createNewFile();
		}
        FileWriter fw = new FileWriter(file, true); 
        fw.write(file_data);
        fw.close(); 
        // Closes the reader 
	}

	/**write function replaces and writes file data given the file name and file data
	 * @param file_name
	 * @param file_data
	 * @throws IOException
	 */
	public void write(String file_name, String file_data) throws IOException {
        // Creates a FileReader specifying the encoding 
		File file = new File(file_name);
		if(!file.exists()) {
			System.out.println("create new file...");
			file.createNewFile();
		}
        FileWriter fw = new FileWriter(file, false); 
        fw.write(file_data);
        fw.close(); 
        // Closes the reader 
	}
	

}
