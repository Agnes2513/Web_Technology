import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DisplayAlertServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the alert message from session
        HttpSession session = request.getSession();
        String alertMessage = (String) session.getAttribute("alertMessage");

        // Get the user's opt-in choice from session
        String optInChoice = (String) session.getAttribute("optInChoice");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Current Alert</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #2c2c2c; color: #fff; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
        out.println(".container { text-align: center; background-color: #1a1a1a; padding: 30px; border-radius: 10px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.5); width: 90%; max-width: 400px; position: relative; }");
        out.println(".inner-border { padding: 20px; border: 2px solid #ffa500; border-radius: 10px; }");
        out.println("h1 { color: #ffa500; margin-bottom: 20px; text-shadow: 2px 2px 5px #000; }");
        out.println("p { font-size: 18px; color: #fff; }");
        out.println("button { background-color: #ffa500; color: #000; cursor: pointer; transition: all 0.3s ease; border: none; padding: 10px 20px; margin: 10px; border-radius: 5px; }");
        out.println("button:hover { background-color: #fff; color: #ffa500; box-shadow: 0 0 10px #ffa500; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<div class='inner-border'>");

        if ("yes".equals(optInChoice)) {
            out.println("<h1>Disaster Alert!</h1>");
            if (alertMessage != null) {
                out.println("<p>" + alertMessage + "</p>");
            } else {
                out.println("<p>No current alert available.</p>");
            }
        } else {
            out.println("<h1>You have opted out of disaster alerts.</h1>");
        }

        out.println("<br><a href='index1.html'><button>Back to Home</button></a>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
