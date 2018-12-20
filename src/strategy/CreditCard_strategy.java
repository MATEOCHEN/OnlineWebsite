package strategy;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreditCard_strategy implements Strategy{
	
	private JLabel lblInputCreditCard;
	private JPanel CreditCard_Check;
	private JTextField numberInput_column;
	@Override
	public JPanel showGUI() {
		// TODO Auto-generated method stub
		CreditCard_Check = new JPanel();
		CreditCard_Check.setBounds(0, 0, 400, 253);
		CreditCard_Check.setLayout(null);
		
		lblInputCreditCard = new JLabel("Input Credit Card Number ");
		lblInputCreditCard.setBounds(52, 49, 283, 29);
		lblInputCreditCard.setFont(new Font("Tahoma", Font.PLAIN, 24));
		CreditCard_Check.add(lblInputCreditCard);
		
		numberInput_column = new JTextField();
		numberInput_column.setToolTipText("");
		numberInput_column.setBounds(52, 127, 289, 47);
		numberInput_column.setColumns(10);
		CreditCard_Check.add(numberInput_column);
		return CreditCard_Check;
	}

}
