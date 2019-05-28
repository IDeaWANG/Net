package product.servlet;

import product.dao.ProductDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

public class productServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
        ProductDao productDao = new ProductDao();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String date = req.getParameter("date");
        String action = req.getParameter("action");
        if(action.equalsIgnoreCase("all")){
            req.setAttribute("ps",productDao.findAll());
            resp.sendRedirect("product.jsp");
        }
        if (action.equalsIgnoreCase("add")) {
            productDao.insert(name, price, date);
            resp.sendRedirect("product.jsp");
        } else if (action.equalsIgnoreCase("findByName")) {
            productDao.findByName(name);
            resp.sendRedirect("product.jsp");
        } else if (action.equalsIgnoreCase("findById")) {
            productDao.findById(Integer.parseInt(id));
            resp.sendRedirect("product.jsp");
        } else if (action.equalsIgnoreCase("Update")) {
            productDao.update(Integer.parseInt(id), name, price, date);
            resp.sendRedirect("product.jsp");
        } else if (action.equalsIgnoreCase("delete")) {
            productDao.delete(Integer.parseInt(id));
            resp.sendRedirect("product.jsp");
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
        this.doGet(req, resp);
    }
}
