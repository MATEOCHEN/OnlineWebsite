package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Composite.Component;
import Controller_Mediator.Controller_mediator;
import Controller_Mediator.Home1_Controller;
import Controller_Mediator.Home_Controller;
import Controller_Mediator.Warehouse_Controller;
import Observer.Concrete_Subject;
import account.Account;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Choice;

public class Warehouse_View extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private Warehouse_Controller warehouse_Controller;

	Choice choice;
	JButton btnNewButton;
	Component ware_list;
	
	Account account;
	Concrete_Subject concrete_subject;  
	
	public Warehouse_View() {
		setTitle("Warehouse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1000, 100, 395, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("進行補貨");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ware_list = warehouse_Controller.getControllerMediator().CallProdulist_getwarehouse_composite();
				account = warehouse_Controller.getControllerMediator().getAccount();
				
					for(Component lists : ware_list.getList()) {
					if(lists.getName().equals(choice.getSelectedItem())) {
						int quantity = Integer.valueOf(textField.getText());
						lists.setQuantity(lists.getQuantity()+quantity);
						System.out.println("商品:"+ lists.getName() +" 目前商品數量: "+lists.getQuantity());
						concrete_subject = warehouse_Controller.getControllerMediator().getConcrete_Subject();	
						concrete_subject.notify_account(lists.getName());
						
						ImageIcon alarm_red= new ImageIcon("src/alarm2.png");
						warehouse_Controller.getControllerMediator().changeNotifyImage(alarm_red);
						
					}
				}
			}
		});
		btnNewButton.setBounds(257, 209, 87, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("商品名稱");
		lblNewLabel.setBounds(55, 178, 62, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("數量");
		lblNewLabel_1.setBounds(155, 178, 46, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(155, 210, 75, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		choice = new Choice();
		choice.setBounds(36, 209, 98, 21);
		contentPane.add(choice);
		
		choice.add("N_Clothes1");
		choice.add("N_Clothes2");
		choice.add("N_Pant1");
		choice.add("N_Pant2");
		choice.add("N_Shoes1");
		choice.add("N_Shoes2");
		
		choice.add("A_Clothes1");
		choice.add("A_Clothes2");
		choice.add("A_Pant1");
		choice.add("A_Pant2");
		choice.add("A_Shoes1");
		choice.add("A_Shoes2");
		
	}
	
	//--設置Controller
		public void SetController(Warehouse_Controller warehouse_Controller) {
			this.warehouse_Controller = warehouse_Controller;
		}
		//-----------------
	
}
