package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller_Mediator.ClearOrder_Controller;
import Controller_Mediator.PaymentCheck_controller;

import javax.swing.JButton;
import java.awt.Label;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;

public class ClearOrder extends JFrame {

	private JPanel contentPane;
	private JTextPane textPane ;
	private String selectedItem = "";
	private ClearOrder_Controller c;
	
	public ClearOrder(ClearOrder_Controller c) {
		this.c = c;
		setTitle("Clear Order");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 400, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.setBounds(231, 438, 87, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaymentCheck_controller pc = new PaymentCheck_controller();
				pc.PaymentGUIShow(selectedItem);
			}
		});
		contentPane.add(btnNewButton_1);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		textPane.setText("None");
		textPane.setBounds(40, 96, 307, 311);
		textPane.setEditable(false);
		contentPane.add(textPane);
		
		JLabel lblTheOrderInformaiton = new JLabel("The Order Informaiton");
		lblTheOrderInformaiton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTheOrderInformaiton.setBounds(71, 36, 247, 47);
		contentPane.add(lblTheOrderInformaiton);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.repaint();
				c.EditOrder();
			}
		});
		btnEdit.setBounds(71, 437, 87, 23);
		contentPane.add(btnEdit);
	}
	
	public void setType(String type) {
		this.selectedItem = type;
	}
	
	public void textPaneSet(String account,String total,String discount,String shippingFee,String payment,String pay_type) {
		this.textPane.setText("Account："+account+"\rTotalPrice： "+total+"\rDiscount: "+discount+"\rShipping Fee: "+shippingFee+"\rPayment:"+payment+"\rPayment type:"+pay_type);
	}
}
