import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class OptInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String optInChoice = request.getParameter("optIn");

        // Store user choice in session
        HttpSession session = request.getSession();
        session.setAttribute("optInChoice", optInChoice);

        // Store user choice in a cookie for future reference
        Cookie cookie = new Cookie("optInChoice", optInChoice);
        response.addCookie(cookie);

        // Redirect to the main page
        response.sendRedirect("index1.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display opt-in form
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head>");
        out.println("<style>");
        out.println("body {");
        out.println("    font-family: Arial, sans-serif;");
        out.println("    background-color: #2c2c2c;");
        out.println("    color: #fff;");
        out.println("    margin: 0;");
        out.println("    padding: 0;");
        out.println("    display: flex;");
        out.println("    justify-content: center;");
        out.println("    align-items: center;");
        out.println("    height: 100vh;");
        out.println("}");
        out.println(".container {");
        out.println("    text-align: center;");
        out.println("    background-color: #1a1a1a;");
        out.println("    padding: 30px;");
        out.println("    border-radius: 10px;");
        out.println("    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.5);");
        out.println("    width: 90%;");
        out.println("    max-width: 400px;");
        out.println("    position: relative;");
        out.println("}");
        out.println(".inner-border {");
        out.println("    padding: 20px;");
        out.println("    border: 2px solid #ffa500;");
        out.println("    border-radius: 10px;");
        out.println("}");
        out.println("h1 {");
        out.println("    color: #ffa500;");
        out.println("    margin-bottom: 20px;");
        out.println("    text-shadow: 2px 2px 5px #000;");
        out.println("}");
        out.println("form {");
        out.println("    margin-top: 20px;");
        out.println("    text-align: left;");
        out.println("}");
        out.println("input[type='radio'] {");
        out.println("    margin-right: 10px;");
        out.println("    vertical-align: middle;");
        out.println("}");
        out.println("label {");
        out.println("    margin-right: 20px;");
        out.println("    font-size: 18px;");
        out.println("    color: #fff;");
        out.println("}");
        out.println("button {");
        out.println("    background-color: #ffa500;");
        out.println("    color: #000;");
        out.println("    cursor: pointer;");
        out.println("    transition: all 0.3s ease;");
        out.println("    border: none;");
        out.println("    padding: 10px 20px;");
        out.println("    margin-top: 20px;");
        out.println("    border-radius: 5px;");
        out.println("}");
        out.println("button:hover {");
        out.println("    background-color: #fff;");
        out.println("    color: #ffa500;");
        out.println("    box-shadow: 0 0 10px #ffa500;");
        out.println("}");
        out.println("</style>");
        out.println("</head><body>");
        out.println("<div class='container'>");
        out.println("<div class='inner-border'>");
        out.println("<h1>Opt-In to Disaster Alerts</h1>");
        out.println("<form action='optin' method='post'>");
        out.println("<p>Do you want to receive disaster alerts?</p>");
        out.println("<label><input type='radio' name='optIn' value='yes' required> Yes</label><br>");
        out.println("<label><input type='radio' name='optIn' value='no'> No</label><br>");
        out.println("<button type='submit'>Submit</button>");
        out.println("</form>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body></html>");
    }
}
