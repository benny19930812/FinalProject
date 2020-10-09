package _04_Orderlist;

import java.io.IOException;
import java.io.PrintWriter;

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
//		HttpSession session = request.getSession(false);
		
		try {
			String ACT_ID = (String) request.getSession().getAttribute("actid");
			String NAME = (String) request.getSession().getAttribute("name");
			String EMAIL = (String) request.getSession().getAttribute("email");
			String TEL = (String) request.getSession().getAttribute("tel");
			String ADDRESS = (String) request.getSession().getAttribute("add");
			String TITLE = (String) request.getSession().getAttribute("title");
			int HALF_NUM = Integer.parseInt((String) request.getSession().getAttribute("halfnum"));			
			int ADULT_NUM = Integer.parseInt((String) request.getSession().getAttribute("adultnum"));
			int TOTALPRICE = Integer.parseInt((String) request.getSession().getAttribute("total3"));
			
			
			
			OrderListDAO orderListDAO =new OrderListDAO();
			//建立orderListDAO物件
			
			
			Orderlistbean orderlist = new Orderlistbean();
			//建立orderlist物件
			String ORDERID =orderListDAO.getOrderIdByTime();
			//建立物件 . 來調用方法
			
			orderlist.setORDERID(ORDERID);
			orderlist.setNAME(NAME);
			orderlist.setACT_ID(ACT_ID);			
			orderlist.setEMAIL(EMAIL);
			orderlist.setTEL(TEL);
			orderlist.setADDRESS(ADDRESS);
			orderlist.setTITLE(TITLE);
			orderlist.setHALF_NUM(HALF_NUM);
			orderlist.setADULT_NUM(ADULT_NUM);
			orderlist.setTOTALPRICE(TOTALPRICE);
			orderListDAO.addlist(orderlist);
			
			PrintWriter out = response.getWriter();
	        System.out.println("訂單已成立");
	        
			
	        request.setAttribute("orderid", ORDERID);

			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/_04_Orderlist/ThxOrder.jsp");
		dispatcher.forward(request, response);
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		doPost(request, response);
	}

}
