package action.v1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import action.Action;
import model.Product;
import repository.ProductRepository;
import util.Script;

public class 가격순Action implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("가격순Action");
		ProductRepository productRepository = ProductRepository.getInstance();
		
		List<Product> result = productRepository.findAll가격순();
		
		Gson gson = new Gson();
		String toJson = gson.toJson(result);
		Script.outJson(toJson, response);
		
	}

}
