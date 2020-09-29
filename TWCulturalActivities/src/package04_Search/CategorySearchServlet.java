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

@WebServlet("/CategorySearchServlet")
public class CategorySearchServlet extends HttpServlet {

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
		// 分類查詢

		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
	
		try {

			
			String queryVal = request.getParameter("category");
			SelectDAO selectDAO = new SelectDAO();
			List<ShowOj> showList = selectDAO.Showlist();
			for (ShowOj showOj : showList) {
				String category =Integer.toString(showOj.getACT_CATEGORY());
					int noint  = showOj.getACT_NO();
					String titleString = showOj.getACT_TITLE();
					String siteString = showOj.getACT_LOCATION_NAME();
					if (queryVal.equals(category)) {
//					System.out.println(noint);
//					System.out.println(titleString);
//					System.out.println(siteString);
//					
					Map map = new HashMap(); 
					map.put("no", noint);			
					map.put("title", titleString);		
					map.put("site", siteString);							
					//存入map集合中
					System.out.println(map);
					list.add(map);//將map集合放入list集合
//					System.out.println("放入集合");
					for (Map map_1 :list) {
//						System.out.println(map_1);
					}

//					request.setAttribute("noint", noint);
//					request.setAttribute("title", titleString);
//					request.setAttribute("site", siteString);
					
				}
			}
			}catch (Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("key_list",list);//将list放入request中
		RequestDispatcher dispatcher = request.getRequestDispatcher("/04_select.jsp");
		dispatcher.forward(request, response);
		

		
	}
}
