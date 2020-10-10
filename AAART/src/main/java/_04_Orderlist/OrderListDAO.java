package _04_Orderlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import _04_Orderlist.*;
import _04_ST.ShowOj;


public class OrderListDAO {
 	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// 設定oracle連線方法
	public DataSource getDataSource() {
		if (dataSource == null) {
			System.out.println("進入連線");
			BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName("oracle.jdbc.OracleDriver");
			ds.setUrl("jdbc:oracle:thin:@//localhost:1521/xepdb1");
			ds.setUsername("group4");
			ds.setPassword("oracle");
			ds.setMaxTotal(50); // 設定最多connection上線,超過使用量必須等待
			ds.setMaxIdle(50); // 設定最多idle的connection,超過的connection會被執行connection.close()
			dataSource = ds;
		}
		return dataSource;
	}

	//void 代表什麼都不返回，即無return
	//建立一個addlist
	//Orderlistbean類別的物件-orderlist ex int 5
	public Orderlistbean addlist(Orderlistbean orderlist) {
		
		System.out.println("進入方法");
		String liString = "INSERT INTO ORDERLIST (ORDERID,NAME,EMAIL,TEL,ADDRESS,ACT_ID,TITLE,HALF_NUM,ADULT_NUM,TOTALPRICE) VALUES (?,?,?,?,?,?,?,?,?,?)";
		try (
				Connection conn = getDataSource().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(liString);
				) {
				pstmt.setString(1, orderlist.getORDERID());
				pstmt.setString(2, orderlist.getNAME());
				pstmt.setString(3, orderlist.getEMAIL());
				pstmt.setString(4, orderlist.getTEL());
				pstmt.setString(5, orderlist.getADDRESS());
				pstmt.setString(6, orderlist.getACT_ID());
				pstmt.setString(7, orderlist.getTITLE());
				pstmt.setInt(8, orderlist.getHALF_NUM());
				pstmt.setInt(9, orderlist.getADULT_NUM());
				pstmt.setInt(10, orderlist.getTOTALPRICE());
				pstmt.executeUpdate();
				System.out.println("已插入");
				return orderlist;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//建一個showlist方法，類型為list
		public List<Orderlistbean> GetOrderlist() {
			//實作一個arrylist，list為介面
			List<Orderlistbean> orderlists = new ArrayList<Orderlistbean>();
			try (
					Connection conn = getDataSource().getConnection();
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("select * FROM ORDERLIST ")) {
					//取得所有table內資料 
					//用setxxx將值放入 方便之後用getxxx取值(之後就不用寫SQL語法)
				while (rs.next()) {
					Orderlistbean orderlistbean = new Orderlistbean(); //建一個show物件，ShowOj只是藍圖沒有物件
					orderlistbean.setORDERID(rs.getString("ORDERID"));
					orderlistbean.setNAME(rs.getString("NAME"));
					orderlistbean.setEMAIL(rs.getString("EMAIL"));
					orderlistbean.setTEL(rs.getString("TEL"));
					orderlistbean.setADDRESS(rs.getString("ADDRESS"));
					orderlistbean.setACT_ID(rs.getString("ACT_ID"));
					orderlistbean.setTITLE(rs.getString("TITLE"));
					orderlistbean.setHALF_NUM(rs.getInt("HALF_NUM"));
					orderlistbean.setADULT_NUM(rs.getInt("ADULT_NUM"));
					orderlistbean.setTOTALPRICE(rs.getInt("TOTALPRICE"));
					orderlists.add(orderlistbean);
					}
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			return orderlists;
		}
		
		
		
		
		//訂單編號生成
		public  String getOrderIdByTime() {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String newDate = sdf.format(new Date());
			String result = "";
			Random random = new Random();
			for (int i = 0; i < 3; i++) {
				result += random.nextInt(10);
			}
			return newDate + result;
	}
		
		
		
		
		
}
