<%-- 
    Document   : teacherMain
    Created on : Jul 20, 2020, 6:59:00 AM
    Author     : balbi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teacher Main</title>
    </head>
    <%
        int rows = (int)request.getSession().getAttribute("rows");
    %>
    <body>
        <h1>Teacher Main</h1>
        <br>
        
        <a href="newTeacher.html">New Teacher</a>
        <br><br>
        <%
        if(rows>0)
        {
        %>
            <p style="color:red;"><%= rows %> affected</p>
            <br><br>
        <%
        }
        %>
        <table style="width:40%" border="1">
          <tr>
            <th>Name</th>
            <th>Profession</th>
          </tr>
          <tr>
            <td>Jill Smith</td>
            <td>Programmer</td>
            <td>update</td>
            <td>delete</td>
          </tr>
          <tr>
            <td>Eve Jackson</td>
            <td>Economist</td>
            <td>update</td>
            <td>delete</td>            
          </tr>
        </table>
    </body>
</html>
