package package04_Search;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.*;
import javax.sql.*;

import org.apache.catalina.loader.WebappClassLoader;
import org.apache.el.lang.ELArithmetic;

@WebServlet("/SiteSearchServlet2")
public class SiteSearchServlet2 extends HttpServlet {
	public List<ShowOj> Showlist() {
		//實作一個arrylist，list為介面
		List<ShowOj> lists = new ArrayList<ShowOj>();
		return lists;
	}

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

	public void doPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Map> list =new ArrayList<Map>();
		// Searchall
		String queryVal = request.getParameter("site");
		String query = "SELECT ACT_NO,ACT_TITLE,ACT_LOCATION_NAME FROM MAINTABLE " + "WHERE ACT_TITLE LIKE \'%" + queryVal + "%\'";
//    System.out.println(query);     
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();

		try {
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
//			request.setAttribute("RS", rs);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/04_select.jsp");
//			dispatcher.forward(request, response);
			
			for (int count = 0;; count++) {
				if (rs.next()) {
					String no = rs.getString(1);
					String title = rs.getString(2);
					String site = rs.getString(3);
					System.out.println(no);
					System.out.println(title);		
					System.out.println(site);		
				
					Map map = new HashMap(); 
					map.put("no", no);			
					map.put("title", title);		
					map.put("site", site);		
					
					//用键值对存入到map集合中
					System.out.println(map);
					list.add(map);//在将map集合对象存入list集合
					System.out.println("放入集合");
					for (Map map_1 :list) {
						System.out.println(map_1);
					}//在打印台遍历出数据查看是否有错误

				
				} else {
             System.out.println(count);
           break;
				}
//				request.setAttribute("no", no);
//				request.setAttribute("title", title);
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/04_select.jsp");
//				dispatcher.forward(request, response);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace(out);
		}
		request.setAttribute("key_list",list);//将list集合数据放入到request中共享
		request.getRequestDispatcher("/04_select.jsp").forward(request, response);
		out.close();
	}
}
