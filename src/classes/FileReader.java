/**
 * 
 */
package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Brijesh Patel
 *
 */
public class FileReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**Read file data given the file name
	 * @param file_name
	 * @param file_data
	 * @throws FileNotFoundException 
	 */
	protected ArrayList<String> read(String file_name) throws FileNotFoundException {
		ArrayList<String> file_data = new ArrayList<String>();
		File file = new File(file_name);
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			file_data.add(line);
		}
		sc.close();
		return file_data;
	}

	/**Fetches all the users stored
	 * @throws FileNotFoundException 
	 */
	protected ArrayList<User> fetch_user_list() throws FileNotFoundException {
		ArrayList<User> user_list = new ArrayList<User>();
		File folder = new File(Company.USER_FOLDER_PATH);
		File[] file_list = folder.listFiles();

		for (File file : file_list) {
		    if (file.isFile()) {
				Scanner sc = new Scanner(file);
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					String[] str_arr = line.split(",");
					
					if(line.length() >= 7) {
						String user_id = str_arr[0];
						String user_name = str_arr[1];
						String first_name = str_arr[2];
						String last_name = str_arr[3];
						String password = str_arr[4];
						String email = str_arr[5];
						String phone_number = str_arr[6];
		
						User user = new User(user_id, user_name, first_name, last_name, password, email, phone_number);
						System.out.println("User_name: " + user.getUser_name());
						System.out.println("password: " + user.getPassword());
						user_list.add(user);
					}
				}
				sc.close();
		    }
		}
		
		return user_list;
	}

	/**Fetches all the materials stored
	 * @throws FileNotFoundException 
	 */
	protected ArrayList<Material> fetch_material_list() throws FileNotFoundException {
		ArrayList<Material> material_list = new ArrayList<Material>();
		File folder = new File(Company.MATERIAL_FOLDER_PATH);
		File[] file_list = folder.listFiles();

		for (File file : file_list) {
		    if (file.isFile()) {
				Scanner sc = new Scanner(file);
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					String[] str_arr = line.split(",");
					
					if(line.length() >= 5) {
						String material_id = str_arr[0];
						String name = str_arr[1];
						String description = str_arr[2];
						Long qty = Long.parseLong(str_arr[3]);
						Double unit_price = Double.parseDouble(str_arr[4]);
		
						Material material = new Material(material_id, name, description, qty, unit_price);
						material_list.add(material);
					}
				}
				sc.close();
		    }
		}
		return material_list;
	}
	
	
}
