package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Controller_Mediator.Login_Controller;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login_View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField email_txt_login;
	private JPasswordField password_txt_login;
	private JTextField email_txt_register;
	private JPasswordField password_txt_register;
	private JPasswordField confirmpassword_txt;
	private JTextField adress_txt;
	private JTextField phonenumber_txt;
	private JTextField name_txt;
	
	private Login_Controller login_controller;

	public Login_View() {
		setTitle("Login or Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel login_panel = new JPanel();
		login_panel.setBounds(0, 0, 219, 533);
		contentPane.add(login_panel);
		login_panel.setLayout(null);
		
		JLabel email_lab_login = new JLabel("Email：");
		email_lab_login.setFont(new Font("新細明體", Font.PLAIN, 18));
		email_lab_login.setBounds(12, 64, 64, 28);
		login_panel.add(email_lab_login);
		
		JLabel password_lab_login = new JLabel("Password：");
		password_lab_login.setFont(new Font("新細明體", Font.PLAIN, 18));
		password_lab_login.setBounds(12, 131, 83, 28);
		login_panel.add(password_lab_login);
		
		email_txt_login = new JTextField();
		email_txt_login.setBounds(12, 102, 199, 28);
		login_panel.add(email_txt_login);
		email_txt_login.setColumns(10);
		
		password_txt_login = new JPasswordField();
		password_txt_login.setColumns(10);
		password_txt_login.setBounds(12, 169, 200, 28);
		login_panel.add(password_txt_login);
		
		JButton login_btn = new JButton("Login");
		login_btn.setBounds(59, 210, 107, 34);
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String password = new String(password_txt_login.getPassword());
				boolean verification = login_controller.verifyAccountRequest(email_txt_login.getText(), password);
				if(verification == true) {
					System.out.println("Login successfully!!");
				} else{
					System.out.println("Login Failed!!");
				}
			}
		});
		login_panel.add(login_btn);
		
		JButton button = new JButton("Home");
		button.setBounds(0, 0, 94, 34);
		login_panel.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				login_controller.callHome();
			}
		});
		
		JPanel register_panel = new JPanel();
		register_panel.setBounds(217, 0, 217, 533);
		contentPane.add(register_panel);
		register_panel.setLayout(null);
		
		JLabel email_lab_register = new JLabel("Email：");
		email_lab_register.setFont(new Font("新細明體", Font.PLAIN, 18));
		email_lab_register.setBounds(12, 58, 64, 28);
		register_panel.add(email_lab_register);
		
		email_txt_register = new JTextField();
		email_txt_register.setColumns(10);
		email_txt_register.setBounds(12, 96, 199, 28);
		register_panel.add(email_txt_register);
		
		JLabel password_lab_register = new JLabel("Password：");
		password_lab_register.setFont(new Font("新細明體", Font.PLAIN, 18));
		password_lab_register.setBounds(12, 125, 83, 28);
		register_panel.add(password_lab_register);
		
		password_txt_register = new JPasswordField();
		password_txt_register.setColumns(10);
		password_txt_register.setBounds(12, 163, 199, 28);
		register_panel.add(password_txt_register);
		
		confirmpassword_txt = new JPasswordField();
		confirmpassword_txt.setColumns(10);
		confirmpassword_txt.setBounds(12, 239, 199, 28);
		register_panel.add(confirmpassword_txt);
		
		JLabel confirmpassword_lab = new JLabel("Confirmpassword\uFF1A");
		confirmpassword_lab.setFont(new Font("新細明體", Font.PLAIN, 18));
		confirmpassword_lab.setBounds(12, 201, 170, 28);
		register_panel.add(confirmpassword_lab);
		
		adress_txt = new JTextField();
		adress_txt.setColumns(10);
		adress_txt.setBounds(12, 458, 199, 28);
		register_panel.add(adress_txt);
		
		JLabel address_lab = new JLabel("Adress\uFF1A");
		address_lab.setFont(new Font("新細明體", Font.PLAIN, 18));
		address_lab.setBounds(12, 420, 170, 28);
		register_panel.add(address_lab);
		
		phonenumber_txt = new JTextField();
		phonenumber_txt.setColumns(10);
		phonenumber_txt.setBounds(12, 382, 199, 28);
		register_panel.add(phonenumber_txt);
		
		name_txt = new JTextField();
		name_txt.setColumns(10);
		name_txt.setBounds(12, 315, 199, 28);
		register_panel.add(name_txt);
		
		JLabel name_lab = new JLabel("Name\uFF1A");
		name_lab.setFont(new Font("新細明體", Font.PLAIN, 18));
		name_lab.setBounds(12, 277, 64, 28);
		register_panel.add(name_lab);
		
		JLabel Phone_num = new JLabel("Phone Number \uFF1A");
		Phone_num.setFont(new Font("新細明體", Font.PLAIN, 18));
		Phone_num.setBounds(12, 344, 170, 28);
		register_panel.add(Phone_num);
		
		JButton register_btn = new JButton("Register");
		register_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String password = new String(password_txt_register.getPassword());
				String cfm_passwd = new String(confirmpassword_txt.getPassword());
				
				login_controller.addAccountRequest(email_txt_register.getText(),password,
						cfm_passwd, name_txt.getText(), adress_txt.getText(), phonenumber_txt.getText());
			}
		});
		register_btn.setBounds(56, 495, 107, 34);
		register_panel.add(register_btn);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setIcon(new ImageIcon("src/question-mark (1).png"));
		button_1.setBounds(184, 0, 33, 28);
		register_panel.add(button_1);
	}
		//--設置Controller
		public void SetController(Login_Controller login_controller) {
			this.login_controller=login_controller;
		}
		//-----------------
		
		
}
