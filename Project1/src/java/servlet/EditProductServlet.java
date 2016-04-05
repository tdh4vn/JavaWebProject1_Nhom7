/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import control.ProductIO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author hungtran
 */
@WebServlet(name = "EditProductServlet", urlPatterns = {"/EditProductServlet"})
public class EditProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ServletContext context = getServletContext();
       
       
        String url = "/editproduct.jsp";
        
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("productCode");
        ServletContext context = getServletContext();
        String path = context.getRealPath(
                "/WEB-INF/product.txt");
        Product product = ProductIO.getProduct(code, path);

        String url = "/editproduct.jsp";
        request.setAttribute("product", product);
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message1 = "";
        String message2 = "";
        String message3 = "";
        String message4 = "";
        String url = "";

        String code = request.getParameter("productCode");
        String description = request.getParameter("productDescription");
        String str = request.getParameter("productPrice");
        double price = 0;
        boolean b=true;
        try {
            double d = Double.parseDouble(str);
        } catch (Exception e) {
            b= false;
        }
        
        
        if (b) {
            price = Double.parseDouble(request.getParameter("productPrice"));
        } else {
            message1 = "Gia khong hop le";
        }

        Product product = new Product(code, description, price);

        if (code.length() == 0 || description.length() == 0 || str.length() == 0 || message1.equals("Gia khong hop le")) {

            if (code.length() == 0) {
                message2 = "Ban Chua Nhap Product Code";
            }

            if (description.length() == 0) {
                message3 = "Ban Chua Nhap Product Description";
            }

            if (str.length() == 0) {

                message4 = "Ban Chua Nhap Product Price";

            }

            url = "/editproduct.jsp";
        } else {
            message1 = "";
            message2 = "";
            message3 = "";
            message4 = "";
            ServletContext context = getServletContext();
            String path = context.getRealPath(
                    "/WEB-INF/product.txt");
            ProductIO.update(product, path);

            url = "/viewproduct";
        }
        request.setAttribute("product", product);
        request.setAttribute("message1", message1);
        request.setAttribute("message2", message2);
        request.setAttribute("message3", message3);
        request.setAttribute("message4", message4);

        // forward request and response to the view
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
