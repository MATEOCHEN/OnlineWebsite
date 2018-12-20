package strategy;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LinePay_strategy implements Strategy{
	private JPanel LinePay_Check;
	private JLabel lblP;
	private ImageIcon  linePay= new ImageIcon("src/LinePay.png");
	private Image image = linePay.getImage();
	private Image line_pic = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
	@Override
	public JPanel showGUI() {
		
		// TODO Auto-generated method stub
		LinePay_Check = new JPanel();
		LinePay_Check.setBounds(0, 0, 400, 253);
		LinePay_Check.setLayout(null);
		
		lblP = new JLabel("Line Pay");
		lblP.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblP.setBounds(138, 13, 101, 65);
		LinePay_Check.add(lblP);
		
		JLabel LinePay_pic = new JLabel("");
		LinePay_pic.setBounds(104, 79, 168, 161);
		LinePay_pic.setIcon(new ImageIcon(line_pic));
		LinePay_Check.add(LinePay_pic);
		
		return LinePay_Check;
	}
}
