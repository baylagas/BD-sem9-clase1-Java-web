<%-- 
    Document   : updateTeacher
    Created on : Jul 21, 2020, 9:14:49 AM
    Author     : balbi
--%>

<%@page import="eduwebapp.objects.TeacherObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Teacher</title>
    </head>
    <%
        TeacherObj teacherObj = 
                (TeacherObj)request.getSession().getAttribute("teacherobject");
    %>
    <body>
        <h1>Update Teacher</h1>
        <br>
        
        <form action="TeacherServlet" method="get">
            name: <br>
            <input type="text" id="name" name="name" value="<%= teacherObj.getName() %>"/>
            <br><br>
            profession: <br>
            <input type="text" id="profession" name="profession" value="<%= teacherObj.getProfession() %>" />
            <br><br>
            <input type="submit" value="Send" />
            <input type="hidden" name="formid" value="5" />
            <input type="hidden" name="id" value="<%= teacherObj.getId() %>"/>
        </form>
    </body>
</html>
