package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller_Mediator.PaymentCheck_controller;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;

public class PaymentCheck_View extends JFrame {

	private JPanel contentPane = new JPanel();
	private JTextField textField;
	private JPanel CreditCard_Check;
	private JPanel LinePay_Check;
	private JPanel WeChat_Check;
	//private PaymentCheck_controller controller = new PaymentCheck_controller();
	
	/**
	 * Launch the application.
	 *
	/**
	 * Create the frame.
	 */
	public PaymentCheck_View() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Payment Check");
		setBounds(100, 100, 413, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
	
	public void contentPaneChange(JPanel s) {
		this.contentPane.add(s);
	}
}
