package Controller_Mediator;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.omg.CORBA.SystemException;

import Composite.Component;
import Composite.WareHouse_Composite;
import View.Home_View;
import View.PdList_View;

public class ProductList_Controller {
	public Controller_mediator cm;
	ArrayList<Component> ware_list;
	ArrayList<Component> record_list= new ArrayList<Component>();
	Component ware_composite;
	private PdList_View pdlist_view;		
	private String mark;

	private String Help; 
	PdList_View pdList_View;
	public ImageIcon icon;
	
	public ProductList_Controller(Controller_mediator cm,PdList_View pdlist_view) {
		this.cm = cm;
		this.pdlist_view=pdlist_view;
	}
	
	//---------呼叫mediator 轉換介面------------------
	public void CallHome() {
		cm.pdListCloseView();
		cm.homeOpenView();
	}
	public void CallPdIn() {
		cm.pdListCloseView();
		cm.pdInOpenView();
	}
	
	public void CallLogin() {
		cm.pdInCloseView();
		cm.loginOpenView();
	}
	
	public void CallCart() {
		cm.pdInCloseView();
		cm.shopOpenView();
	}
	//-
	//---------結束------------------
	
	//-----------View open and close-----------
	
	public void Openhome_view() {
		pdlist_view.setVisible(true);
	}
	public void Closehome_view() {
		pdlist_view.setVisible(false);
	}
	//-----------View open and close-----------
	
	
	public void ShowHelpMessage() {
		Help="1: Login與Register按鈕進行登入與註冊\n2: 下方可以點選衣服、褲子、鞋子";
		JOptionPane.showMessageDialog(null, Help,"操作流程",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void setMark(String mark) {
		this.mark=mark;
	}
	public void Callhome_setMark() {
		
	}
	public String getMark() {
		return mark;
	}
	//設定屬姓ware_composite 昌庫 =  傳入的 ware_composite 昌庫
	public void SetWare_list(Component ware_composite) {
		this.ware_composite = ware_composite;
		ware_list = ware_composite.getList();
		for(Component lists :ware_list) {
			System.out.println("圖3正在設定昌庫  目前的商品有"+lists.getName());
		}
	}
	//假設目前點選NC record_list會去昌庫(ware_lists) 拿取資料
	public void Record_list() {
		System.out.println("執行成功，record_list 正在比對 wekst_list 資料，如果正確，record_list將儲存資料 ");
		for(Component ware_lists : ware_list) {
			System.out.println("執行中");
			System.out.println("目前產品名稱為 == "+ware_lists.getName());
			System.out.println("目前產品IDE為 == "+ware_lists.getIDE());
			System.out.println("目前mark為 " + mark);
			if(ware_lists.getIDE().contains(mark)) {
				System.out.println("儲存成功\n");	
				record_list.add(ware_lists);
			}
			else {
				System.out.println("儲存失敗\n");	
			}

		}
		for(Component record_lists:record_list ) {
			System.out.println("目前record_list存放的資料有"+record_lists.getName());
		}
		
		for(int i=0; i<record_list.size(); i++) {
			Component c = record_list.get(i);
			pdlist_view.name[i]=c.getName();
			pdlist_view.price[i]=c.getPrice();
			pdlist_view.icon[i]=c.getImage();
		}
		
		pdlist_view.setAll();
	}
	
	public void remove_record_list() {
			System.out.println("正在刪除record_list  來自pdlist_controller");		 
			Iterator<Component> iterator = record_list.iterator();
	         while (iterator.hasNext()){
	            iterator.next();
	            iterator.remove();
	        }
	     	System.out.println("現在record_list[0]= "+record_list);			
	}
	
	
	//---------商品按鈕被按下 即將前往介面4 (PdList_View))
	public void EnterPress(int i) {
		Component c = record_list.get(i);
		System.out.println("Enter被按下"+c.getName());
		cm.CallPdIn_setRecord_component(c);
	}

	public void clear_picture() {
		pdlist_view.clearAll();
	}
	
	
	public void setGuestAccount() {
		cm.setGuestAccount();
	}
	
	public void setName(String name) {
		pdlist_view.setName(name);
	}
	
	public void SetLoginName(String name) {
		pdlist_view.setLoginName(name);
	}
	
	public Component getWarehouse_composite() {
		return ware_composite;
	}
	
	public void SetNotifyImage(ImageIcon icon) {
		pdlist_view.SetNotifyImage(icon);
	}
}
