<%-- 
    Document   : updateTeacher
    Created on : Jul 21, 2020, 9:14:49 AM
    Author     : balbi
--%>

<%@page import="eduwebapp.objects.SectionObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Section</title>
    </head>
    <%
        SectionObj sectionObj = 
                (SectionObj)request.getSession().getAttribute("sectionobject");
    %>
    <body>
        <h1>Update Section</h1>
        <br>
        
        <form action="SectionServlet" method="get">
            codigo: <br>
            <input type="text" id="code" name="code" value="<%= classroomObj.getCodigo() %>"/>
            <br><br>
            capacidad: <br>
            <input type="text" id="capacity" name="capacity" value="<%= classroomObj.getCapacidad() %>" />
            <br><br>
            <input type="submit" value="Send" />
            <input type="hidden" name="formid" value="5" />
            <input type="hidden" name="id" value="<%= classroomObj.getId() %>"/>
        </form>
    </body>
</html>
