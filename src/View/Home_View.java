package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller_Mediator.Home_Controller;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Label;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Home_View extends JFrame {

	private JPanel contentPane;
	private Home_Controller home_Controller;
	private JLabel name;
	private JButton Login_btn;
	JButton Notice_btn;
	public Home_View() {
	
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton Clothes_btn = new JButton("");
		Clothes_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home_Controller.setMark("C");
				home_Controller.Callhome1_setMark();
				System.out.println("現在點選的商品為"+home_Controller.getMark());
				home_Controller.CallHome1();
			}
		});
		Clothes_btn.setIcon(new ImageIcon("src/casual-t-shirt- (2).png"));
		Clothes_btn.setBounds(93, 93, 196, 71);
		contentPane.add(Clothes_btn);
		
		JButton Pant_btn = new JButton("");
		Pant_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home_Controller.setMark("P");
				home_Controller.Callhome1_setMark();
				System.out.println("現在點選的商品為"+home_Controller.getMark());
				home_Controller.CallHome1();
			}
		});
		Pant_btn.setIcon(new ImageIcon("src/trousers.png"));
		Pant_btn.setBounds(93, 189, 196, 71);
		contentPane.add(Pant_btn);
		
		JButton Shoes = new JButton("");
		Shoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home_Controller.setMark("S");
				home_Controller.Callhome1_setMark();
				System.out.println("現在點選的商品為"+home_Controller.getMark());
				home_Controller.CallHome1();
			}
		});
		
		JButton ALL_btn = new JButton("ALL");
		ALL_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home_Controller.setMark("");
				home_Controller.Callhome1_setMark();
				System.out.println("現在點選的商品為"+home_Controller.getMark());
				home_Controller.CallHome1();
			}
		});
		Shoes.setIcon(new ImageIcon("src/men-shoe.png"));
		Shoes.setBounds(93, 284, 196, 71);
		contentPane.add(Shoes);
		ALL_btn.setBounds(93, 382, 196, 71);
		
		contentPane.add(ALL_btn);
		
		Login_btn = new JButton("Login&Register");
		Login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Login_btn.getText() == "Login&Register") {
					home_Controller.CallLogin();
				} else {
					home_Controller.changeNameLabel("Hello~ Guest");
					home_Controller.changeLoginButton("Login&Register");	//used trigger log out button
					home_Controller.setGuestAccount();
				}
			}
		});
		Login_btn.setBounds(148, 0, 130, 23);
		contentPane.add(Login_btn);
		
		JButton Shopping_cart_btn = new JButton("");
		Shopping_cart_btn.setIcon(new ImageIcon("src/shopping-cart.png"));
		Shopping_cart_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home_Controller.CallShop();
			}
		});
		Shopping_cart_btn.setBounds(325, 0, 59, 23);
		contentPane.add(Shopping_cart_btn);
		
		Notice_btn = new JButton("");
		Notice_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String totoal_messagee="";
				ArrayList<String> notify = home_Controller.cm.getAccount().get_notify_list();
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
		Help_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home_Controller.ShowHelpMessage();
			}
		});
		Help_btn.setIcon(new ImageIcon("src/question-mark (1).png"));
		Help_btn.setBounds(325, 66, 59, 23);
		contentPane.add(Help_btn);
		
		name = new JLabel("Hello~ Guest");
		name.setBounds(0, 29, 87, 23);
		contentPane.add(name);
		
		JButton Home_btn = new JButton("Home");
		Home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//do nothing
			}
		});
		Home_btn.setBounds(0, 0, 87, 23);
		contentPane.add(Home_btn);
		//測試----------------------------------
	}
	
	//--設置Controller
	public void SetController(Home_Controller home_controller) {
		this.home_Controller=home_controller;
	}
	//-----------------
	public void setName(String name) {
		this.name.setText(name);
	}
	//------Used to change the name label of the home view.------

	public void SetLoginBtn_name(String name) {
		this.Login_btn.setText(name);
	}
	
	public void SetNotifyImage(ImageIcon icon) {
		Notice_btn.setIcon(icon);
	}
	
}
