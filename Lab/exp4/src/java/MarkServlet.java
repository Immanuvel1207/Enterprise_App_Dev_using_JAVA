import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/MarkServlet")
public class MarkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        // Retrieve marks from form submission
        int subject1 = Integer.parseInt(request.getParameter("subject1"));
        int subject2 = Integer.parseInt(request.getParameter("subject2"));
        int subject3 = Integer.parseInt(request.getParameter("subject3"));

        // Calculate total and average marks
        int total = subject1 + subject2 + subject3;
        double average = total / 3.0;

        // Set attributes for forwarding to the result page
        request.setAttribute("subject1", subject1);
        request.setAttribute("subject2", subject2);
        request.setAttribute("subject3", subject3);
        request.setAttribute("total", total);
        request.setAttribute("average", average);

        // Forward the request to the result JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }
}
