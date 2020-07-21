<%-- 
    Document   : teacherMain
    Created on : Jul 20, 2020, 6:59:00 AM
    Author     : balbi
--%>

<%@page import="java.util.Iterator"%>
<%@page import="eduwebapp.objects.StudentObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Main</title>
    </head>
    <%
        int rows = (int)request.getSession().getAttribute("rows");
        ArrayList<StudentObj> array = 
                (ArrayList<StudentObj>)request.getSession()
                        .getAttribute("studentarray");
    %>
    <body>
        <h1>Student Main</h1>
        <br>
        
        <a href="newStudent.html">New Student</a>
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
            <th>Age</th>
          </tr>
          <%
              Iterator<StudentObj> iteArray= null;
              if(array!=null)
              {
                  iteArray = array.iterator();
                  StudentObj temp = null;
                  while(iteArray.hasNext())
                  {
                      temp = iteArray.next();
          %>
                    <tr>
                      <td><%= temp.getName() %></td>
                      <td><%= temp.getAge() %></td>
                      <td><a href="StudentServlet?formid=4&id=<%= temp.getId()%>">update</a></td>
                      <td><a href="StudentServlet?formid=2&id=<%= temp.getId()%>">delete</a></td>
                    </tr>
          <%
                   }
              }
          %>
          
        </table>
    </body>
</html>
