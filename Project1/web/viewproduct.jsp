<%-- 
    Document   : viewproduct
    Created on : Apr 4, 2016, 8:22:24 PM
    Author     : hungtran
--%>
<%@page import="model.Product" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Product</title>
    </head>
    <body>
        <% ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");%>
        <h1>List Products</h1>
        <table cellspacing="5" cellpadding="5" border="1">
            <thead>
                <tr align="center">
                    <th>Code</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th colspan="2"></th>

                </tr>
            </thead>
            <tbody>

                <% for (Product p : products) {%>
                <tr>
                    <td><%= p.getCode()%></td>
                    <td><%= p.getDescription()%></td>
                    <td><%= p.getPrice()%></td>
                    <td><a href="editproduct?productCode=<%= p.getCode()%>">Edit</a></td>
                    <td><a href="deleteproduct?productCode=<%= p.getCode()%>">Delete</a></td>

                </tr>

                <%}%>


            </tbody>
        </table>
        <br><br>
        <form action="addproduct" method="get">
            <input type="submit" value="Add Product">
        </form>
    </body>
</html>
