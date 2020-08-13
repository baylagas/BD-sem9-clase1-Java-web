<%-- 
    Document   : dashboard
    Created on : Aug 12, 2020, 11:32:28 PM
    Author     : balbi
--%>

<%@page import="eduwebapp.objects.UserObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Education site</title>
    </head>
    <%
        UserObj currentUser 
                = (UserObj) request.getSession().getAttribute("current_user");
        
        if(currentUser!=null)
        {
    %>
    <body>
        <h1>Education Site</h1>
        <br>
        user:<%= currentUser.getUsername() %>
        <br>
        type:<%= currentUser.getIdtype()==1?"admin":"normal" %>
        <br>
        <a href="UserServlet?formid=2">logout</a>
        <br><br>
        <a href="TeacherServlet?formid=3">go to teacher</a>
        <br>
        <a href="StudentServlet?formid=3">go to student</a>
        <br>
        <a href="ClassroomServlet?formid=3">go to classroom</a>
        <br>
        <a href="SectionServlet?formid=3">go to section</a>
    </body>
    <%
        }
        else{
    %>
        <body>
            <h1>Education Site</h1>
            <br>

            <a href="index.jsp">go to login</a>
        </body>
    <%
        }
    %>
</html>
