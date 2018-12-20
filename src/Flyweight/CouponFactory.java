package Flyweight;

import java.util.Hashtable;

public class CouponFactory {

	private Hashtable<String, Coupon> coupons = new Hashtable<String, Coupon>();
	public Coupon getCoupon(String key) {
		Coupon coupon = (Coupon) coupons.get(key);
		if (coupon == null) {
			coupon = new Coupon(key);
			coupons.put(key, coupon);
		}
		return coupon;
	}
	
	public boolean checkCoupon(String thisCoupon) {
		System.out.println("thisCoupon :" + thisCoupon);
		for (Object key : coupons.keySet()) {
			System.out.print(coupons.get(key).getID());
            if(coupons.get(key).getID().equals(thisCoupon)) {
            	return true;
            }
        }
		return false;
	}
}
