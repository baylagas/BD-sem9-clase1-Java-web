<%-- 
    Document   : teacherMain
    Created on : Jul 20, 2020, 6:59:00 AM
    Author     : balbi
--%>

<%@page import="java.util.Iterator"%>
<%@page import="eduwebapp.objects.SectionViewObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Section Main</title>
    </head>
    <%
        int rows = (int)request.getSession().getAttribute("rows");
        ArrayList<SectionViewObj> array = 
                (ArrayList<SectionViewObj>)request.getSession()
                        .getAttribute("sectionarray");
    %>
    <body>
        <h1>Section Main</h1>
        <br>
        
        <a href="SectionServlet?formid=6">New Section</a>
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
        Count:<%= array.size() %><br>
        <table style="width:40%" border="1">
          <tr>
            <th>Profesor</th>
            <th>Aula</th>
            <th>Alumno</th>
            <th>Nombre Seccion</th>
          </tr>
          <%
              Iterator<SectionViewObj> iteArray= null;
              if(array!=null)
              {
                  iteArray = array.iterator();
                  SectionViewObj temp = null;
                  while(iteArray.hasNext())
                  {
                      temp = iteArray.next();
          %>
                    <tr>
                      <td><%= temp.getProfe() %></td>
                      <td><%= temp.getCod() %></td>
                      <td><%= temp.getAlumni() %></td>
                      <td><%= temp.getSeccionName() %></td>
                      <td><a href="SectionServlet?formid=4&id=<%= temp.getId()%>">update</a></td>
                      <td><a href="SectionServlet?formid=2&id=<%= temp.getId()%>">delete</a></td>
                    </tr>
          <%
                   }
              }
          %>
          
        </table>
    </body>
</html>
