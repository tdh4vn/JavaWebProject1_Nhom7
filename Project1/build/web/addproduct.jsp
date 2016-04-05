<%-- 
    Document   : addproduct
    Created on : Apr 4, 2016, 8:39:14 PM
    Author     : hungtran
--%>

<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
    </head>
    <body>
        <%
            // get attributes from the request
            Product product = (Product) request.getAttribute("product");
            String message1 = (String) request.getAttribute("message1");
            String message2 = (String) request.getAttribute("message2");
            String message3 = (String) request.getAttribute("message3");
            String message4 = (String) request.getAttribute("message4");

            // handle null values
            if (product == null) {
                product = new Product();
            }
            if (message1 == null) {
                message1 = "";
            }
            if (message2 == null) {
                message2 = "";
            }
            if (message3 == null) {
                message3 = "";
            }
            if (message4 == null) {
                message4 = "";
            }
        %>
        <h1>Product</h1>
        <p ><i><%= message1%></i></p>
        <p ><i><%= message2%></i></p>
        <p><i><%= message3%></i></p>
        <p><i><%= message4%></i></p>
        <table cellspacing="5" border="0">
            <form action="addproduct" method="post">
                <tr>
                    <td align="right">Product Code:</td>
                    <td align="right"><input type="text" name="productCode" value="<%=product.getCode()%>"></td>
                </tr>
                <tr>
                    <td align="right">Product Description:</td>
                    <td align="right"><input type="text" name="productDescription" value="<%=product.getDescription()%>"></td>
                </tr>
                <tr>
                    <td align="right">Product Price:</td>
                    <td align="right"><input type="text" name="productPrice" value="<%=product.getPrice()%>"></td>
                </tr>
                <tr>
                    <td>
                        <br><input type="submit" value="Add Product"></br>
                    </td>
                    <td>
                        <br><a href="viewproduct"><button>View Products</button></a></br>
                    </td>
                </tr>
            </form>
        </table>
    </body>
</html>
