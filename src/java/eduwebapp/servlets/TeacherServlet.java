package eduwebapp.servlets;

import eduwebapp.logic.TeacherLogic;
import eduwebapp.objects.TeacherObj;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TeacherServlet", urlPatterns = {"/TeacherServlet"})
public class TeacherServlet extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, 
                                    HttpServletResponse response)
            throws ServletException, IOException 
    {
        String strConnString = "jdbc:mysql://localhost/cardexdb?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strFormId = request.getParameter("formid");
        int rows;
        request.getSession().setAttribute("rows", 0);
        TeacherLogic logic;
        
        switch (strFormId) 
        {
            case "1":                
                System.out.println("code for insert new...");
                //al inicio
                String strName = request.getParameter("name");
                String strProfession = request.getParameter("profession");
                
                //enmedio
                logic = new TeacherLogic(strConnString);
                rows = logic.insertNewTeacher(strName, strProfession);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("TeacherServlet?formid=3");
                
                break;
            case "2":
                System.out.println("code for delete...");
                //al inicio
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //enmedio
                logic = new TeacherLogic(strConnString);
                rows = logic.deleteTeacher(iId);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("TeacherServlet?formid=3");
                
                break;
            case "3":
                System.out.println("code for select...");
                
                //enmedio
                logic = new TeacherLogic(strConnString);
                ArrayList<TeacherObj> teacherArray = logic.getAllTeachers();
                
                //al final
                request.getSession().setAttribute("teacherarray", teacherArray);
                response.sendRedirect("teacherMain.jsp");
                
                break;
            case "4":
                System.out.println("code for update part 1...");
                break;
            case "5":
                System.out.println("code for update part 2...");
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
