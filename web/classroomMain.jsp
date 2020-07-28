<%-- 
    Document   : teacherMain
    Created on : Jul 20, 2020, 6:59:00 AM
    Author     : balbi
--%>

<%@page import="java.util.Iterator"%>
<%@page import="eduwebapp.objects.ClassroomObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Classroom Main</title>
    </head>
    <%
        int rows = (int)request.getSession().getAttribute("rows");
        ArrayList<ClassroomObj> array = 
                (ArrayList<ClassroomObj>)request.getSession()
                        .getAttribute("classroomarray");
    %>
    <body>
        <h1>Classroom Main</h1>
        <br>
        
        <a href="newClassroom.html">New Classroom</a>
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
            <th>Code</th>
            <th>Capacity</th>
          </tr>
          <%
              Iterator<ClassroomObj> iteArray= null;
              if(array!=null)
              {
                  iteArray = array.iterator();
                  ClassroomObj temp = null;
                  while(iteArray.hasNext())
                  {
                      temp = iteArray.next();
          %>
                    <tr>
                      <td><%= temp.getCodigo() %></td>
                      <td><%= temp.getCapacidad() %></td>
                      <td><a href="ClassroomServlet?formid=4&id=<%= temp.getId()%>">update</a></td>
                      <td><a href="ClassroomServlet?formid=2&id=<%= temp.getId()%>">delete</a></td>
                    </tr>
          <%
                   }
              }
          %>
          
        </table>
    </body>
</html>
