<%-- 
    Document   : teacherMain
    Created on : Jul 20, 2020, 6:59:00 AM
    Author     : balbi
--%>

<%@page import="java.util.Iterator"%>
<%@page import="eduwebapp.objects.TeacherObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teacher Main</title>
    </head>
    <%
        int rows = (int)request.getSession().getAttribute("rows");
        ArrayList<TeacherObj> array = 
                (ArrayList<TeacherObj>)request.getSession()
                        .getAttribute("teacherarray");
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
          <%
              Iterator<TeacherObj> iteArray= null;
              if(array!=null)
              {
                  iteArray = array.iterator();
                  TeacherObj temp = null;
                  while(iteArray.hasNext())
                  {
                      temp = iteArray.next();
          %>
                    <tr>
                      <td><%= temp.getName() %></td>
                      <td><%= temp.getProfession() %></td>
                      <td><a href="TeacherServlet?formid=4&id=<%= temp.getId()%>">update</a></td>
                      <td><a href="TeacherServlet?formid=2&id=<%= temp.getId()%>">delete</a></td>
                    </tr>
          <%
                   }
              }
          %>
          
        </table>
    </body>
</html>
