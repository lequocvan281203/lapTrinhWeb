package vn.iostar.controllers.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.models.CategoryModel;
import vn.iostar.services.ICategoryService;
import vn.iostar.services.impl.CategoryServiceImlp;

@WebServlet(urlPatterns = {"/admin/categories"})
public class CategoryController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public ICategoryService cateService = new CategoryServiceImlp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModel> list = cateService.findAll();
		req.setAttribute("listcate", list);
		req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
	}

}
