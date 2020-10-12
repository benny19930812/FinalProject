package _04_ShopCart;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DelectCart
 */
@WebServlet("/DelectCart")
public class DelectCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		Map cartmap =new HashMap();
//		cartmap.put("title", title);
//		cartmap.put("halfnum", halfnum);
//		cartmap.put("adultnum", adultnum);
//		cartmap.put("total1", total1);
//		cartmap.put("total2", total2);
//		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/_04_ShopCart/_04_ShoppingCart.jsp");
		dispatcher.forward(request, response);		
		

}

}