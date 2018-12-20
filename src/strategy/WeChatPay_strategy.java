package strategy;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WeChatPay_strategy implements Strategy{
	private JLabel lblWechatPay;
	private JPanel WeChat_Check;
	private ImageIcon  WeChatPay= new ImageIcon("src/WechatPay.png");
	private Image image1 = WeChatPay.getImage();
	private Image wechat_pic = image1.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
	@Override
	public JPanel showGUI() {
		WeChat_Check = new JPanel();
		WeChat_Check.setBounds(0, 0, 400, 253);
		WeChat_Check.setLayout(null);
		
		// TODO Auto-generated method stub
		lblWechatPay = new JLabel("WeChat Pay");
		lblWechatPay.setBounds(125, 13, 150, 80);
		lblWechatPay.setFont(new Font("Tahoma", Font.PLAIN, 24));
		WeChat_Check.add(lblWechatPay);
		
		JLabel WeChat_pic = new JLabel("");
		WeChat_pic.setBounds(104, 79, 168, 161);
		WeChat_pic.setIcon(new ImageIcon(wechat_pic));
		WeChat_Check.add(WeChat_pic);
		
		return WeChat_Check;
	}

}
