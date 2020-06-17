package action.v1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import action.Action;
import repository.ProductRepository;
import util.Script;

public class DeleteProcAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("DeleteProcAction");
		 int id = Integer.parseInt(request.getParameter("id"));
		 
		 ProductRepository productRepository = ProductRepository.getInstance();
		 int result = productRepository.deleteById(id);
		 
//		 Gson gson = new Gson();
//		 String toJson = gson.toJson(result);
//		 Script.outJson(toJson, response);
		
		 Script.outText(result+"", response);
		
		
	}

}
