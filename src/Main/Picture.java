package Main;

import javax.swing.ImageIcon;

public class Picture {
	String name[] = new String[30];
	String pd_detail[] = new String[30];
	String IDE[] = new String[30];
	int price[] = new int[30];
	ImageIcon icon[] = new ImageIcon[30];
	int quantity[] = new int[30];
	public Picture() {
		
	}

	public void SetImageIcon() {
		
		name[0]="N_Clothes1";
		name[1]="N_Clothes2";
		name[2]="N_Pant1";
		name[3]="N_Pant2";
		name[4]="N_Shoes1";
		name[5]="N_Shoes2";
		name[6]="A_Clothes1";
		name[7]="A_Clothes2";
		name[8]="A_Pant1";
		name[9]="A_Pant2";
		name[10]="A_Shoes1";
		name[11]="A_Shoes2";
		
		
	
		pd_detail[0]="Nike Dri-FIT Kobe 男款籃球 T 恤採用排汗材質搭配經典細節設計，有助於在場上保持乾爽舒適。";
		pd_detail[1]="2018 Netherlands Stadium Home 男款足球球衣採用透氣排汗布料，場上場下均能常保涼爽舒適。";
		pd_detail[2]="Nike Sportswear Tech Pack 男款織料工作褲採用編織材質與窄管版型，打造輕盈舒適的著感及俐落洗練的風格。多口袋設計，讓日常用品隨手可得。";
		pd_detail[3]="Chicago Bulls Nike Modern 男款 NBA 運動褲採用柔軟耐久的法國毛圈布材質與向下收窄的剪裁，即使劇烈活動，還是能自在地盡情暢動。";
		pd_detail[4]="Nike Air Max Deluxe 男鞋採用輕盈 Max Air 避震系統，全日穿著常保舒適，混搭結構則提供舒適支撐。";
		pd_detail[5]="Nike Hyperdunk X Low 氣墊打造絕佳緩震效果，讓你親眼所見、親身感受，而動態鞋帶系統則可常保雙足穩固貼合，專注比賽不分心。";
		
		pd_detail[6]="版型寬鬆的時尚 LOGO 上衣,Originals Logo 在 1972 年亮相後旋即成為潮流代名詞，這款上衣就運用了此經典元素。材質為舒適保暖的法國棉，版型寬鬆休閒。";
		pd_detail[7]="ORIGINALS LOGO 法國棉上衣,Originals Logo 自 1972 年問世後旋即成為運動潮流元素，亦是這款上衣的吸睛亮點。法國棉材質，著感柔軟舒適。";
		pd_detail[8]="別讓寒冷的天氣成為絆腳石。這款長褲能緊鎖熱能，讓你在賽場上保持舒適。布料質感輕盈。";
		pd_detail[9]="經典三條線設計長褲,這款九分運動褲採用合身剪裁，褲管略為緊縮，質感平滑舒適。兩側帶有三條線元素，Originals Logo 提升品牌辨識度。";
		pd_detail[10]="為城市跑者打造的彈性跑鞋,跑鞋類型：避震鞋款，打造柔軟回彈的腳感和靈活度，提供高避震表現,";
		pd_detail[11]="這款專為運動員打造的跑鞋配置柔軟彈性鞋面，完美包覆雙足，打造舒適腳感。彈力中底為足側加強支撐，緊密貼合足弓輪廓。";
		
		
		IDE[0]="NC01";
		IDE[1]="NC02";
		IDE[2]="NP01";
		IDE[3]="NP02";
		IDE[4]="NS01";
		IDE[5]="NS02";
		
		IDE[6]="AC01";
		IDE[7]="AC02";
		IDE[8]="AP01";
		IDE[9]="AP02";
		IDE[10]="AS01";
		IDE[11]="AS02";
		
		price[0]=1180;
		price[1]=2159;
		price[2]=3580;
		price[3]=1489;
		price[4]=5760;
		price[5]=3100;
		
		
		price[6]=3090;
		price[7]=3090;
		price[8]=1690;
		price[9]=2690;
		price[10]=6500;
		price[11]=3690;
		
		
		ImageIcon Nike_clothes_1= new ImageIcon("src/Nike/Nike_clothes_1.png");
		ImageIcon Nike_clothes_2= new ImageIcon("src/Nike/Nike_clothes_2.png");
		ImageIcon Nike_Pants_P1= new ImageIcon("src/Nike/Nike_Pants_P1.png");
		ImageIcon Nike_Pants_P2= new ImageIcon("src/Nike/Nike_Pants_P2.png");
		ImageIcon Nike_Shoes_P1= new ImageIcon("src/Nike/Nike_Shoes_P1.png");
		ImageIcon Nike_Shoes_P2= new ImageIcon("src/Nike/Nike_Shoes_P2.png");
		
		icon[0]=Nike_clothes_1;
		icon[1]=Nike_clothes_2;
		icon[2]=Nike_Pants_P1;
		icon[3]=Nike_Pants_P2;
		icon[4]=Nike_Shoes_P1;
		icon[5]=Nike_Shoes_P2;
		
		ImageIcon addidas_clothes_1 = new ImageIcon("src/Addidas/addidas_clothes_1.png");
		ImageIcon addidas_clothes_2 = new ImageIcon("src/Addidas/addidas_clothes_2.png");
		ImageIcon addidas_Pants_P1  = new ImageIcon("src/Addidas/addidas_Pants_P1.png");
		ImageIcon addidas_Pants_P2  = new ImageIcon("src/Addidas/addidas_Pants_P2.png");
		ImageIcon addidas_Shoes_P1  = new ImageIcon("src/Addidas/addidas_Shoes_P1.png");
		ImageIcon addidas_Shoes_P2  = new ImageIcon("src/Addidas/addidas_Shoes_P2.png");
		
		icon[6]=addidas_clothes_1;
		icon[7]=addidas_clothes_2;
		icon[8]=addidas_Pants_P1;
		icon[9]=addidas_Pants_P2;
		icon[10]=addidas_Shoes_P1;
		icon[11]=addidas_Shoes_P2;
		
		
		quantity[0]=0;
		quantity[1]=999;
		quantity[2]=999;
		quantity[3]=999;
		quantity[4]=999;
		quantity[5]=999;
	
		quantity[6]=999;
		quantity[7]=999;
		quantity[8]=999;
		quantity[9]=999;
		quantity[10]=999;
		quantity[11]=999;
		
		
	}
	
	public String[] getName() {
		return name;
	}
	
	public String[] getPd_detail() {
		return pd_detail;
	}
	
	public String[] getIDE() {
		return IDE;
	}
	
	public int[] getPrice() {
		return price;
	}
	
	public ImageIcon[] getImagIcon() {
		return icon;
	}
	
	public int[] getQuantity() {
		return quantity;
	}
}
