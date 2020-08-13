<%-- 
    Document   : updateTeacher
    Created on : Jul 21, 2020, 9:14:49 AM
    Author     : balbi
--%>

<%@page import="java.util.Iterator"%>
<%@page import="eduwebapp.objects.ClassroomObj"%>
<%@page import="eduwebapp.objects.StudentObj"%>
<%@page import="eduwebapp.objects.TeacherObj"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eduwebapp.objects.SectionObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Section</title>
    </head>
    <%
        // 13	11	4	4	light year
        SectionObj sectionObj = 
                (SectionObj)request.getSession().getAttribute("sectionobject");
        /*
            1	balbino	programador
            2	sven	ingeniero
            11	nicole	economista
            12	terry	medico
            13	alfredo	policia        
        */
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
        <h1>Update Section</h1>
        <br>
        
        <form action="SectionServlet" method="get">
            
            profesor: <br>
            <select>
                    <%
                    //java
                    
                    if(teacherArray!=null)
                    {
                        Iterator<TeacherObj> iteTeacher 
                                = teacherArray.iterator();
                        TeacherObj current;

                        while(iteTeacher.hasNext())
                        {
                            current = iteTeacher.next();
                    %>  
                        <!-- this is html  <%= sectionObj.getIdProfesor() %> -->
                            <option value="<%= current.getId() %>" 
                                    <%
                                        if(sectionObj.getIdProfesor()==current.getId())
                                        {
                                    %>
                                    selected
                                    <%
                                        }
                                    %>                                    
                                    >
                                <%= current.getName() %>
                            </option>
                    <%
                        }
                    }
                    //java
                    %>
            </select>
            <br><br>
            
            aula: <br>
            <select>
                <%
                    if(classroomArray!=null)
                    {
                        Iterator<ClassroomObj> iteClass 
                                = classroomArray.iterator();
                        ClassroomObj current;
                        
                        while(iteClass.hasNext())
                        {
                            current = iteClass.next();
                %>
                            <option value="<%= current.getId() %>" 
                                    <%
                                        if(sectionObj.getIdAula()==current.getId())
                                        {
                                    %>
                                    selected
                                    <%
                                        }
                                    %>
                                    >
                                <%= current.getCodigo() %>
                            </option>
                <%
                        }
                    }
                %>
                
            </select>
            <br><br>
            
            alumno: <br>
            <select>
                <%
                    if(studentArray!=null)
                    {
                        Iterator<StudentObj> iteStud 
                                = studentArray.iterator();
                        StudentObj current;
                        
                        while(iteStud.hasNext())
                        {
                            current = iteStud.next();
                %>
                            <option value="<%= current.getId() %>" 
                                    <%
                                        if(sectionObj.getIdAlumno()==current.getId())
                                        {
                                    %>
                                    selected
                                    <%
                                        }
                                    %>
                                    >
                                <%= current.getName() %>
                            </option>
                <%
                        }
                    }
                %>
                
            </select>
            <br><br>
            
            Nombre:<br>
            <input type="text" id="name" name="name" value="<%= sectionObj.getName() %>" />
            <br><br>
            
            <input type="submit" value="Send" />
            <input type="hidden" name="formid" value="5" />
            <input type="hidden" name="id" value="<%= sectionObj.getId() %>"/>
        </form>
    </body>
</html>
