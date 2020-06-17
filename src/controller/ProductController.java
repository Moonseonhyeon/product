package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.v1.DeleteProcAction;
import action.v1.가격순Action;
import action.v1.처음으로Action;
import action.v1.판매순Action;


@WebServlet("/productController")
public class ProductController extends HttpServlet {
	public static final String TAG = "ProductController : ";
	private static final long serialVersionUID = 1L;
       
    public ProductController() {
        super();        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		System.out.println(TAG+"router : "+cmd);
		action.Action action = router(cmd);
		action.execute(request, response);
	}
	
	public action.Action router(String cmd) {
		if(cmd.equals("처음으로")) {
			return new 처음으로Action();
		} else if(cmd.equals("가격순")) {
			return new 가격순Action();
		}else if(cmd.equals("판매순")) {
			return new 판매순Action();
		}else if(cmd.equals("deleteProc")) {
			return new DeleteProcAction();
		}
		return null;
	}

}
