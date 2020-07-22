<%-- 
    Document   : updateTeacher
    Created on : Jul 21, 2020, 9:14:49 AM
    Author     : balbi
--%>

<%@page import="eduwebapp.objects.StudentObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Student</title>
    </head>
    <%
        StudentObj studentObj = 
                (StudentObj)request.getSession().getAttribute("studentobject");
    %>
    <body>
        <h1>Update Student</h1>
        <br>
        
        <form action="StudentServlet" method="get">
            name: <br>
            <input type="text" id="name" name="name" value="<%= studentObj.getName() %>"/>
            <br><br>
            age: <br>
            <input type="text" id="age" name="age" value="<%= studentObj.getAge() %>" />
            <br><br>
            <input type="submit" value="Send" />
            <input type="hidden" name="formid" value="5" />
            <input type="hidden" name="id" value="<%= studentObj.getId() %>"/>
        </form>
    </body>
</html>
