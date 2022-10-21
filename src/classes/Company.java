/**
 * 
 */
package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Brijesh Patel
 *
 */
public class Company {

	protected static final String PATH = "C:\\Users\\bjpat\\Desktop";
	protected static final String MAIN_FOLDER_PATH = PATH.concat("\\").concat("POS_TEST_DATABASE");
	protected static final String USER_FOLDER_PATH = MAIN_FOLDER_PATH.concat("\\").concat("user");
	protected static final String MATERIAL_FOLDER_PATH = MAIN_FOLDER_PATH.concat("\\").concat("material");
	protected static final String REPORT_FOLDER_PATH = MAIN_FOLDER_PATH.concat("\\").concat("report");
	
	private static ArrayList<User> user_list = new ArrayList<User>();
	private static ArrayList<Material> material_list =  new ArrayList<Material>();
	private static FileWritter writer = new FileWritter();
	private static FileReader reader = new FileReader();
	

	/**
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
//		addUser(user_id, user_name, first_name, last_name, password, email, phone_number);
	}
	
	public Company() {
		check_database_location();
		try {
			user_list = reader.fetch_user_list();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			material_list = reader.fetch_material_list();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void check_database_location() {
		System.out.println("Checking Database Location...");
		File folder = new File(MAIN_FOLDER_PATH);
		if(!folder.exists()) {
			System.out.println("Main Folder does not exist...");
			folder.mkdir();
		}else{
			System.out.println("Main Folder Exists...");
		}
		
		folder = new File(USER_FOLDER_PATH);
		if(!folder.exists()) {
			System.out.println("User Folder does not exist...");
			folder.mkdir();
		}else{
			System.out.println("User Folder Exists...");
		}
		
		folder = new File(MATERIAL_FOLDER_PATH);
		if(!folder.exists()) {
			System.out.println("Material Folder does not exist...");
			folder.mkdir();
		}else{
			System.out.println("Material Folder Exists...");
		}

	    LocalDate today = LocalDate.now();
	    Integer year = today.getYear();
		folder = new File(REPORT_FOLDER_PATH);
		if(!folder.exists()) {
			System.out.println("Report Folder does not exist...");
			folder.mkdir();

			String year_folder_path = REPORT_FOLDER_PATH.concat("\\").concat(year.toString());
			folder = new File(year_folder_path);
			folder.mkdir();
		}else{
			System.out.println("Report Folder Exists...");
			String year_folder_path = REPORT_FOLDER_PATH.concat("\\").concat(year.toString());
			folder = new File(year_folder_path);
			if(!folder.exists()) {
				System.out.println("Year Folder does not exist...");
				folder.mkdir();
			}else {
				System.out.println("Year Folder Exists...");
			}
		}
	}
	

	/**
	 * @return checks for login credentials
	 */
	public Boolean check_login(String user_name, String password) {
		for(int i=0;i<user_list.size();i++) {
			User t_user = user_list.get(i);
			
			if(t_user.getUser_name().equals(user_name) && t_user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
    /**
     * @return searches user from user_list
     */
    protected User getUser(String user_id) {
        User user = null;
        for(int i=0;i<user_list.size();i++) {
            User t_user = user_list.get(i);
            if(t_user.getId() == user_id) {
                user = t_user;
            }
        }
        return user;
    }
    /**
     * @return searches material from material_list
     */
    protected static Material getMaterial(String item_id) {
        Material material = null;
        for(int i=0;i<material_list.size();i++) {
            Material t_material = material_list.get(i);
            if(t_material.getId() == item_id) {
                material = t_material;
            }
        }
        return material;
    }
	/**
	 * @return the user_list
	 */
	protected ArrayList<User> getUser_list() {
		return user_list;
	}
	/**
	 * @return the material_list
	 */
	protected ArrayList<Material> getMaterial_list() {
		return material_list;
	}
	
	/**
	 *  Adds new User
	 */
	protected static void addUser(String user_id, String user_name, String first_name, String last_name, String password, String email, String phone_number) {
		User user = new User(user_id, user_name, first_name, last_name, password, email, phone_number);
		user_list.add(user);
		String file_data = user.getId() + "," + user.getUser_name() + "," + user.getFirst_name() + "," + user.getLast_name() + "," + user.getPassword() + "," + user.getEmail() + "," + user.getPhone_number();
		try {
			writer.write(USER_FOLDER_PATH.concat("\\").concat(user.getId()).concat(".txt"), file_data);
			System.out.println("New Material Created...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 *  Adds new Material
	 */
	protected void addMaterial(String material_id, String name, String description, Long qty, Double unit_price) {
		Material material = new Material(material_id, name, description, qty, unit_price);
		material_list.add(material);
		String file_data = material.getId() + "," + material.getName() + "," + material.getDescription() + "," + material.getQty() + "," + material.getUnit_price();
		try {
			writer.write(USER_FOLDER_PATH.concat("\\").concat(material.getId()).concat(".txt"), file_data);
			System.out.println("New User Created...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
