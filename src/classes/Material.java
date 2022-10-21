/**
 * 
 */
package classes;

import java.util.Random;

/**
 * @author Brijesh Patel
 *
 */
public class Material {
	
	private String id;
	private String name;
	private String description;
	private long qty;
	private double unit_price;
	private double TAX = 0.13;
	

	/**Constructor
	 * @param id
	 * @param name
	 * @param description
	 * @param qty
	 * @param unit_price
	 */
	public Material(String id, String name, String description, long qty, double unit_price) {

		if(id != "") {
			this.id = id;
		}else {
			this.id = Material.generateId();
		}
		this.name = name;
		this.description = description;
		this.qty = qty;
		this.unit_price = unit_price;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		Material material = new Material("", "Pencil", "0.7mm led pencil", 57, 7.49);
//	
//		System.out.println("Material:");
//		System.out.println("id: " + material.getId());
//		System.out.println("Name: " + material.getName());
//		System.out.println("Description: " + material.getDescription());
//		System.out.println("Qty: " + material.getQty());
//		System.out.println("Unit Price: " + material.getUnit_price());
	
	}
	/**
	 * @return generated material_id
	 */
	private static String generateId() {
		Random rnd = new Random();
		return "M-" + 
				rnd.nextInt(9) + rnd.nextInt(9) + rnd.nextInt(9) + 
				rnd.nextInt(9) + rnd.nextInt(9) + rnd.nextInt(9) + 
				rnd.nextInt(9) + rnd.nextInt(9) + rnd.nextInt(9);
	}

	/**
	 * @return the name
	 */
	protected String getId() {
		return this.id;
	}
	/**
	 * @return the name
	 */
	protected String getName() {
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	protected void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	protected String getDescription() {
		return this.description;
	}

	/**
	 * @param description the description to set
	 */
	protected void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the qty
	 */
	protected long getQty() {
		return this.qty;
	}

	/**
	 * @param qty the qty to set
	 */
	protected void setQty(long qty) {
		this.qty = qty;
	}

	/**
	 * @return the unit_price
	 */
	protected double getUnit_price() {
		return this.unit_price;
	}

	/**
	 * @param unit_price the unit_price to set
	 */
	protected void setUnit_price(float unit_price) {
		this.unit_price = unit_price;
	}
	
	/**
	 * @return returns material tax
	 */
	protected double getTax() {
		return this.TAX;
	}
	
	/**
	 * @return True/False if material has tax
	 */
	protected boolean hasTax() {
		if(this.TAX > 0) {
			return true;
		}else {
			return false;
		}
	}


}
