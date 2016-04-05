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
        <title>Edit Product</title>
    </head>
    <body>
        <%
            Product product = (Product) request.getAttribute("product");
        %>
        <table cellspacing="5" border="0">
            <form action="deleteproduct" method="post">
                <tr>
                    <td align="right">Product Code:</td>
                    <td align="right"><%=product.getCode()%></td>
                </tr>
                <tr>
                    <td align="right">Product Description:</td>
                    <td align="right"><%=product.getDescription()%></td>
                </tr>
                <tr>
                    <td align="right">Product Price:</td>
                    <td align="right"><%=product.getPrice()%></td>
                </tr>
                <tr>
                    <td>
                        <br/>
                            <form action="deleteproduct" method="post">
                                <input type="hidden" name="productCode" value="<%= product.getCode()%>">
                                <input type="submit" value="Yes">
                            </form>
                        
                    </td>
                    <td>
                        <br><a href="viewproduct"><button>No</button></a></br>
                    </td>
                </tr>
            </form>
        </table>
    </body>
</html>
