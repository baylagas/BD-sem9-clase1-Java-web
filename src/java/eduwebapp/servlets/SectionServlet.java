package eduwebapp.servlets;

import eduwebapp.logic.ClassroomLogic;
import eduwebapp.logic.SectionLogic;
import eduwebapp.logic.StudentLogic;
import eduwebapp.logic.TeacherLogic;
import eduwebapp.objects.ClassroomObj;
import eduwebapp.objects.SectionObj;
import eduwebapp.objects.SectionViewObj;
import eduwebapp.objects.StudentObj;
import eduwebapp.objects.TeacherObj;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SectionServlet", urlPatterns = {"/SectionServlet"})
public class SectionServlet extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
            
    {
        String strConnString = "jdbc:mysql://localhost/cardexdb?"
                + "user=root&password=12345&"
                + "autoReconnect=true&useSSL=false";
        String strFormId = request.getParameter("formid");
        SectionLogic logic;
        request.getSession().setAttribute("rows", 0);
        /*profesor=12&aula=4&alumno=4&name=light+year&formid=1*/
        String strProfesor, strAula, strAlumno, strName, strId;
        int iIdProfesor, iIdAula, iIdAlumno, rows, iId;
        TeacherLogic teacherLogic;
        StudentLogic studentLogic;
        ClassroomLogic classroomLogic;
        ArrayList<TeacherObj> teacherArray;
        ArrayList<StudentObj> studentArray;
        ArrayList<ClassroomObj> classroomArray;
        
        switch(strFormId)
        {
            case "1":
                System.out.println("code for insert new...");
                
                //al inicio
                strProfesor = request.getParameter("profesor");
                iIdProfesor = Integer.parseInt(strProfesor);
                strAula = request.getParameter("aula");
                iIdAula = Integer.parseInt(strAula);
                strAlumno = request.getParameter("alumno");
                iIdAlumno = Integer.parseInt(strAlumno);
                strName = request.getParameter("name");
                
                //enmedio
                logic = new SectionLogic(strConnString);
                rows = logic.insertNewSection(iIdProfesor, iIdAula, iIdAlumno, strName);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("SectionServlet?formid=3");
                
                break;
            case "2":

                System.out.println("code for delete...");
                
                //al inicio
                strId = request.getParameter("id");
                iId = Integer.parseInt(strId);
                
                //enmedio
                logic = new SectionLogic(strConnString);
                rows = logic.deleteSection(iId);
                
                //al final
                request.getSession().setAttribute("rows", rows);
                response.sendRedirect("SectionServlet?formid=3");
                
                break;
            case "3":
                System.out.println("get all section");
                //enmedio
                logic = new SectionLogic(strConnString);
                ArrayList<SectionViewObj> sectionArray = logic.getAllSectionView();
                
                //al final
                request.getSession().setAttribute("sectionarray", sectionArray);
                response.sendRedirect("sectionMain.jsp");
                
                break;
            case "4":
                System.out.println("code for update part 1...");
                
                //al inicio                
                strId = request.getParameter("id");
                iId = Integer.parseInt(strId);
                
                //enmedio
                logic = new SectionLogic(strConnString);
                SectionObj sectionObject = logic.getSectionById(iId);
                /******************************************************/
                teacherLogic = new TeacherLogic(strConnString);
                studentLogic = new StudentLogic(strConnString);
                classroomLogic = new ClassroomLogic(strConnString);
                teacherArray = teacherLogic.getAllTeachers();
                studentArray = studentLogic.getAllStudents();
                classroomArray = classroomLogic.getAllClassrooms();
                
                
                //al final
                request.getSession().setAttribute("sectionobject", sectionObject);
                request.getSession().setAttribute("teacherarray", teacherArray);
                request.getSession().setAttribute("studentarray", studentArray);
                request.getSession().setAttribute("classroomarray", classroomArray);                
                response.sendRedirect("updateSection.jsp");                
                
                break;
            case "5":
                break;
            case "6":
                System.out.println("get all parts for new section");
                
                teacherLogic = new TeacherLogic(strConnString);
                studentLogic = new StudentLogic(strConnString);
                classroomLogic = new ClassroomLogic(strConnString);
                
                teacherArray = teacherLogic.getAllTeachers();
                studentArray = studentLogic.getAllStudents();
                classroomArray = classroomLogic.getAllClassrooms();
                
                request.getSession().setAttribute("teacherarray", teacherArray);
                request.getSession().setAttribute("studentarray", studentArray);
                request.getSession().setAttribute("classroomarray", classroomArray);
                response.sendRedirect("newSection.jsp");                
                
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
