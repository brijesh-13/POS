/**
 * 
 */
package classes;

/**
 * @author Brijesh Patel
 *
 */
public class CartMaterial {
    private String item_id;
    private String name;
    private String description;
    private long qty;
    private double unit_price;
    private double total;
    private double TAX = 0.13;
    
    public CartMaterial(String item_id, long qty) {
        Material material = Company.getMaterial(item_id);
        if(material != null) {
            this.description = material.getDescription();
            this.name = material.getName();
            this.unit_price = material.getUnit_price();
            this.TAX = material.getTax();
        }
        this.qty = qty;
        if(qty != 0) {
            this.total = this.unit_price * this.qty;
        }
    }

    /**
     * @return the item_id
     */
    public String getItem_id() {
        return item_id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the qty
     */
    public long getQty() {
        return qty;
    }

    /**
     * @return the unit_price
     */
    public double getUnit_price() {
        return unit_price;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @return the tAX
     */
    public double getTAX() {
        return TAX;
    }
    
}
