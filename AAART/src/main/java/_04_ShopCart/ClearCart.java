package _04_ShopCart;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/_04_ShopCart/ClearCart")
public class ClearCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//	HttpServletRequest request = ServletActionContext.getRequest();	
//	HttpSession session1 = request.getSession();
//	session1.invalidate();
//	return super.execute();
	
	System.out.println("清除session");
	
	request.getSession().invalidate();
	
	
//	HttpSession session=request.getSession();
//	Set<Map> cartlist = (Set<Map>) session.getAttribute("cartlist");	
//	session.setAttribute("cartlist", cartlist);	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/_04_ST/04_Booking2.jsp");
	dispatcher.forward(request, response);
		
		
		
		
		
		
	}

}
