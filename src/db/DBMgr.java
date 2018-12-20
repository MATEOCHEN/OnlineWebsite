package db;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Composite.Addidas_Clothes1;
import Composite.Component;

public class DBMgr {
	private static final String jdbcname= "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/online_shopping?useUnicode=true&characterEncoding=Big5&useSSL=false";
	private static final String account ="root";
	private static final String password = "130217975";
	//------The database connection information------
	
	private Connection conn = null;
	private Statement stat = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	private volatile static DBMgr db = null;	
	
	private DBMgr() {
		try {
			Class.forName(jdbcname);
			conn = DriverManager.getConnection(
			url,
			account,
			password);
		} catch(ClassNotFoundException e) {
			System.out.println("DriverClassNotFound :" +e.toString());
		} catch (SQLException x) {
			System.out.println("Exception :"+x.toString());
		}
	}
	
	public static DBMgr getInstance() {
		if(db == null ) {
			synchronized(DBMgr.class) {
				if(db==null) {
					db = new DBMgr();
				}
			}
		}
		return db;
	}//------use the LazyDoubleCheck Singleton to make sure the Database object to be a unique one------ 
	
	
	public void insertAccount(String email,String password,String name,String address,String phoneNumber) 
	  {
		String insertAccount = "INSERT INTO account(email,password,name,address,phoneNumber)" +
				"values(?,?,?,?,?)"; //------this is used to add the account.------
	    try 
	    { 
	      ps = conn.prepareStatement(insertAccount); 
	      
	      ps.setString(1, email); 
	      ps.setString(2, password);
	      ps.setString(3, name);
	      ps.setString(4, address);
	      ps.setString(5, phoneNumber);
	      ps.executeUpdate();
	      System.out.println("This Account is added!!");
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("InsertDB Exception :" + e.toString()); 
	    } 
	    finally 
	    { 
	      close(); 
	    } 
	  }
	
	public void insertShoppingCart(String email,String url,String pd_name,int pd_price,int pd_count) {
		String insertCart = "INSERT INTO shoppingcart(email,url,pd_name,pd_price,pd_count)" +
				"values(?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(insertCart); 
		      
		      ps.setString(1, email);
		      ps.setString(2, url); 
		      ps.setString(3, pd_name);
		      ps.setInt(4, pd_price);
		      ps.setInt(5, pd_count);
		      ps.executeUpdate();
		      System.out.println("Add the" + pd_name);
		}catch(SQLException e)  {
			System.out.println("InsertDB Exception :" + e.toString()); 
		}
		finally{
			close();
		}
	}
	
	public void updateQuantity(String email,String pd_name , int quantity) {
		String addCount = new StringBuilder().append("UPDATE shoppingcart SET pd_count =")
				.append("'")
				.append(quantity)
				.append("'")
				.append("WHERE email =") 
				.append("'")
				.append(email)
				.append("'")
				.append("AND ")
				.append("pd_name =")
				.append("'")
				.append(pd_name)
				.append("'")
				.append("").toString();
		
		try {
			ps = conn.prepareStatement(addCount); 
			ps.executeUpdate();
		}catch(SQLException e)  {
			System.out.println("InsertDB Exception :" + e.toString()); 
		}
		finally{
			close();
		}
	}
	
	public void deleteCartItem(String email,String pd_name) {
		String deleteItem = new StringBuilder().append("DELETE FROM shoppingcart WHERE email =")
				.append("'")
				.append(email)
				.append("'")
				.append("&& ")
				.append("pd_name=")
				.append("'")
				.append(pd_name)
				.append("'").toString();
		
		try {
			ps = conn.prepareStatement(deleteItem); 
			ps.executeUpdate();
			System.out.println("delete success");
		}catch(SQLException e)  {
			System.out.println("DeleteDB Exception :" + e.toString()); 
		}
		finally{
			close();
		}
	}
	
	public boolean verifyAccount(String email,String passwd) {
		String searchAccount = new StringBuilder().append("SELECT name FROM account WHERE email =")
												.append("'")
												.append(email)
												.append("'")
												.append("&& password=")
												.append("'")
												.append(passwd)
												.append("'").toString();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(searchAccount);
			
			if(rs.next()) {
				System.out.println("Hello!!  "+rs.getString("name"));
				return true;
			} 		
		}catch(SQLException e){
			System.out.println("SearchDB Exception ：" + e.toString());
		}
		finally{
			close();
		}
		return false;
	} //------Used to check whether the account is stored in the database.------
	
	
	public ResultSet getAccount(String email) {
		String searchAccount = new StringBuilder().append("SELECT * FROM account WHERE email =")
				.append("'")
				.append(email)
				.append("'").toString();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(searchAccount);
			
			if(!rs.next()) {
				return null;
			}
		}
		catch(SQLException e) {
			System.out.println("SearchDB Exception ：" + e.toString());
		}
		
		return rs;
	}
	
	public ArrayList<Component> getShoppingCart(String email) {
		ArrayList<Component> shopcart =  new ArrayList<Component>();
		
		String searchShopCart = new StringBuilder().append("SELECT * FROM shoppingcart WHERE email =")
				.append("'")
				.append(email)
				.append("'").toString();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(searchShopCart);
			
			while(rs.next()) {
				Image image = ImageIO.read(new File(rs.getString("url")));
				ImageIcon icon = new ImageIcon(image);
				Addidas_Clothes1 c = new Addidas_Clothes1(icon,rs.getString("pd_name"),rs.getInt("pd_price"),rs.getInt("pd_count"));
				shopcart.add(c);
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		return shopcart;
	}
	
	
	
	
	private void close() {
		try {
		if(rs!=null) 
	      { 
	        rs.close(); 
	        rs = null; 
	      } 
	      if(stat!=null) 
	      { 
	        stat.close(); 
	        stat = null; 
	      } 
	      if(ps!=null) 
	      { 
	        ps.close(); 
	        ps = null; 
	      } 
		} catch (SQLException e) {
			System.out.println("Close Exception :" + e.toString()); 
		}
	}
	
	public static void main(String args[]) {
		//System.out.println(Database.getInstance().verifyAccount("stezen129@gmail.com", "130217975"));//testing
	}
}
