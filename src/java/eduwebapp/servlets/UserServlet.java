package eduwebapp.servlets;

import eduwebapp.logic.UserLogic;
import eduwebapp.objects.UserObj;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String strConnString = "jdbc:mysql://localhost/cardexdb?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strFormId = request.getParameter("formid");
        String email, password;
        UserLogic logic;
        String message = "";
        
        switch (strFormId) 
        {
            case "1":
                //traer con un select el registro filtrado por email
                //al inicio
                email = request.getParameter("email");
                password = request.getParameter("password");
                
                //enmedio
                logic = new UserLogic(strConnString);
                UserObj userObject = logic.getUserByEmail(email);
                boolean bValidUser=false;
                
                
                if(userObject!=null)
                {
                    //viene userObject
                    if(userObject.getPassword().equals(password))
                    {
                        //es usuario valido!! yay!!
                        bValidUser = true;
                    }
                    else
                    {
                        //el password es incorrecto
                        message = "Su informacion es incorrecta, intente de nuevo";
                    }
                }
                else
                {
                    //el usuario no existe
                    message = "Su informacion es incorrecta, intente de nuevo";
                }
                
                //al final
                if(bValidUser) 
                {
                    if (userObject!=null)
                    {
                        if (userObject.getIdtype()==1)
                        {
                            request.getSession().setAttribute("current_user", userObject);
                            request.getSession().removeAttribute("message");
                            response.sendRedirect("dashboard.jsp");
                        }
                        else
                        {
                            request.getSession().setAttribute("current_user", userObject);
                            request.getSession().removeAttribute("message");
                            response.sendRedirect("dashboard.jsp");
                        }
                    }
                }
                else
                {
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("index.jsp");                
                }
                break;
            case "2":
                
                request.getSession().removeAttribute("current_user");
                request.getSession().removeAttribute("message");
                response.sendRedirect("index.jsp");
                
                break;
            case "3":
                
                break;
            default:
                break;
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
