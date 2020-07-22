package eduwebapp.servlets;

import eduwebapp.logic.StudentLogic;
import eduwebapp.objects.StudentObj;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String strConnString = "jdbc:mysql://localhost/cardexdb?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strFormId = request.getParameter("formid");
        StudentLogic logic;
        String strName,strAge,strId;
        int iAge, rows, iId;
        
        switch (strFormId) 
        {
            case "1":
                System.out.println("code for insert new...");
                
                //al inicio
                strName = request.getParameter("name");
                strAge = request.getParameter("age");
                
                //enmedio
                logic = new StudentLogic(strConnString);
                rows = logic.insertNewStudent(strName, strAge);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("StudentServlet?formid=3");                
                
                break;
            case "2":
                System.out.println("code for delete...");
                
                //al inicio
                strId = request.getParameter("id");
                iId = Integer.parseInt(strId);
                
                //enmedio
                logic = new StudentLogic(strConnString);
                rows = logic.deleteTeacher(iId);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("StudentServlet?formid=3");
                
                break;
            case "3":
                System.out.println("code for select...");
                //enmedio
                logic = new StudentLogic(strConnString);
                ArrayList<StudentObj> studentArray = logic.getAllStudents();
                
                //al final
                request.getSession().setAttribute("studentarray", studentArray);
                response.sendRedirect("studentMain.jsp");
                
                break;
            case "4":
                System.out.println("code for update part 1...");
                
                //al inicio
                strId = request.getParameter("id");
                iId = Integer.parseInt(strId);
                
                //enmedio
                logic = new StudentLogic(strConnString);
                StudentObj studentObject = logic.getStudentById(iId);
                
                //al final
                request.getSession().setAttribute("studentobject", studentObject);
                response.sendRedirect("updateStudent.jsp");
                
                break;
            case "5":
                System.out.println("code for update part 2...");
                
                strId = request.getParameter("id");
                iId = Integer.parseInt(strId);
                strName = request.getParameter("name");
                strAge = request.getParameter("age");
                iAge = Integer.parseInt(strAge);
                
                logic = new StudentLogic(strConnString);
                rows = logic.updateStudent(iId, strName, iAge);
                
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("StudentServlet?formid=3");                
                
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
