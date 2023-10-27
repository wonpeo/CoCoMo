package SHOP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SHOP.CartService;
import SHOP.Customer;
import SHOP.CartDto;
import SHOP.CartAllDto;

import com.google.gson.Gson;

@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartService cartService;
       
    public CartController() {
        super();
        this.cartService = new CartService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");

		if (cmd.equals("cartAdd")) {
			Gson gson = new Gson();
			BufferedReader br = request.getReader();
			PrintWriter out = response.getWriter();
			String data = br.readLine();
			CartDto cartDto = gson.fromJson(data, CartDto.class);
			
			
			int result = cartService.addC(cartDto);
			
			if (result == 1) {
				out.print("200");
			} else {
				out.print("500");
			}
			out.flush();
				
		} else if (cmd.equals("cartRmv")) {
			Gson gson = new Gson();
			BufferedReader br = request.getReader();
			PrintWriter out = response.getWriter();
			String data = br.readLine();
			CartDto cartDto = gson.fromJson(data, CartDto.class);
			
			int result = cartService.delC(cartDto);
			
			if (result == 1) {
				out.print("200");
			} else {
				out.print("500");
			}
			out.flush();

		} else if (cmd.equals("cartList")) {
			HttpSession session = request.getSession();
			Customer customer = (Customer) session.getAttribute("customer");//�����ذ�
			int userId = customer.getNum();//����
			
			/*List<Integer> favorProdIdList = cartService.��ҷ�����(userId);
			request.setAttribute("favorProdIdList", favorProdIdList);*/

			List<CartAllDto> cartDtoList = cartService.callC(userId);
			request.setAttribute("cartDtoList", cartDtoList);
			
			RequestDispatcher dis = request.getRequestDispatcher("/Cart.jsp");
			dis.forward(request, response);

		}

	}
}
