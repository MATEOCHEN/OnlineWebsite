package View;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.NumberFormatter;

import Command.Command_Invoker;
import Command.DeleteItem;
import Command.UpdateItem;
import Controller_Mediator.ShopCart_Controller;
import Flyweight.*;
import db.DBMgr;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Button;
import javax.swing.JSeparator;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;



public class  ShopCart_View extends JFrame {

	private JPanel contentPane;
	private JPanel head_panel;
	private JPanel body_panel;
	private JLabel name;
	private JScrollPane scrollPane;
	
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2; 
	private JLabel totalPrice_lbl;
	private JLabel totalPrice;
	private JLabel Discount_lbl;
	private JLabel totalDiscount;
	private JLabel Shipping_lbl;
	private JLabel Shipping_fee;
	private JLabel Payment_lbl;
	private JLabel Payment;
	private JLabel Payment_choice;
	
	private JLabel empty_statement;
	private JLabel[] GoodsPicture = new JLabel[100];
	private JButton[] delete = new JButton[100];
	private JButton[] button_2 = new JButton[100];
	private JButton[] button_5 = new JButton[100];
	
	private Choice choice;
	private JButton UseCoupon;
	private JButton continue_shop;
	private JButton checkout;
	private NumberFormat longFormat = NumberFormat.getIntegerInstance();
	private NumberFormatter numberFormatter;
	private JLabel[] GoodsName  = new JLabel[100];
	private JLabel GoodsPrice[] = new JLabel[100];
	private JFormattedTextField[] quantity_set  = new JFormattedTextField[100];
	private int distance_Y = 0;
	private double  total = 0;
	private ShopCart_Controller sp_controller;
	private Command_Invoker invoker = new Command_Invoker();
	
	private CouponFactory couponFactory = new CouponFactory();
	double couponDiscount = 0;
	
	public ShopCart_View() {
		setTitle("Shopping Cart");
		setDefaultCloseOperation(0);
	    setResizable(false);
		setBounds(100, 100, 400, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		head_panel = new JPanel();
		head_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		head_panel.setBounds(0, 0, 384, 93);
		contentPane.add(head_panel);
		head_panel.setLayout(null);
		
		numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setAllowsInvalid(false);
		numberFormatter.setMinimum(01);
		
		
		name = new JLabel("Hello~ Guest");
		name.setBounds(0, 29, 87, 23);
		head_panel.add(name);
		
		JButton button_3 = new JButton("");
		button_3.setBounds(325, 0, 59, 23);
		button_3.setIcon(new ImageIcon("src/alarm.png"));
		head_panel.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setBounds(325, 33, 59, 23);
		button_4.setIcon(new ImageIcon("src/question-mark (1).png"));
		head_panel.add(button_4);
		
		JButton button_11 = new JButton("");
		button_11.setBounds(0, 57, 70, 23);
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((invoker.getIndex() != -1)) {
					invoker.undo();//undo method
					setTotal();
					repaint();
					//System.out.println(record_savePoint);
				} else{
					JOptionPane.showMessageDialog(null, "Your shopping state is newest.","Notice",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button_11.setIcon(new ImageIcon("src/back-arrow.png"));
		head_panel.add(button_11);
		
		JButton button_12 = new JButton("Home");
		button_12.setBounds(0, 0, 87, 23);
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sp_controller.CallHome();
				repaint_bodyPanel();
			}
		});
		head_panel.add(button_12);
		
		JLabel label = new JLabel("ProductName");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		label.setBounds(118, 78, 88, 15);
		head_panel.add(label);
		
		JLabel label_1 = new JLabel("UnitPrice");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(218, 78, 68, 15);
		head_panel.add(label_1);
		
		JLabel label_2 = new JLabel("Quantity");
		label_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_2.setBounds(300, 78, 51, 15);
		head_panel.add(label_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(82, 57, 70, 23);
		btnNewButton.setIcon(new ImageIcon("src/front-arrow.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(invoker.Check_UndoClick() == true) {
					invoker.redo();
					setTotal();
					repaint();
				} else {
					JOptionPane.showMessageDialog(null, "Your shopping state is newest.","Notice",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		head_panel.add(btnNewButton);
		//------The elements of the head panel------
		
		body_panel = new JPanel();
		body_panel.setBounds(0, 97, 384, 406);
		body_panel.setLayout(null);
		
		separator = new JSeparator();
		separator.setBounds(0, 24, 366, 15);
		body_panel.add(separator);
		
		totalPrice_lbl = new JLabel("TotalPrice");
		totalPrice_lbl.setFont(new Font("Arial", Font.PLAIN, 12));
		totalPrice_lbl.setBounds(162, 33, 69, 23);
		body_panel.add(totalPrice_lbl);
		
		totalPrice = new JLabel("0");
		totalPrice.setBounds(304, 37, 62, 15);
		body_panel.add(totalPrice);
		
		Discount_lbl = new JLabel("Discount");
		Discount_lbl.setFont(new Font("Arial", Font.PLAIN, 12));
		Discount_lbl.setBounds(162, 56, 88, 23);
		body_panel.add(Discount_lbl);
		
		//String discount = Double.toString(sp_controller.getDiscount());
		totalDiscount = new JLabel("0%");
		totalDiscount.setBounds(304, 60, 47, 15);
		body_panel.add(totalDiscount);
		
		Shipping_lbl = new JLabel("Shipping Fee");
		Shipping_lbl.setFont(new Font("Arial", Font.PLAIN, 12));
		Shipping_lbl.setBounds(162, 85, 106, 15);
		body_panel.add(Shipping_lbl);
		
		Shipping_fee = new JLabel("0");
		Shipping_fee.setBounds(304, 85, 62, 15);
		body_panel.add(Shipping_fee);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 112, 366, 15);
		body_panel.add(separator_1);
		
		Payment_lbl = new JLabel("Payment Amount");
		Payment_lbl.setFont(new Font("Arial", Font.PLAIN, 12));
		Payment_lbl.setBounds(162, 116, 130, 23);
		body_panel.add(Payment_lbl);
		
		Payment = new JLabel("0");
		Payment.setBounds(304, 121, 62, 18);
		body_panel.add(Payment);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(0, 151, 366, 15);
		body_panel.add(separator_2);
		
		Payment_choice = new JLabel("Please choice a payment amount");
		Payment_choice.setFont(new Font("Arial", Font.PLAIN, 12));
		Payment_choice.setBounds(18, 163, 194, 15);
		body_panel.add(Payment_choice);
		
		choice = new Choice();
		choice.add("CreditCard");
		choice.add("LinePay");
		choice.add("WeChatPay");
		choice.setBounds(21, 186, 179, 22);
		body_panel.add(choice);
		
		UseCoupon = new JButton("Use Coupon");
		UseCoupon.setFont(new Font("Arial", Font.PLAIN, 12));
		UseCoupon.setBounds(100, 231, 220, 33);
		UseCoupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(couponFactory.checkCoupon(JOptionPane.showInputDialog(null, "Please typing your coupon code:"))) {
					couponDiscount = couponFactory.getCoupon(sp_controller.getCurrentAccount().getName()).getCouponValue();
					System.out.println(couponDiscount);
					setTotal();
					UseCoupon.setText("Coupon Discount:500");
					UseCoupon.setEnabled(false);
				} else {
					System.out.println("no this coupon");
				}
			}
		});
		body_panel.add(UseCoupon);
		
		continue_shop = new JButton("Continue Shopping");
		continue_shop.setFont(new Font("Arial", Font.PLAIN, 12));
		continue_shop.setBounds(30, 264, 147, 33);
		continue_shop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sp_controller.CallHome();
				repaint_bodyPanel();
			}
		});
		body_panel.add(continue_shop);
		
		checkout = new JButton("Checkout");
		checkout.setFont(new Font("Arial", Font.PLAIN, 12));
		checkout.setBounds(190, 264, 147, 33);
		checkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(sp_controller.getCurrentAccount().getName().equals("Guest")) {
					sp_controller.CallLogin();
					repaint_bodyPanel();
				} else if(!Payment.getText().equals("0.0")) {
					if(Double.parseDouble(Payment.getText()) >= 3000.0) {
						Coupon coupon = couponFactory.getCoupon(sp_controller.getCurrentAccount().getName());
						
						JOptionPane.showMessageDialog(null, "Hello, " + sp_controller.getCurrentAccount().getName() + ". This is your new coupon:\n" + coupon.getID()
						+ "\n\n Please writing down this code and using in next times.", "Coupon Gotten Notice", JOptionPane.INFORMATION_MESSAGE);
					}
					sp_controller.CallClearOrder(totalPrice.getText(),totalDiscount.getText(),Shipping_fee.getText(),Payment.getText(),choice.getSelectedItem());
					sp_controller.triggerConfirmButton(choice.getSelectedItem());
				} else {
					JOptionPane.showMessageDialog(null, "Please add some item, your shopping cart is empty!!","Notice",JOptionPane.INFORMATION_MESSAGE);
				}
				System.out.println(choice.getSelectedItem());
				
				//examine whether the information wrong or not.
			}
		});
		body_panel.add(checkout);
		
		body_panel.setPreferredSize(new Dimension(350, 450));
		scrollPane = new JScrollPane(body_panel);
		scrollPane.setBounds(0, 94, 384, 422);
		contentPane.add(scrollPane,BorderLayout.CENTER);
	}
	
	public void setDiscount(double discount) {
		this.totalDiscount.setText(Double.toString(discount));
	}
	
	public void setTotal() {
		double discount = sp_controller.getDiscount(sp_controller.getshopcart_Composite(),sp_controller.getCurrentAccount());
		double discount_total;
		double totalPrice  = Double.parseDouble(this.totalPrice.getText());
		int total_int ;
		if(discount == 0) {
			discount_total = totalPrice - couponDiscount;
		} else {
			discount_total = totalPrice * discount - couponDiscount;
		}
		total_int = (int)Math.ceil(discount_total);
		this.Payment.setText(Double.toString(total_int));
	}
	
	public JPanel getBodyPanel() {
		return this.body_panel;
	}
	
	public void SetController(ShopCart_Controller controller) {
		this.sp_controller = controller;
	}
	
	public void addItem(ImageIcon icon,String name,double price,int quantity,int i) {
			
			Image image = icon.getImage();
			Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
			ImageIcon  newicon= new ImageIcon(newimg);
			
			delete[i] = new JButton();
			delete[i].setBounds(5, 25 + distance_Y, 20, 20);
			delete[i].setIcon(new ImageIcon("src/delete.png"));
			delete[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("我要刪除"+i);
					invoker.setCommand(new DeleteItem(sp_controller,GoodsName[i].getText(),i));
					invoker.execute(i);			//Command Pattern
					repaint();
				}
			});
			body_panel.add(delete[i]);
			
			GoodsPicture[i] = new JLabel(newicon);
			GoodsPicture[i].setBounds(40, 10 + distance_Y, 50, 50); 
			body_panel.add(GoodsPicture[i]);
			
			GoodsName[i] = new JLabel(name);
			GoodsName[i].setFont(new Font("Arial", Font.PLAIN, 12));
			GoodsName[i].setBounds(122, 30 + distance_Y, 80, 15);
			body_panel.add(GoodsName[i]);
			
			GoodsPrice[i] = new JLabel(Double.toString(price));
			GoodsPrice[i].setFont(new Font("Arial", Font.PLAIN, 12));
			GoodsPrice[i].setBounds(222, 30 + distance_Y, 48, 15);
			body_panel.add(GoodsPrice[i]);
			
			quantity_set[i] = new JFormattedTextField(this.numberFormatter);
			quantity_set[i].setColumns(10);
			quantity_set[i].setText(Integer.toString(quantity));
			quantity_set[i].setBounds(309, 25 + distance_Y, 24, 22);
			quantity_set[i].setEditable(false);
			body_panel.add(quantity_set[i]);
			
			button_2[i] = new JButton("");
			button_2[i].setIcon(new ImageIcon("src/plus-black-symbol.png"));
			button_2[i].setBounds(286, 25 + distance_Y, 20, 20);
			button_2[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String current_quantity = quantity_set[i].getText();
					invoker.setCommand(new UpdateItem(sp_controller,GoodsName[i].getText(),Integer.parseInt(current_quantity) + 1,Integer.parseInt(current_quantity),i,"+"));
					invoker.execute(i);  //Command Pattern
				}
			});
			body_panel.add(button_2[i]);
			
			button_5[i] = new JButton();
			button_5[i].setBounds(333, 25 + distance_Y, 20, 20);
			button_5[i].setIcon(new ImageIcon("src/minus.png"));
			button_5[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String current_quantity = quantity_set[i].getText();
					if(!current_quantity.equals("1")) {
						invoker.setCommand(new UpdateItem(sp_controller,GoodsName[i].getText(),Integer.parseInt(current_quantity)-1,Integer.parseInt(current_quantity),i,"-"));
						invoker.execute(i); //Command Pattern
					}
				}
			});
			body_panel.add(button_5[i]);
			
			distance_Y += 55;
			component_move(55);
			total += price * quantity;
			totalPrice.setText(Double.toString(total));
	}
	
	public void setTotalPrice(int i) {
		total = Double.parseDouble(Payment.getText()) - Double.parseDouble(GoodsPrice[i].getText()) * Double.parseDouble(quantity_set[i].getText());
		totalPrice.setText(Double.toString(total));	
	}
	public void setQuantity(int i,String sign) {
		String quantity = quantity_set[i].getText();
		double price = Double.parseDouble(GoodsPrice[i].getText());
		int update_quantity;
		if(sign.equals("+")) {
			update_quantity = Integer.parseInt(quantity) + 1;
			total = total + price;
		} else {
			update_quantity = Integer.parseInt(quantity) - 1;
			total = total - price;
		}
		this.quantity_set[i].setText(Integer.toString(update_quantity));
		totalPrice.setText(Double.toString(total));
	}
	public void empty_print() {
		empty_statement = new JLabel("Your shopping cart is empty");
		empty_statement.setForeground(Color.red);
		empty_statement.setBounds(100, 5, 200, 15);
		body_panel.add(empty_statement);
	}
	
	public void repaint_bodyPanel() {
		if(sp_controller.getshopcart_Composite().getList().size() != 0) {	
			for(int i = 0 ;i < sp_controller.getshopcart_Composite().getList().size(); i ++) {
				this.body_panel.remove(GoodsPicture[i]);
				this.body_panel.remove(GoodsPrice[i]);
				this.body_panel.remove(GoodsName[i]);
				this.body_panel.remove(quantity_set[i]);
				this.body_panel.remove(delete[i]);
				this.body_panel.remove(button_2[i]);
				this.body_panel.remove(button_5[i]);
			}
			
			
			for(int i = 0;i < sp_controller.getshopcart_Composite().getList().size(); i++) {
				component_move(-55);
			}
			total = 0;
			distance_Y = 0;
		} else {
			this.body_panel.remove(empty_statement);
		}
	}
	
	
	public void component_move(int distance) {
		int downward_distance = distance;
		this.separator.setLocation(separator.getLocation().x, separator.getLocation().y +downward_distance);
		this.separator_1.setLocation(separator_1.getLocation().x, separator_1.getLocation().y +downward_distance);
		this.separator_2.setLocation(separator_2.getLocation().x, separator_2.getLocation().y +downward_distance);
		this.totalPrice_lbl.setLocation(totalPrice_lbl.getLocation().x, totalPrice_lbl.getLocation().y +downward_distance);
		this.totalPrice.setLocation(totalPrice.getLocation().x, totalPrice.getLocation().y +downward_distance);
		this.Discount_lbl.setLocation(Discount_lbl.getLocation().x, Discount_lbl.getLocation().y +downward_distance);
		this.totalDiscount.setLocation(totalDiscount.getLocation().x, totalDiscount.getLocation().y +downward_distance);
		this.Shipping_lbl.setLocation(Shipping_lbl.getLocation().x, Shipping_lbl.getLocation().y +downward_distance);
		this.Shipping_fee.setLocation(Shipping_fee.getLocation().x, Shipping_fee.getLocation().y +downward_distance);
		this.Payment_lbl.setLocation(Payment_lbl.getLocation().x, Payment_lbl.getLocation().y +downward_distance);
		this.Payment.setLocation(Payment.getLocation().x, Payment.getLocation().y +downward_distance);
		this.Payment_choice.setLocation(Payment_choice.getLocation().x, Payment_choice.getLocation().y +downward_distance);
		this.choice.setLocation(choice.getLocation().x, choice.getLocation().y +downward_distance);
		this.continue_shop.setLocation(continue_shop.getLocation().x, continue_shop.getLocation().y +downward_distance);
		this.checkout.setLocation(checkout.getLocation().x, checkout.getLocation().y +downward_distance);
		this.UseCoupon.setLocation(UseCoupon.getLocation().x, UseCoupon.getLocation().y +downward_distance);
		this.body_panel.setPreferredSize(new Dimension(body_panel.getPreferredSize().width,body_panel.getPreferredSize().height + downward_distance));
	}
}
