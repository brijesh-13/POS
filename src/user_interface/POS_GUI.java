/**
 * 
 */
package user_interface;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.eclipse.swt.graphics.Font;

import classes.CartMaterial;
import classes.Company;

/**
 * @author Brijesh Patel
 *
 */
public class POS_GUI implements ActionListener {

	final static POS_GUI window = new POS_GUI();
	final static Company company = new Company();

    private JFrame frame = new JFrame();
    private JPanel cart_panel;
    private JScrollPane scrollable_cart_panel;
    
	final Integer login_panel_width = 275;
	final Integer login_panel_height = 275;
	private Integer frame_width = 700;
	private Integer frame_height = 550;
	
	private Integer header_height = 50;
	private Integer header_button_width = 100;
	private Integer footer_height = 50;
	private static  JLabel lbl_cart_total;
	private static  JLabel lbl_cart_sub_total;
	private static  JLabel lbl_cart_tax;
	private static java.awt.Font pos_quick_btn_font = new java.awt.Font("Arial", java.awt.Font.BOLD, 20);
    
	private static ArrayList<CartMaterial> cart_list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public POS_GUI() {
		login_initializer();
//		pos_initializer();
		

		frame.addComponentListener(new ComponentAdapter() 
		{  
		        public void componentResized(ComponentEvent evt) {
		        	frame_resize();
		        }
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void login_initializer() {
        frame.setSize(frame_width, frame_height);  
		frame.setTitle("POS Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.lightGray);
		
        JPanel login_panel = new JPanel();
        JPanel header_panel = new JPanel();
		JPanel login_form = new JPanel();
		
        header_panel.setPreferredSize(new Dimension(frame_width, (frame_height - login_panel_height)/2));

        login_form.setMaximumSize(new Dimension(login_panel_width,login_panel_height));
        login_form.setMinimumSize(new Dimension(login_panel_width,login_panel_height));
        login_form.setPreferredSize(new Dimension(login_panel_width,login_panel_height));
        login_form.setBackground(Color.gray);

		
        JLabel lbl_login = new JLabel("ID: ");
        JLabel lbl_password = new JLabel("Password: ");
        JTextField txt_login = new JTextField();
        JPasswordField txt_password = new JPasswordField();
        txt_login.setText("brijesh");
        txt_password.setText("qwerty123");

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        p.setMaximumSize(new Dimension(175,145));
        p.setMinimumSize(new Dimension(175,145));
        p.setPreferredSize(new Dimension(175,145));
        p.setBackground(Color.gray);

        JPanel p_header = new JPanel();
        p_header.setPreferredSize(new Dimension(175,45));
        p_header.setBackground(Color.gray);
        
        JButton btn_login = new JButton("Login");
        btn_login.setMaximumSize(new Dimension(175,30));
        btn_login.setMinimumSize(new Dimension(175,30));
        btn_login.setPreferredSize(new Dimension(175,30));
        btn_login.addActionListener(new ActionListener() { 
        	  public void actionPerformed(ActionEvent e) { 
        			System.out.println("Login Button Clicked: ");
        			String user_name = txt_login.getText();
        			String password = new String(txt_password.getPassword());
					if(company.check_login(user_name, password)){
						System.out.println("Login Successfull!");
						frame.remove(login_panel);
				        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				        frame_width = frame.getWidth();
				        frame_height = frame.getHeight();
						pos_initializer();
					}else {
						System.out.println("Invalid user_name and/or password... Please try again!");
					}
        		  } 
        		} );

        p.add(lbl_login);
        p.add(txt_login);
        p.add(new JLabel("     "));
        p.add(lbl_password);
        p.add(txt_password);
        p.add(new JLabel("     "));
        p.add(btn_login);

        login_form.add(p_header, BorderLayout.NORTH);
        login_form.add(p, BorderLayout.CENTER);
        

        login_panel.add(header_panel, BorderLayout.NORTH);
        login_panel.add(login_form);         

        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                // This is only called when the user releases the mouse button.
//                System.out.println("componentResized");
                frame_width = frame.getWidth();
                frame_height = frame.getHeight();
                header_panel.setPreferredSize(new Dimension(frame_width, (frame_height - login_panel_height)/2));
            }
        });
        
        frame.getContentPane().add(login_panel);
        frame.validate();
	}
	
	private void pos_initializer() {
	    cart_list = new ArrayList<CartMaterial>();
		frame.setTitle("POS View");
		
		JPanel pos_panel = new JPanel();
		pos_panel.setBackground(Color.lightGray);
		pos_panel.setLayout(new BorderLayout());

		JPanel header_panel = new JPanel();
		header_panel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		header_panel.setMinimumSize(new Dimension(frame_width, header_height));
		header_panel.setMaximumSize(new Dimension(frame_width, header_height));
		header_panel.setPreferredSize(new Dimension(frame_width, header_height));
		header_panel.setBackground(Color.darkGray);
        JButton btn_manage = new JButton("Manage");
        btn_manage.setMinimumSize(new Dimension(header_button_width, header_height));
        btn_manage.setMaximumSize(new Dimension(header_button_width, header_height));
        btn_manage.setPreferredSize(new Dimension(header_button_width, header_height));
        btn_manage.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 17));
        header_panel.add(btn_manage);
        btn_manage.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
              System.out.println("Manage Button Clicked...");
              frame.remove(pos_panel);
              management_initializer();
            } 
        });
		
		JPanel footer_panel = new JPanel();
		footer_panel.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
		footer_panel.setMinimumSize(new Dimension(frame_width, footer_height));
		footer_panel.setMaximumSize(new Dimension(frame_width, footer_height));
		footer_panel.setPreferredSize(new Dimension(frame_width, footer_height));
		footer_panel.setBackground(Color.darkGray);
		JPanel footer_right_panel = new JPanel();
		footer_right_panel.setMinimumSize(new Dimension(700, footer_height));
		footer_right_panel.setMaximumSize(new Dimension(700, footer_height));
		footer_right_panel.setPreferredSize(new Dimension(700, footer_height));
        footer_right_panel.setBackground(Color.darkGray);
		lbl_cart_total = new JLabel();
		lbl_cart_total.setHorizontalTextPosition(JLabel.LEFT);
		lbl_cart_total.setMinimumSize(new Dimension(150, footer_height));
		lbl_cart_total.setMaximumSize(new Dimension(150, footer_height));
		lbl_cart_total.setPreferredSize(new Dimension(150, footer_height));
        lbl_cart_tax = new JLabel();
        lbl_cart_tax.setHorizontalTextPosition(JLabel.LEFT);
        lbl_cart_tax.setMinimumSize(new Dimension(150, footer_height));
        lbl_cart_tax.setMaximumSize(new Dimension(150, footer_height));
        lbl_cart_tax.setPreferredSize(new Dimension(150, footer_height));
        lbl_cart_sub_total = new JLabel();
        lbl_cart_sub_total.setHorizontalTextPosition(JLabel.LEFT);
        lbl_cart_sub_total.setMinimumSize(new Dimension(150, footer_height));
        lbl_cart_sub_total.setMaximumSize(new Dimension(150, footer_height));
        lbl_cart_sub_total.setPreferredSize(new Dimension(150, footer_height));
        JLabel tmp_lbl = new JLabel("Sub-Total: ");
        tmp_lbl.setForeground(Color.white);
        tmp_lbl.setHorizontalTextPosition(JLabel.RIGHT);
        footer_panel.add(tmp_lbl);
        footer_panel.add(lbl_cart_sub_total);
        tmp_lbl = new JLabel("Tax: ");
        tmp_lbl.setForeground(Color.white);
        tmp_lbl.setHorizontalTextPosition(JLabel.RIGHT);
        footer_panel.add(tmp_lbl);
        footer_panel.add(lbl_cart_tax);
        tmp_lbl = new JLabel("Total: ");
        tmp_lbl.setForeground(Color.white);
        tmp_lbl.setHorizontalTextPosition(JLabel.RIGHT);
        footer_panel.add(tmp_lbl);
        footer_panel.add(lbl_cart_total);
        footer_panel.add(footer_right_panel);
		

        JPanel view_panel = new JPanel();
        JPanel  left_panel = new JPanel ();
        JPanel  right_panel = new JPanel ();

//		view_panel.setLayout(new BoxLayout(view_panel, BoxLayout.X_AXIS));
		view_panel.setLayout(new BorderLayout());
		view_panel.setBackground(Color.lightGray);
		view_panel.setMinimumSize(new Dimension(frame_width,frame_height - 100));
		view_panel.setMaximumSize(new Dimension(frame_width,frame_height - 100));
		view_panel.setPreferredSize(new Dimension(frame_width,frame_height - 100));
		
		right_panel = new JPanel();
		right_panel.setBackground(Color.lightGray);
		right_panel.setLayout(new GridLayout(5,1));
		right_panel.setMinimumSize(new Dimension(700, view_panel.getHeight()));
		right_panel.setMaximumSize(new Dimension(700, view_panel.getHeight()));
		right_panel.setPreferredSize(new Dimension(700, view_panel.getHeight()));
		JPanel panel_1 = new JPanel(new GridLayout(1, 5));
		panel_1.setMinimumSize(new Dimension(700, 100));
		panel_1.setMaximumSize(new Dimension(700, 100));
		panel_1.setPreferredSize(new Dimension(700, 100));
		JButton tmp_btn = new JButton();
		panel_1.add(new JButton("1"));
		panel_1.add(new JButton("2"));
		panel_1.add(new JButton("3"));
		panel_1.add(new JButton("4"));
        JButton btn_logout = new JButton("Log Out");
        btn_logout.setFont(pos_quick_btn_font);
        btn_logout.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
              System.out.println("Log Out Button Clicked...");
              frame.remove(pos_panel);
              login_initializer();
            } 
        });
        panel_1.add(btn_logout);
		JPanel panel_2 = new JPanel(new GridLayout(1, 5));
		panel_2.setMinimumSize(new Dimension(700, 100));
		panel_2.setMaximumSize(new Dimension(700, 100));
		panel_2.setPreferredSize(new Dimension(700, 100));
		panel_2.add(new JButton("6"));
		panel_2.add(new JButton("7"));
		panel_2.add(new JButton("8"));
		panel_2.add(new JButton("9"));
		panel_2.add(new JButton("10"));
		JPanel panel_3 = new JPanel(new GridLayout(1, 5));
		panel_3.setMinimumSize(new Dimension(700, 100));
		panel_3.setMaximumSize(new Dimension(700, 100));
		panel_3.setPreferredSize(new Dimension(700, 100));
        tmp_btn = new JButton("Debit Exact");
        tmp_btn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 19));
        panel_3.add(tmp_btn);
        tmp_btn = new JButton("Cash Exact");
        tmp_btn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 19));
        panel_3.add(tmp_btn);
        tmp_btn = new JButton("Cash");
        tmp_btn.setFont(pos_quick_btn_font);
        panel_3.add(tmp_btn);
        tmp_btn = new JButton("No Sale");
        tmp_btn.setFont(pos_quick_btn_font);
        panel_3.add(tmp_btn);
        tmp_btn = new JButton("Hold/Recall");
        tmp_btn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 19));
        panel_3.add(tmp_btn);
		JPanel panel_4 = new JPanel(new GridLayout(1, 5));
		panel_4.setMinimumSize(new Dimension(700, 100));
		panel_4.setMaximumSize(new Dimension(700, 100));
		panel_4.setPreferredSize(new Dimension(700, 100));
        tmp_btn = new JButton("$5");
        tmp_btn.setFont(pos_quick_btn_font);
        panel_4.add(tmp_btn);
        tmp_btn = new JButton("$10");
        tmp_btn.setFont(pos_quick_btn_font);
        panel_4.add(tmp_btn);
        tmp_btn = new JButton("$20");
        tmp_btn.setFont(pos_quick_btn_font);
        panel_4.add(tmp_btn);
        tmp_btn = new JButton("$50");
        tmp_btn.setFont(pos_quick_btn_font);
        panel_4.add(tmp_btn);
        tmp_btn = new JButton("$100");
        tmp_btn.setFont(pos_quick_btn_font);
        panel_4.add(tmp_btn);
		JPanel panel_5 = new JPanel(new GridLayout(1, 5));
		panel_5.setMinimumSize(new Dimension(700, 100));
		panel_5.setMaximumSize(new Dimension(700, 100));
		panel_5.setPreferredSize(new Dimension(700, 100));
        tmp_btn = new JButton("Qty +1");
        tmp_btn.setFont(pos_quick_btn_font);
        panel_5.add(tmp_btn);
        tmp_btn = new JButton("Qty +2");
        tmp_btn.setFont(pos_quick_btn_font);
        panel_5.add(tmp_btn);
        tmp_btn = new JButton("@ Qty");
        tmp_btn.setFont(pos_quick_btn_font);
        panel_5.add(tmp_btn);
        tmp_btn = new JButton("Qty -1");
        tmp_btn.setFont(pos_quick_btn_font);
        panel_5.add(tmp_btn);
        tmp_btn = new JButton("Edit Items");
        tmp_btn.setFont(pos_quick_btn_font);
        panel_5.add(tmp_btn);
		right_panel.add(panel_1);
		right_panel.add(panel_2);
		right_panel.add(panel_3);
		right_panel.add(panel_4);
		right_panel.add(panel_5);
		
		left_panel = new JPanel();
        left_panel.setBackground(Color.lightGray);
        left_panel.setLayout(new BorderLayout());
        left_panel.setMinimumSize(new Dimension(frame_width - 700, view_panel.getHeight()));
        left_panel.setMaximumSize(new Dimension(frame_width - 700, view_panel.getHeight()));
        left_panel.setPreferredSize(new Dimension(frame_width - 700, view_panel.getHeight()));
        JPanel basket_header = new JPanel();
        basket_header.setBackground(Color.gray);
        basket_header.setLayout(new FlowLayout(FlowLayout.TRAILING));
        basket_header.setMinimumSize(new Dimension(frame_width - 700, 25));
        basket_header.setMaximumSize(new Dimension(frame_width - 700, 25));
        basket_header.setPreferredSize(new Dimension(frame_width - 700, 25));
        JLabel lbl_qty = new JLabel("Qty",SwingConstants.CENTER);
        lbl_qty.setMinimumSize(new Dimension(50, 25));
        lbl_qty.setMaximumSize(new Dimension(50, 25));
        lbl_qty.setPreferredSize(new Dimension(50, 25));
        JLabel lbl_price = new JLabel("Price",SwingConstants.CENTER);
        lbl_price.setMinimumSize(new Dimension(100, 25));
        lbl_price.setMaximumSize(new Dimension(100, 25));
        lbl_price.setPreferredSize(new Dimension(100, 25));
        JLabel lbl_tax = new JLabel("Tax",SwingConstants.CENTER);
        lbl_tax.setMinimumSize(new Dimension(50, 25));
        lbl_tax.setMaximumSize(new Dimension(50, 25));
        lbl_tax.setPreferredSize(new Dimension(50, 25));
        JLabel lbl_total = new JLabel("Total",SwingConstants.CENTER);
        lbl_total.setMinimumSize(new Dimension(100, 25));
        lbl_total.setMaximumSize(new Dimension(100, 25));
        lbl_total.setPreferredSize(new Dimension(100, 25));
        JLabel lbl_description = new JLabel("Description",SwingConstants.CENTER);
        lbl_description.setMinimumSize(new Dimension((frame_width - 700 - 306), 25));
        lbl_description.setMaximumSize(new Dimension((frame_width - 700 - 306), 25));
        lbl_description.setPreferredSize(new Dimension((frame_width - 700 - 306), 25));
        JLabel lbl_filler = new JLabel("",SwingConstants.CENTER);
        lbl_filler.setMinimumSize(new Dimension(6, 25));
        lbl_filler.setMaximumSize(new Dimension(6, 25));
        lbl_filler.setPreferredSize(new Dimension(6, 25));
        basket_header.add(lbl_description);
        basket_header.add(lbl_qty);
        basket_header.add(lbl_price);
        basket_header.add(lbl_tax);
        basket_header.add(lbl_filler);
        cart_panel = new JPanel();
        cart_panel.setLayout(new BoxLayout(cart_panel, BoxLayout.Y_AXIS));
        scrollable_cart_panel = new JScrollPane(cart_panel);
        scrollable_cart_panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
        scrollable_cart_panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        scrollable_cart_panel.setMinimumSize(new Dimension(frame_width - 700, view_panel.getHeight()));
        scrollable_cart_panel.setMaximumSize(new Dimension(frame_width - 700, view_panel.getHeight()));
        scrollable_cart_panel.setPreferredSize(new Dimension(frame_width - 700, view_panel.getHeight()));
        left_panel.add(basket_header, BorderLayout.NORTH);
        left_panel.add(scrollable_cart_panel);
        
		view_panel.add(right_panel, BorderLayout.EAST);
		view_panel.add(left_panel);

		pos_panel.add(header_panel, BorderLayout.NORTH);
		pos_panel.add(view_panel);
		pos_panel.add(footer_panel, BorderLayout.SOUTH);
		
		
		
		frame.getContentPane().add(pos_panel);
		frame.validate();
	}

	private void management_initializer() {
        frame.setTitle("Management View");
        
        JPanel management_panel = new JPanel();
        management_panel.setBackground(Color.lightGray);
        management_panel.setLayout(new BorderLayout());

        JPanel header_panel = new JPanel();
        header_panel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        header_panel.setMinimumSize(new Dimension(frame_width, header_height));
        header_panel.setMaximumSize(new Dimension(frame_width, header_height));
        header_panel.setPreferredSize(new Dimension(frame_width, header_height));
        header_panel.setBackground(Color.darkGray);
        JButton btn = new JButton("POS");
        btn.setMinimumSize(new Dimension(header_button_width, header_height));
        btn.setMaximumSize(new Dimension(header_button_width, header_height));
        btn.setPreferredSize(new Dimension(header_button_width, header_height));
        btn.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 17));
        header_panel.add(btn);
        btn.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                System.out.println("Manage Button Clicked...");
                frame.remove(management_panel);
                pos_initializer();
            } 
        });
        
        JTabbedPane management_tab_view_panel = new JTabbedPane();
        management_tab_view_panel.setBackground(Color.white);

        JPanel inventory_panel = new JPanel();
        inventory_panel.setBackground(Color.black);
        JPanel reports_panel = new JPanel();
        reports_panel.setBackground(Color.blue);
        JPanel accounts_panel = new JPanel();
        accounts_panel.setBackground(Color.white);
        JPanel search_con = new JPanel();
        search_con.setMinimumSize(new Dimension(frame_width, 100));
        search_con.setMaximumSize(new Dimension(frame_width, 100));
        search_con.setPreferredSize(new Dimension(frame_width, 100));
        search_con.setBackground(Color.white);
        JPanel search_panel = new JPanel();
        search_panel.setLayout(new BoxLayout(search_panel, BoxLayout.X_AXIS));
        search_panel.setBounds(frame_width/2-350, 25, 700, 25);
        search_panel.setMinimumSize(new Dimension(700, 25));
        search_panel.setMaximumSize(new Dimension(700, 25));
        search_panel.setPreferredSize(new Dimension(700, 25));
        search_panel.setBackground(Color.white);
        JTextField txt_search = new JTextField();
        txt_search.setMinimumSize(new Dimension(600, 25));
        txt_search.setMaximumSize(new Dimension(600, 25));
        txt_search.setPreferredSize(new Dimension(600, 25));
        JButton btn_search = new JButton("Search");
        btn_search.setMinimumSize(new Dimension(100, 24));
        btn_search.setMaximumSize(new Dimension(100, 24));
        btn_search.setPreferredSize(new Dimension(100, 24));
        search_panel.add(txt_search);
        search_panel.add(btn_search);
        
        search_con.add(search_panel);
        
        
        accounts_panel.add(search_con);

        management_tab_view_panel.add("Accounts", accounts_panel);
        management_tab_view_panel.add("Inventory", inventory_panel);
        management_tab_view_panel.add("Reports", reports_panel);
        
        management_panel.add(header_panel, BorderLayout.NORTH);
        management_panel.add(management_tab_view_panel);

        
        frame.getContentPane().add(management_panel);
        frame.validate();
	}
	
	public void refresh_cart() {
	    for (CartMaterial item : cart_list){ 
            JPanel item_panel = new JPanel();
            item_panel.setLayout(new FlowLayout(FlowLayout.TRAILING));
            item_panel.setMinimumSize(new Dimension(frame_width - 725, 25));
            item_panel.setMaximumSize(new Dimension(frame_width - 725, 25));
            item_panel.setPreferredSize(new Dimension(frame_width - 725, 25));
            JLabel lbl_qty = new JLabel(""+item.getQty(), SwingConstants.CENTER);
            lbl_qty.setMinimumSize(new Dimension(50, 25));
            lbl_qty.setMaximumSize(new Dimension(50, 25));
            lbl_qty.setPreferredSize(new Dimension(50, 25));
            JLabel lbl_price = new JLabel(""+item.getUnit_price(),SwingConstants.CENTER);
            lbl_price.setMinimumSize(new Dimension(100, 25));
            lbl_price.setMaximumSize(new Dimension(100, 25));
            lbl_price.setPreferredSize(new Dimension(100, 25));
            JLabel lbl_tax = new JLabel(""+item.getTAX()+"%",SwingConstants.CENTER);
            lbl_tax.setMinimumSize(new Dimension(50, 25));
            lbl_tax.setMaximumSize(new Dimension(50, 25));
            lbl_tax.setPreferredSize(new Dimension(50, 25));
            JLabel lbl_total = new JLabel(""+item.getTotal(),SwingConstants.CENTER);
            lbl_total.setMinimumSize(new Dimension(100, 25));
            lbl_total.setMaximumSize(new Dimension(100, 25));
            lbl_total.setPreferredSize(new Dimension(100, 25));
            JLabel lbl_description = new JLabel(item.getDescription(),SwingConstants.CENTER);
            lbl_description.setMinimumSize(new Dimension((frame_width - 700 - 300), 25));
            lbl_description.setMaximumSize(new Dimension((frame_width - 700 - 300), 25));
            lbl_description.setPreferredSize(new Dimension((frame_width - 700 - 300), 25));
            item_panel.add(lbl_description);
            item_panel.add(lbl_qty);
            item_panel.add(lbl_price);
            item_panel.add(lbl_tax);
            cart_panel.add(item_panel);
        }
	}

	private void frame_resize() {
    	frame_width = frame.getWidth();
    	frame_height = frame.getHeight();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Button Clicked: "+ e);
	}

}
