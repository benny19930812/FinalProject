package _04_ST;

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
import _04_ST.SelectDAO;

@WebServlet("/_04_ST/CategorySearchServlet")
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
		List<Map> list = new ArrayList<Map>();
		// 分類查詢

		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();

		try {

			String queryVal = request.getParameter("category");
			SelectDAO selectDAO = new SelectDAO();
			List<ShowOj> showList = selectDAO.Showlist();
			for (ShowOj showOj : showList) {
				String category = Integer.toString(showOj.getACT_CATEGORY());
				int noint = showOj.getACT_NO();
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
					// 存入map集合中
//					System.out.println(map);
					list.add(map);// 將map集合放入list集合
//					System.out.println("放入集合");
					for (Map map_1 : list) {
//						System.out.println(map_1);
					}

				}
			}
			//計算列表數量
			int listsize = list.size();
			System.out.println("共"+listsize+"筆資料");
		} catch (Exception e) {
			// TODO: handle exception
		}

		request.setAttribute("key_list", list);// 将list放入request中
		RequestDispatcher dispatcher = request.getRequestDispatcher("/_04_ST/04_select.jsp");
		dispatcher.forward(request, response);

	}
}
