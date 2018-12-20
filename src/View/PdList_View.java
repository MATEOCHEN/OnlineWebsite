package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller_Mediator.Home1_Controller;
import Controller_Mediator.ProductList_Controller;

import javax.swing.JButton;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.JTextArea;

public class PdList_View extends JFrame {

	public JPanel contentPane;
	public String[] name = new String[30];
	public int[] price = new int[30];
	public ImageIcon[] icon = new ImageIcon[30];
	private JButton Login;
	private ProductList_Controller productlist_Controller;
	JButton Notice_btn;
	ImageIcon empty = new ImageIcon("src/empty.png");
	
	JButton Product1 = new JButton("");
	JButton Product2 = new JButton("");
	JButton Product3 = new JButton("");
	JButton Product4 = new JButton("");
	JButton Product5 = new JButton("");
	JButton Product6 = new JButton("");
	
	JLabel product1_name = new JLabel("product name");
	JLabel product1_price = new JLabel("price");
	
	JLabel product2_name = new JLabel("product name");
	JLabel product2_price = new JLabel("price");
	
	JLabel product3_name = new JLabel("product name");
	JLabel product3_price = new JLabel("price");
	
	JLabel product4_name = new JLabel("product name");
	JLabel product4_price = new JLabel("price");
	
	JLabel product5_name = new JLabel("product name");
	JLabel product5_price = new JLabel("price");
	
	JLabel product6_name = new JLabel("product name");
	JLabel product6_price = new JLabel("price");
	JLabel name1;
	//-------------------------------
	
	public PdList_View() {
		setTitle("Product List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Home = new JButton("Home");
		Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAll();
				productlist_Controller.CallHome();
			}
		});
		Home.setBounds(0, 0, 87, 23);
		contentPane.add(Home);
		
		Login = new JButton("Login&Register");
		Login.setBounds(148, 0, 130, 23);
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Login.getText() == "Login&Register") {
					productlist_Controller.CallLogin();
				} else {
					productlist_Controller.setName("Hello~ Guest");
					productlist_Controller.SetLoginName("Login&Register");	//used trigger log out button
					productlist_Controller.setGuestAccount();
				}
			}
		});
		contentPane.add(Login);
		
		JButton Shopping_cart_btn = new JButton("");
		Shopping_cart_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productlist_Controller.CallCart();
			}
		});
		Shopping_cart_btn.setIcon(new ImageIcon("src/shopping-cart.png"));
		Shopping_cart_btn.setBounds(325, 0, 59, 23);
		contentPane.add(Shopping_cart_btn);
		
		Notice_btn = new JButton("");
		Notice_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String totoal_messagee="";
				ArrayList<String> notify = productlist_Controller.cm.getAccount().get_notify_list();
				for(String lists : notify) {
					totoal_messagee = totoal_messagee + lists;
				}
				JOptionPane.showMessageDialog(null, totoal_messagee,"通知",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		Notice_btn.setIcon(new ImageIcon("src/alarm.png"));
		Notice_btn.setBounds(325, 33, 59, 23);
		contentPane.add(Notice_btn);
		
		JButton Help_btn = new JButton("");
		Help_btn.setIcon(new ImageIcon("src/question-mark (1).png"));
		Help_btn.setBounds(325, 66, 59, 23);
		contentPane.add(Help_btn);
		
		name1 = new JLabel("Hello~ Guest");
		name1.setBounds(0, 29, 87, 23);
		contentPane.add(name1);
		
	
		product1_name.setBounds(29, 237, 119, 15);
		contentPane.add(product1_name);
		
		
		product1_price.setBounds(39, 262, 71, 15);
		contentPane.add(product1_price);
		
		product2_name.setBounds(158, 237, 115, 15);
		contentPane.add(product2_name);
		
		product2_price.setBounds(168, 262, 78, 15);
		contentPane.add(product2_price);
		
		product3_name.setBounds(283, 237, 101, 15);
		contentPane.add(product3_name);
		
		product3_price.setBounds(293, 262, 81, 15);
		contentPane.add(product3_price);
		
		product4_name.setBounds(41, 429, 107, 15);
		contentPane.add(product4_name);
		
		product4_price.setBounds(51, 454, 78, 15);
		contentPane.add(product4_price);
		
		product5_name.setBounds(158, 429, 120, 15);
		contentPane.add(product5_name);
		
		product5_price.setBounds(168, 454, 78, 15);
		contentPane.add(product5_price);
		
		product6_name.setBounds(283, 429, 101, 15);
		contentPane.add(product6_name);
		
		product6_price.setBounds(293, 454, 81, 15);
		contentPane.add(product6_price);
			
		Product1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("產品名稱:"+name[0]);
				System.out.println("照片名稱:"+icon[0]);
				productlist_Controller.EnterPress(0);
				productlist_Controller.CallPdIn();
			}
		});
		

		Product1.setIcon(icon[0]);
		Product1.setBounds(29, 103, 87, 124);
		contentPane.add(Product1);
		
	
		Product2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				productlist_Controller.EnterPress(1);
				productlist_Controller.CallPdIn();	
			}
		});
		Product2.setBounds(148, 103, 87, 124);
		contentPane.add(Product2);
		Product3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productlist_Controller.EnterPress(2);
				productlist_Controller.CallPdIn();			}
		});
		
		Product3.setBounds(265, 103, 87, 124);
		contentPane.add(Product3);
		Product4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productlist_Controller.EnterPress(3);
				productlist_Controller.CallPdIn();
			}
		});
		
		Product4.setBounds(29, 295, 87, 124);
		contentPane.add(Product4);
		Product5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productlist_Controller.EnterPress(4);
				productlist_Controller.CallPdIn();
			}
		});
		
		Product5.setBounds(148, 295, 87, 124);
		contentPane.add(Product5);
		Product6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productlist_Controller.EnterPress(5);
				productlist_Controller.CallPdIn();
			}
		});
		
		Product6.setBounds(265, 295, 87, 124);
		contentPane.add(Product6);
		
	
	}
	//-------------------------------
	//--設置Controller
	
	public void SetController(ProductList_Controller productlist_Controller) {
		this.productlist_Controller = productlist_Controller;
	}
	
	public void setAll() {
		
			product1_name.setText("Name:"+name[0]); 
			product1_price.setText("price:"+String.valueOf(price[0]));
			Product1.setIcon(icon[0]);
			
			product2_name.setText("Name:"+name[1]); 
			product2_price.setText("price:"+String.valueOf(price[1]));
			Product2.setIcon(icon[1]);
			
			product3_name.setText("Name:"+name[2]); 
			product3_price.setText("price:"+String.valueOf(price[2]));
			Product3.setIcon(icon[2]);
			
			product4_name.setText("Name:"+name[3]); 
			product4_price.setText("price:"+String.valueOf(price[3]));
			Product4.setIcon(icon[3]);
			
			product5_name.setText("Name:"+name[4]); 
			product5_price.setText("price:"+String.valueOf(price[4]));
			Product5.setIcon(icon[4]);
			
			product6_name.setText("Name:"+name[5]); 
			product6_price.setText("price:"+String.valueOf(price[5]));
			Product6.setIcon(icon[5]);
		
		repaint();
	}
	public void clearAll() {
		System.out.println("清除所有圖片");
		
		for(int i=0; i<6; i++) {
			name[i]="";
			price[i]=(0);
			icon[i]=empty;
		}
		
		product1_name.setText(name[0]); 
		product1_price.setText("");
		Product1.setIcon(icon[0]);
		
		product2_name.setText(name[1]); 
		product2_price.setText("");
		Product2.setIcon(icon[1]);
		
		product3_name.setText(name[2]); 
		product3_price.setText("");
		Product3.setIcon(icon[2]);
		
		product4_name.setText(name[3]); 
		product4_price.setText("");
		Product4.setIcon(icon[3]);
		
		product5_name.setText(name[4]); 
		product5_price.setText("");
		Product5.setIcon(icon[4]);
		
		product6_name.setText(name[5]); 
		product6_price.setText("");
		Product6.setIcon(icon[5]);	
		repaint();
	}
	
	public void setName(String name) {
		this.name1.setText(name);
	}
	// used to set the name of the label.
	
	public void setLoginName(String name) {
		this.Login.setText(name);
	}
	
	public void SetNotifyImage(ImageIcon icon) {
		Notice_btn.setIcon(icon);
	}
	
}
