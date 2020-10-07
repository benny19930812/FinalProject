package _04_ShopCart;

import java.io.Serializable;
import java.util.List;

import _04_ST.ShowOj;

//本類別封裝單筆訂單資料
public class CartBean implements Serializable{
	private double Car_no;
	private String Car_title;
	private String Car_adltNum;
	private String Car_halfNum;


		
		public double getCar_no() {
			return Car_no;
		}
		public void setCar_no(double car_no) {
			Car_no = car_no;
		}
		
		public String getCar_title() {
			return Car_title;
		}
		public void setCar_title(String car_title) {
			Car_title = car_title;
		}
		public String getCar_adltNum() {
			return Car_adltNum;
		}
		public void setCar_adltNum(String car_adltNum) {
			Car_adltNum = car_adltNum;
		}
		public String getCar_halfNum() {
			return Car_halfNum;
		}
		public void setCar_halfNum(String car_halfNum) {
			Car_halfNum = car_halfNum;
		}
		

	}
	
	
	
	
	
	
	
	

