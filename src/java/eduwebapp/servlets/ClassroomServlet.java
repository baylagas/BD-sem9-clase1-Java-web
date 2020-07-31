package eduwebapp.servlets;

import eduwebapp.logic.ClassroomLogic;
import eduwebapp.objects.ClassroomObj;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClassroomServlet", urlPatterns = {"/ClassroomServlet"})
public class ClassroomServlet extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, 
                                    HttpServletResponse response)
            throws ServletException, IOException 
    {
        String strConnString = "jdbc:mysql://localhost/cardexdb?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strFormId = request.getParameter("formid");
        ClassroomLogic logic;
        
        String strCodigo, strCapacidad, strId;
        int rows, iCapacidad, iId;
        request.getSession().setAttribute("rows", 0);
        
        switch(strFormId)
        {
            case "1":
                System.out.println("code for insert new...");
                
                //al inicio
                strCodigo = request.getParameter("code");
                strCapacidad = request.getParameter("capacity");
                iCapacidad = Integer.parseInt(strCapacidad);
                
                //enmedio
                logic = new ClassroomLogic(strConnString);
                rows = logic.insertNewClassroom(strCodigo, iCapacidad);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("ClassroomServlet?formid=3");
                
                break;
            case "2":
                System.out.println("code for delete...");
                
                //al inicio
                strId = request.getParameter("id");
                iId = Integer.parseInt(strId);
                
                //enmedio
                logic = new ClassroomLogic(strConnString);
                rows = logic.deleteClassroom(iId);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("ClassroomServlet?formid=3");
                
                break;
            case "3":
                System.out.println("get all classroom");
                //enmedio
                logic = new ClassroomLogic(strConnString);
                ArrayList<ClassroomObj> classroomArray = logic.getAllClassrooms();
                
                //al final
                request.getSession().setAttribute("classroomarray", classroomArray);
                response.sendRedirect("classroomMain.jsp");
                
                break;
            case "4":
                System.out.println("code for update part 1...");
                
                //al inicio
                strId = request.getParameter("id");
                iId = Integer.parseInt(strId);
                
                //enmedio
                logic = new ClassroomLogic(strConnString);
                ClassroomObj classroomObject = logic.getClassroomById(iId);
                
                //al final
                request.getSession().setAttribute("classroomobject", classroomObject);
                response.sendRedirect("updateClassroom.jsp");                
                
                break;
            case "5":
                System.out.println("code for update part 2...");
                
                strId = request.getParameter("id");
                iId = Integer.parseInt(strId);
                strCodigo = request.getParameter("code");
                strCapacidad = request.getParameter("capacity");
                iCapacidad = Integer.parseInt(strCapacidad);
                
                logic = new ClassroomLogic(strConnString);
                rows = logic.updateClassroom(iId, strCodigo, iCapacidad);
                
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("ClassroomServlet?formid=3");
                
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
