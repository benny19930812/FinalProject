package _04_Orderlist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.apache.commons.pool2.impl.AbandonedConfig;
import _04_Orderlist.*;
import _04_ShopCart.CartMap;


@WebServlet("/_04_Orderlist/OrderlistServlet")
public class OrderlistServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;    
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
	DataSource ds = null;
	
	public void init() throws ServletException {
		try {
			//在InitialContext取得JDBC連線資料
			InitialContext ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/xe"); // for Oracle DB
			System.out.println("DB連接成功");
		} catch (NamingException ne) {
			throw new ServletException(ne);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);

		try {
			String NAME = (String) request.getSession().getAttribute("name");
			String EMAIL = (String) request.getSession().getAttribute("email");
			String TEL = (String) request.getSession().getAttribute("tel");
			String ADDRESS = (String) request.getSession().getAttribute("add");

			
			
			
			OrderListDAO orderListDAO =new OrderListDAO();
			//建立orderListDAO物件
			
			System.out.println("here");
			
			Orderlistbean orderlist = new Orderlistbean();
			//建立orderlist物件
			String ORDERID =orderListDAO.getOrderIdByTime();
			//建立物件 . 來調用方法
			
			orderlist.setORDERID(ORDERID);
			orderlist.setNAME(NAME);			
			orderlist.setEMAIL(EMAIL);
			orderlist.setTEL(TEL);
			orderlist.setADDRESS(ADDRESS);
			orderListDAO.addUser(orderlist);
			System.out.println("商品");
//			System.out.println(cartmap);
			
			
			
			
			
			
			HashSet<HashMap>  cartlist =(HashSet<HashMap>) request.getSession().getAttribute("cartlist");
			for (HashMap carmap : cartlist) {

				System.out.println(carmap.get("title"));	
				System.out.println(carmap.get("halfnum"));	
				System.out.println(carmap.get("adultnum"));	
				System.out.println(carmap.get("total1"));	
				System.out.println(carmap.get("total2"));	
				System.out.println(carmap.get("totalprice"));
				
				
				String title = (String) carmap.get("title");	
				//carmap.get("halfnum")取得為string用Integer.parseInt轉型為int
				int halfnum = Integer.parseInt((String) carmap.get("halfnum"));	
				int adultnum =  Integer.parseInt((String) carmap.get("adultnum"));	
//				int total1 = Integer.parseInt((String) carmap.get("total1"));	
//				int total2 = Integer.parseInt((String) carmap.get("total2"));	
				int totalprice = Integer.parseInt((String) carmap.get("totalprice"));				
				Orderlistbean orderlist2 = new Orderlistbean();
				orderlist2.setORDERID(ORDERID);
				orderlist2.setTITLE(title);
				orderlist2.setHALF_NUM(halfnum);
				orderlist2.setADULT_NUM(adultnum);
				orderlist2.setTOTALPRICE(totalprice);
				orderListDAO.addlist(orderlist2);
						
			}

//			String TITLE = cartlist.
//			int HALF_NUM = Integer.parseInt((String) request.getSession().getAttribute("halfnum"));			
//			int ADULT_NUM = Integer.parseInt((String) request.getSession().getAttribute("adultnum"));
//			int TOTALPRICE = Integer.parseInt((String) request.getSession().getAttribute("total3"));
	
//			//建立orderListDAO物件
//			Orderlistbean orderlist2 = new Orderlistbean();
//			//建立orderlist物件
//			
//			orderlist2.setORDERID(ORDERID);
//			orderlist2.setTITLE(TITLE);
//			orderlist2.setHALF_NUM(HALF_NUM);
//			orderlist2.setADULT_NUM(ADULT_NUM);
//			orderlist2.setTOTALPRICE(TOTALPRICE);
//			orderListDAO.addlist(orderlist2);
			
			PrintWriter out = response.getWriter();
	        System.out.println("訂單已成立");
	        
			
	        request.setAttribute("orderid", ORDERID);

			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/_04_Orderlist/ThxOrder.jsp");
		dispatcher.forward(request, response);
		
	}
//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType(CONTENT_TYPE);
//		doPost(request, response);
//	}

}
