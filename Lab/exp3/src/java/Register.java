import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Register") // Ensure this matches the form action
public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Try-with-resources ensures PrintWriter is closed properly
        try (PrintWriter out = response.getWriter()) {
           
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String age = request.getParameter("age");
            String course = request.getParameter("course");



            out.println("<html><body>");
            out.println("<p>Welcome, " + name + "!</p>");
            out.println("<p>"+email+"</p>");
            out.println("<p>"+age+"</p>");
            out.println("<p>"+course+"</p>");
            out.println("<a href='register.html'>Try Again</a>");


        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
