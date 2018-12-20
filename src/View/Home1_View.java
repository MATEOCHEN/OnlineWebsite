package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller_Mediator.Home1_Controller;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Home1_View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String mark;
	private JLabel name;
	private JButton Login_btn;
	private Home1_Controller home1_Controller;
	JButton Notice_btn;
	//--設置Controller
		public void SetController(Home1_Controller home1_controller) {
			this.home1_Controller=home1_controller;
		}
	//-----------------


	
	public Home1_View() {
		setTitle("Home1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Nike_btn = new JButton("");
		Nike_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mark="N"+home1_Controller.getMark();
				home1_Controller.setMark(mark);
				home1_Controller.CallPdlist_setMark();
				System.out.println("現在點選的商品為"+home1_Controller.getMark());
				home1_Controller.CallPdlist_record();
				home1_Controller.CallProductList();
			}
		});
		
		JButton button = new JButton("Home");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home1_Controller.CallHome();
			}
		});
		button.setBounds(0, 0, 87, 23);
		contentPane.add(button);
		Nike_btn.setIcon(new ImageIcon("src/checked.png"));
		Nike_btn.setBounds(93, 147, 196, 71);
		contentPane.add(Nike_btn);
		
		JButton Addidas_btn = new JButton("");
		Addidas_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mark="A"+home1_Controller.getMark();
				home1_Controller.setMark(mark);
				home1_Controller.CallPdlist_setMark();
				System.out.println("現在點選的商品為"+home1_Controller.getMark());
				home1_Controller.CallPdlist_record();
				home1_Controller.CallProductList();
			}
		});
		Addidas_btn.setIcon(new ImageIcon("src/adidas.png"));
		Addidas_btn.setBounds(93, 242, 196, 71);
		contentPane.add(Addidas_btn);
		
		Login_btn = new JButton("Login&Register");
		Login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home1_Controller.CallLogin();
				if(Login_btn.getText() == "Login&Register") {
					home1_Controller.CallLogin();
				} else {
					home1_Controller.setName("Hello~ Guest");
					home1_Controller.SetLoginBtn_name("Login&Register");	//used trigger log out button
					home1_Controller.setGuestAccount();
				}
			}
		});
		Login_btn.setBounds(148, 0, 130, 23);
		contentPane.add(Login_btn);
		
		JButton Shopping_cart_btn = new JButton("");
		Shopping_cart_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Shopping_cart_btn.setIcon(new ImageIcon("src/shopping-cart.png"));
		Shopping_cart_btn.setBounds(325, 0, 59, 23);
		
		Shopping_cart_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home1_Controller.CallCart();	
			}
		});
		contentPane.add(Shopping_cart_btn);
		
		Notice_btn = new JButton("");
		Notice_btn.setIcon(new ImageIcon("src/alarm.png"));
		Notice_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String totoal_messagee="";
				ArrayList<String> notify = home1_Controller.cm.getAccount().get_notify_list();
				for(String lists : notify) {
					totoal_messagee = totoal_messagee + lists;
				}
				JOptionPane.showMessageDialog(null, totoal_messagee,"通知",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		Notice_btn.setBounds(325, 33, 59, 23);
		contentPane.add(Notice_btn);
		
		JButton Help_btn = new JButton("");
		Help_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home1_Controller.ShowHelpMessage();
			}
		});
		Help_btn.setIcon(new ImageIcon("src/question-mark (1).png"));
		Help_btn.setBounds(325, 66, 59, 23);
		contentPane.add(Help_btn);
		
		name = new JLabel("Hello~ Guest");
		name.setBounds(0, 29, 87, 23);
		contentPane.add(name);
	}
	
	public void setName(String name) {
		this.name.setText(name);
	}
	//------Used to change the name label of the home1 view.------
	
	public void SetLoginBtn_name(String name) {
		this.Login_btn.setText(name);
		this.Login_btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("156161");
			}	
		});
	}
	
	public void SetNotifyImage(ImageIcon icon) {
		Notice_btn.setIcon(icon);
	}
	
}
