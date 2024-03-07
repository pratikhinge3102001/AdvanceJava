<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   import="java.util.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
</head>
<body>

    <%-- JSP equivalent of servlet code --%>
    <%
        Connection con = (Connection) application.getAttribute("jdbccon");
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            int id = Integer.parseInt(request.getParameter("catid"));
            ps = con.prepareStatement("select * from product where cat_id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
    %>
            <form action='addtocart'>
                Select Product:
                <select name='product'>
                    <%-- Iterate over the result set and generate options --%>
                    <% while (rs.next()) { %>
                        <option value='<%= rs.getInt(1) %>'>
                            <%= rs.getString(2) %>
                        </option>
                    <% } %>
                </select><br/>
                <input type='submit' value='Add To Cart'/>
            </form>
            <a href='home'>Go Back to Categories</a>
    <%
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    %>

</body>
</html>