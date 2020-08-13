<%-- 
    Document   : index
    Created on : Aug 12, 2020, 8:13:51 PM
    Author     : balbi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Login</title>
    </head>
    
        <%
            String message 
                    = (String)request.getSession().getAttribute("message");
        %>
    
    <body>
        <h1>Login</h1>
        <br>
        
        <div>
            <%
                if(message!=null && !message.equals(""))
                {
            %>
            <p style="color:red;"><%= message %></p>
            <%
                }
            %>
        </div>
        <form action="UserServlet" method="post">
            email:<br>
            <input type="email" name="email" required/>
            <br><br>
            password:<br>
            <input type="password" name="password" required/>
            <br><br>
            <input type="submit" value="Login"/>
            <input type="hidden" name="formid" value="1"/>
        </form>
    </body>
</html>
