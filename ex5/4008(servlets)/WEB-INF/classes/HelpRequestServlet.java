import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Map this servlet to /HelpRequestServlet
@WebServlet("/HelpRequestServlet")
public class HelpRequestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handles GET requests to show the form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Disaster Management Help Request</title>");
        out.println("<style>");
        out.println("body, html { margin: 0; padding: 0; box-sizing: border-box; font-family: Arial, sans-serif; background-color: #121212; color: #ffffff; height: 100%; display: flex; align-items: center; justify-content: center; }");
        out.println(".container { background-color: #2c2c2c; border: 3px solid #f57c00; border-radius: 10px; padding: 20px; max-width: 400px; width: 90%; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.5); text-align: center; }");
        out.println("h1 { color: #f57c00; margin-bottom: 20px; }");
        out.println("label { display: block; margin-bottom: 5px; font-weight: bold; color: #f2f2f2; }");
        out.println("input, select, textarea, button { width: 80%; margin-bottom: 15px; padding: 10px; font-size: 16px; border: 1px solid #ccc; border-radius: 5px; display: block; margin-left: auto; margin-right: auto; }");
        out.println("input, select, textarea { background-color: #424242; color: #ffffff; }");
        out.println("input:focus, select:focus, textarea:focus { outline: none; border-color: #f57c00; box-shadow: 0 0 5px rgba(245, 124, 0, 0.7); }");
        out.println("button { background-color: #f57c00; color: #121212; font-weight: bold; border: none; cursor: pointer; transition: background-color 0.3s ease; }");
        out.println("button:hover { background-color: #ff8f00; }");
        out.println("footer { margin-top: 10px; font-size: 14px; color: #bdbdbd; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Request Help</h1>");
        out.println("<form action='HelpRequestServlet' method='post'>");
        out.println("<label for='name'>Full Name:</label>");
        out.println("<input type='text' id='name' name='name' required>");
        out.println("<label for='contact'>Contact Number:</label>");
        out.println("<input type='tel' id='contact' name='contact' required>");
        out.println("<label for='location'>Current Location:</label>");
        out.println("<input type='text' id='location' name='location' required>");
        out.println("<label for='helpType'>Type of Help Needed:</label>");
        out.println("<select id='helpType' name='helpType' required>");
        out.println("<option value='medical'>Medical Assistance</option>");
        out.println("<option value='food'>Food and Water</option>");
        out.println("<option value='shelter'>Shelter</option>");
        out.println("<option value='rescue'>Rescue</option>");
        out.println("</select>");
        out.println("<label for='details'>Additional Details:</label>");
        out.println("<textarea id='details' name='details' rows='4'></textarea>");
        out.println("<button type='submit'>Submit Request</button>");
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    // Handles POST requests to process the form
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String contact = request.getParameter("contact");
        String location = request.getParameter("location");
        String helpType = request.getParameter("helpType");
        String details = request.getParameter("details");
    
        // Respond back to the user
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
    
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Help Request Submitted</title>");
        out.println("<style>");
        out.println("body, html { margin: 0; padding: 0; box-sizing: border-box; font-family: Arial, sans-serif; background-color: #121212; color: #ffffff; height: 100%; display: flex; align-items: center; justify-content: center; }");
        out.println(".container { background-color: #2c2c2c; border: 3px solid #f57c00; border-radius: 10px; padding: 20px; max-width: 400px; width: 90%; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.5); text-align: center; }");
        out.println("h1 { color: #f57c00; margin-bottom: 20px; }");
        out.println("label { display: block; margin-bottom: 5px; font-weight: bold; color: #f2f2f2; }");
        out.println("input, select, textarea, button { width: 80%; margin-bottom: 15px; padding: 10px; font-size: 16px; border: 1px solid #ccc; border-radius: 5px; display: block; margin-left: auto; margin-right: auto; }");
        out.println("input, select, textarea { background-color: #424242; color: #ffffff; }");
        out.println("input:focus, select:focus, textarea:focus { outline: none; border-color: #f57c00; box-shadow: 0 0 5px rgba(245, 124, 0, 0.7); }");
        out.println("button { background-color: #f57c00; color: #121212; font-weight: bold; border: none; cursor: pointer; transition: background-color 0.3s ease; }");
        out.println("button:hover { background-color: #ff8f00; }");
        out.println("footer { margin-top: 10px; font-size: 14px; color: #bdbdbd; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Request Submitted</h1>");
        out.println("<p>Thank you, <strong>" + name + "</strong>, for reaching out. Here are the details of your request:</p>");
        out.println("<ul>");
        out.println("<li><strong>Contact:</strong> " + contact + "</li>");
        out.println("<li><strong>Location:</strong> " + location + "</li>");
        out.println("<li><strong>Help Type:</strong> " + helpType + "</li>");
        out.println("<li><strong>Details:</strong> " + (details.isEmpty() ? "No additional details provided" : details) + "</li>");
        out.println("</ul>");
        out.println("<p>We will get back to you shortly.</p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
    
}
