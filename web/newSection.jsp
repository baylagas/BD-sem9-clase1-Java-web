<%-- 
    Document   : newSection
    Created on : Jul 31, 2020, 7:31:47 AM
    Author     : balbi
--%>

<%@page import="java.util.Iterator"%>
<%@page import="eduwebapp.objects.ClassroomObj"%>
<%@page import="eduwebapp.objects.StudentObj"%>
<%@page import="eduwebapp.objects.TeacherObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Section</title>

    </head>
    <%
        ArrayList<TeacherObj> teacherArray = 
                (ArrayList<TeacherObj>) request.getSession()
                        .getAttribute("teacherarray");
        ArrayList<StudentObj> studentArray = 
                (ArrayList<StudentObj>) request.getSession()
                        .getAttribute("studentarray");
        ArrayList<ClassroomObj> classroomArray = 
                (ArrayList<ClassroomObj>) request.getSession()
                        .getAttribute("classroomarray");
    %>
    <body>
        <h1>New Section</h1>
        <br>
        
        <form action="SectionServlet" method="get">
            <%
                Iterator<TeacherObj> iteTeacher = teacherArray.iterator();
            %>
            <label for="profesor">Profesor:</label>
            <br>
            <select id="profesor" name="profesor" required>
              <option value="">--</option>
              <%
                  if(iteTeacher!=null)
                  {
                      TeacherObj temp;
                      while(iteTeacher.hasNext())
                      {
                          temp = iteTeacher.next();
              %>
                    <option value="<%= temp.getId() %>"><%= temp.getName() %></option>
              <%
                      }
                  }
              %>
            </select>            
            <br><br>
            
            <%
                Iterator<ClassroomObj> iteClassroom = classroomArray.iterator();
            %>
            <label for="aula">Aula:</label>
            <br>
            <select id="aula" name="aula" required>
              <option value="">--</option>
              <%
                  if(iteClassroom!=null)
                  {
                      ClassroomObj temp;
                      
                      while(iteClassroom.hasNext())
                      {
                          temp = iteClassroom.next();
              %>
                    <option value="<%= temp.getId() %>"><%= temp.getCodigo() %></option>
              <%
                      }
                  }
              %>
            </select>            
            <br><br>
            
            <%
                Iterator<StudentObj> iteStudent = studentArray.iterator();
            %>
            <label for="alumno">Alumno:</label>
            <br>
            <select id="alumno" name="alumno" required>
              <option value="">--</option>
              <%
                  if(iteStudent!=null)
                  {
                      StudentObj temp;
                      
                      while(iteStudent.hasNext())
                      {
                          temp = iteStudent.next();
              %>
                    <option value="<%= temp.getId() %>"><%= temp.getName() %></option>
              <%
                      }
                  }
              %>
            </select>
            <br><br>
            
            Nombre: <br>
            <input type="text" id="name" name="name" />
            <br><br>
            
            <input type="submit" value="Send" />
            <input type="hidden" name="formid" value="1" />
        </form>

    </body>
</html>
