import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AlertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String alertMessage = request.getParameter("message");

        // Store the alert in the session
        HttpSession session = request.getSession();
        session.setAttribute("alertMessage", alertMessage);

        // Redirect to display the alert
        response.sendRedirect("displayalert");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display form for admin to enter the alert message
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Send Alert</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #2c2c2c; color: #fff; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
        out.println(".container { text-align: center; background-color: #1a1a1a; padding: 30px; border-radius: 10px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.5); width: 90%; max-width: 400px; position: relative; }");
        out.println(".inner-border { padding: 20px; border: 2px solid #ffa500; border-radius: 10px; }");
        out.println("h1 { color: #ffa500; margin-bottom: 20px; text-shadow: 2px 2px 5px #000; }");
        out.println("form { margin-top: 20px; }");
        out.println("textarea, button { margin: 10px 0; padding: 10px; font-size: 16px; border-radius: 5px; width: 90%; max-width: 300px; display: block; }");
        out.println("button { background-color: #ffa500; color: #000; cursor: pointer; transition: all 0.3s ease; border: none; }");
        out.println("button:hover { background-color: #fff; color: #ffa500; box-shadow: 0 0 10px #ffa500; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<div class='inner-border'>");
        out.println("<h1>Send Disaster Alert</h1>");
        out.println("<form action='alert' method='post'>");
        out.println("Message: <textarea name='message' required></textarea>");
        out.println("<button type='submit'>Send Alert</button>");
        out.println("</form>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
