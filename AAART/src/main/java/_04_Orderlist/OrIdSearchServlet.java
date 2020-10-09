package _04_Orderlist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import _04_Orderlist.*;

@WebServlet("/_04_Orderlist/OrIdSearchServlet")
public class OrIdSearchServlet extends HttpServlet {

	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	DataSource ds = null;

	public void init() throws ServletException {
		try {
			InitialContext ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/xe"); // for Oracle DB
		} catch (NamingException ne) {
			throw new ServletException(ne);
		}
	}

//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Map> orderlist = new ArrayList<Map>();
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		try {
			String queryVal = request.getParameter("orderid");

			OrderListDAO orderListDAO = new OrderListDAO();
			List<Orderlistbean> orderlists = orderListDAO.GetOrderlist();
			for (Orderlistbean orderlistbean  : orderlists ) {
				String orderid =orderlistbean.getORDERID();
				String name = orderlistbean.getNAME();
				String email = orderlistbean.getEMAIL();
				String tel = orderlistbean.getTEL();
				String address = orderlistbean.getADDRESS();
				String actid = orderlistbean.getACT_ID();
				String title = orderlistbean.getTITLE();
				int halfnum =orderlistbean.getHALF_NUM();
				int adultnum = orderlistbean.getADULT_NUM();
				int totalprice = orderlistbean.getTOTALPRICE();

				if (queryVal.equals(orderid)) {
//					System.out.println(noint);
//					System.out.println(titleString);
//					System.out.println(siteString);
//					
					Map map = new HashMap();
					map.put("orderid", orderid);
					map.put("name", name);
					map.put("email", email);
					map.put("tel", tel);
					map.put("address", address);
					map.put("title", title);
					map.put("actid", actid);
					map.put("halfnum", halfnum);
					map.put("adultnum",adultnum);
					map.put("totalprice", totalprice);
					// 存入map集合中
					System.out.println(map);
					orderlist.add(map);// 將map集合放入list集合
//					System.out.println("放入集合");
					for (Map map_1 : orderlist) {
						System.out.println(map_1);
					}

				}
			}

//			request.setAttribute("queryVal", queryVal);
//			request.setAttribute("category", queryCate);
//			request.setAttribute("site", querysite);
//			request.setAttribute("startdate", querystartdate);
//			request.setAttribute("enddate", queryenddate);
		} catch (Exception e) {
			// TODO: handle exception
			int listsize = orderlist.size();
			System.out.println("共" + listsize + "筆資料");

		}

		request.setAttribute("getorlist", orderlist);// 将list放入request中
		RequestDispatcher dispatcher = request.getRequestDispatcher("/_04_Orderlist/ShowOrderlist.jsp");
		dispatcher.forward(request, response);

	}
}
