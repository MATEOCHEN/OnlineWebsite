package Flyweight;

public class Coupon implements Flyweight {
	
	//intrinsicState
	private String couponName = "Song Song Song Coupon";
	private int couponValue = 500;
	private String couponID = "HD431M09000";

	//extrinsicState
	private String userName;

	public Coupon(String keyName) {
		userName = keyName.toUpperCase();
		setID();
	}
	
	public String getCouponName() {
		return couponName;
	}

	public int getCouponValue() {
		return couponValue;
	}

	public void setID() {
		couponID = couponID + userName;
	}
	public String getID() {
		return couponID;
	}
	
}
