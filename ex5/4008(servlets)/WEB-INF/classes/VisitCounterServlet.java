import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/visitCounter")
public class VisitCounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Adding CSS to center content, add a border, and style with grey and orange
        String css = "<style>" +
                     "body { font-family: Arial, sans-serif; background-color: #f0f0f0; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }" +
                     ".container { background-color: #ffffff; padding: 20px; border: 2px solid #ff9800; border-radius: 10px; width: 50%; text-align: center; }" +
                     "h1 { color: #ff9800; }" +
                     "h2 { color: #333; }" +
                     "</style>";

        HttpSession session = request.getSession(true);

        // Get unique user identifier
        String userId = request.getParameter("userId");
        if (userId == null || userId.isEmpty()) {
            userId = "defaultUser";     
        }

        Integer visitCount = (Integer) session.getAttribute(userId);

        if (visitCount == null) {
            // If the user is visiting for the first time, initialize count to 1
            visitCount = 1;
        } else {
            // Increment the visit count if the user has visited before
            visitCount += 1;
        }
        session.setAttribute(userId, visitCount);

        out.println("<html>" + css + "<body>");
        out.println("<div class='container'>");
        out.println("<h1>Hello, " + userId + "!</h1>");
        out.println("<h2>You have visited this page " + visitCount + " times.</h2>");
        out.println("</div>");
        out.println("</body></html>");

        Cookie visitCookie = new Cookie("visitCount", visitCount.toString());
        visitCookie.setMaxAge(60 * 60 * 24);
        response.addCookie(visitCookie);

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
