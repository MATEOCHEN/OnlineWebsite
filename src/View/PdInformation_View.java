package View;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import Composite.Component;
import Controller_Mediator.PdInformation_controller;
import Observer.Concrete_Subject;
import account.Account;
import account.Account_Observer;
import db.DBMgr;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.security.auth.Subject;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class PdInformation_View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField buy_quantity;
	private JButton Login_btn;
	private PdInformation_controller pdIn_controller;
	private boolean IsInput=false;
	private NumberFormat longFormat = NumberFormat.getIntegerInstance();
	private NumberFormatter numberFormatter;
	private Component c;//存處pdIn_controller 目前的Component
	
	JLabel product_name = new JLabel("Product Name");
	JLabel Quantity = new JLabel("Unit");
	JLabel product_price = new JLabel("$");
	JButton product_btn = new JButton("");
	JTextArea product_detatil = new JTextArea();
	JLabel name;
	JButton Notice_btn;
	
	Concrete_Subject o1_list = new Concrete_Subject();
	
	public PdInformation_View() {
		setTitle("Product Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setAllowsInvalid(false);
		numberFormatter.setMinimum(01);
		
		product_name.setFont(new Font("新細明體", Font.PLAIN, 18));
		product_name.setBounds(10, 82, 113, 23);
		contentPane.add(product_name);
		
		Quantity.setFont(new Font("新細明體", Font.PLAIN, 20));
		Quantity.setBounds(245, 362, 87, 16);
		contentPane.add(Quantity);
		
		product_price.setFont(new Font("新細明體", Font.PLAIN, 20));
		product_price.setBounds(245, 388, 113, 29);
		contentPane.add(product_price);
		
		buy_quantity = new JFormattedTextField(numberFormatter);
		buy_quantity.setColumns(10);
		buy_quantity.setBounds(208, 362, 27, 21);
		contentPane.add(buy_quantity);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quantity=buy_quantity.getText();
				c = pdIn_controller.getComponent();
				System.out.println("即將加入到購物車 現在商品的名稱為 :"+c.getName());
				//判斷商品c 是否已經存在與購物車裡面了
				if(c.getQuantity() == 0 || (Integer.parseInt(quantity) > c.getQuantity())) {
					JOptionPane.showMessageDialog(null,"現在商品數量："+c.getQuantity() +" 加入失敗" ,"Notice",JOptionPane.INFORMATION_MESSAGE);
				} else {
					for(Component spcart_goods:pdIn_controller.getshopcart_Composite().getList()) {
						if(c.getName().equals(spcart_goods.getName())) {
							IsInput=true;
							spcart_goods.addQuantity(Integer.parseInt(quantity));
							System.out.println("商品數量已新增"+quantity+"個");
							break;
						} else {
							continue;
						}
					}
					//嘗試將商品放入到購物車裡面
					if(IsInput==false) {
						c.setQuantity(Integer.parseInt(quantity));
						pdIn_controller.getshopcart_Composite().add(c);
						pdIn_controller.insertShoppingCart();
						System.out.println("將商品"+c.getName()+"放入到購物車裡面");
						pdIn_controller.ShowSuccessMessage();	
					}
					System.out.println("目前購物車裡面擁有：");
					for(Component spcart_lists:pdIn_controller.getshopcart_Composite().getList()) {
						System.out.print(" "+spcart_lists.getName());
						System.out.println(" "+"數量為" + spcart_lists.getQuantity());
						pdIn_controller.updateQuantity(pdIn_controller.getAccount().getEmail(),spcart_lists.getName(),spcart_lists.getQuantity());
					}
				}
			}
		});
		btnAdd.setBounds(158, 431, 87, 23);
		contentPane.add(btnAdd);
		
		name= new JLabel("Hello~ Guest");
		name.setBounds(0, 29, 87, 23);
		contentPane.add(name);
		
		Login_btn = new JButton("Login&Register");
		Login_btn.setBounds(148, 0, 130, 23);
		Login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Login_btn.getText() == "Login&Register") {
					pdIn_controller.CallLogin();
				} else {
					pdIn_controller.setName("Hello~ Guest");
					pdIn_controller.SetLoginBtn_name("Login&Register");	//used trigger log out button
					pdIn_controller.setGuestAccount();
				}
			}
		});
		contentPane.add(Login_btn);
		
		JButton Shopping_cart_btn = new JButton("");
		Shopping_cart_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pdIn_controller.CallCart();
			}
		});
		Shopping_cart_btn.setIcon(new ImageIcon("src/shopping-cart.png"));
		Shopping_cart_btn.setBounds(325, 0, 59, 23);
		contentPane.add(Shopping_cart_btn);
		
		Notice_btn = new JButton("");
		Notice_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String totoal_messagee="";
				ArrayList<String> notify = pdIn_controller.cm.getAccount().get_notify_list();
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
		
		JButton Home_btn = new JButton("Home");
		Home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pdIn_controller.Call_pdlist_clear_picture();
				pdIn_controller.CallHome();
			}
		});
		Home_btn.setBounds(0, 0, 87, 23);
		contentPane.add(Home_btn);
	
		product_btn.setBounds(10, 125, 139, 207);
		contentPane.add(product_btn);
		
		
		product_detatil.setLineWrap(true);
		product_detatil.setOpaque(false);
		product_detatil.setWrapStyleWord(true);
		
		
		product_detatil.setBounds(158, 125, 200, 207);
		contentPane.add(product_detatil);
		
		JLabel lblNewLabel = new JLabel("\u8ACB\u8F38\u5165\u8CFC\u8CB7\u6578\u91CF\uFF1A");
		lblNewLabel.setBounds(104, 358, 105, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnTrack = new JButton("track");
		btnTrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component c = pdIn_controller.getComponent();
				
				if(c.getQuantity()==0) {
					
						
						Account_Observer a = pdIn_controller.getAccount();
						o1_list.add(c.getName(),a);
							
						String new1="追中商品";
						JOptionPane.showMessageDialog(null, new1,"操作流程",JOptionPane.INFORMATION_MESSAGE);	
				}
				else {
					String new1="目前商品數量為:" + c.getQuantity();
					JOptionPane.showMessageDialog(null, new1,"操作流程",JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
		});
		btnTrack.setBounds(255, 431, 87, 23);
		contentPane.add(btnTrack);
	}
	
	//--設置Controller
		public void SetController(PdInformation_controller pdIn_controller) {
			this.pdIn_controller = pdIn_controller;
		}
		
		public void setAll(String name,ImageIcon icon,String detail,double price) {
			product_name.setText(name);
			product_btn.setIcon(icon);
			product_detatil.setText(detail);
			product_price.setText("單價: "+price);
			repaint();
		}
		
		public void setName(String name) {
			this.name.setText(name);
		}
		
		public void SetLoginBtn_name(String name) {
			this.Login_btn.setText(name);
		}
		
		public Concrete_Subject getConcrete_Subject() {
			return o1_list;
		}
		
		public void SetNotifyImage(ImageIcon icon) {
			Notice_btn.setIcon(icon);
		}
		
}
