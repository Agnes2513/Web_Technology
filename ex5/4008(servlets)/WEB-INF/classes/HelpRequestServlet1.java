import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelpRequestServlet1")
public class HelpRequestServlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection details (using 'emergency_response' database)
    private static final String DB_URL = "jdbc:mysql://localhost:3306/emergency_response";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    // Handles POST requests to process the form
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String contact = request.getParameter("contact");
        String location = request.getParameter("location");
        String helpType = request.getParameter("helpType");
        String details = request.getParameter("details");

        // Prepare the response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Insert the data into the MySQL database
            String insertSql = "INSERT INTO user_feedback (name, contact, location, help_type, details) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertSql)) {
                stmt.setString(1, name);
                stmt.setString(2, contact);
                stmt.setString(3, location);
                stmt.setString(4, helpType);
                stmt.setString(5, details);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    // Successfully inserted, retrieve and display the data
                    String selectSql = "SELECT * FROM user_feedback WHERE contact = ? ORDER BY id DESC LIMIT 1";
                    try (PreparedStatement selectStmt = conn.prepareStatement(selectSql)) {
                        selectStmt.setString(1, contact);
                        ResultSet rs = selectStmt.executeQuery();

                        if (rs.next()) {
                            out.println("<!DOCTYPE html>");
                            out.println("<html lang='en'>");
                            out.println("<head>");
                            out.println("<meta charset='UTF-8'>");
                            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
                            out.println("<title>Help Request Submitted</title>");
                            out.println("<style>");
                            out.println("body { font-family: Arial, sans-serif; background-color: #f2f2f2; padding: 20px; }");
                            out.println(".container { background-color: #fff; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
                            out.println("h1 { font-size: 24px; }");
                            out.println("ul { list-style-type: none; padding: 0; }");
                            out.println("li { margin: 10px 0; }");
                            out.println("</style>");
                            out.println("</head>");
                            out.println("<body>");
                            out.println("<div class='container'>");
                            out.println("<h1>Request Submitted</h1>");
                            out.println("<p>Thank you, <strong>" + name + "</strong>, for reaching out. Here are the details of your request:</p>");
                            out.println("<ul>");
                            out.println("<li><strong>Contact:</strong> " + rs.getString("contact") + "</li>");
                            out.println("<li><strong>Location:</strong> " + rs.getString("location") + "</li>");
                            out.println("<li><strong>Help Type:</strong> " + rs.getString("help_type") + "</li>");
                            out.println("<li><strong>Details:</strong> " + (rs.getString("details").isEmpty() ? "No additional details provided" : rs.getString("details")) + "</li>");
                            out.println("</ul>");
                            out.println("<p>We will get back to you shortly.</p>");
                            out.println("</div>");
                            out.println("</body>");
                            out.println("</html>");
                        } else {
                            out.println("<p>Error: No data found after submission. Please try again later.</p>");
                        }
                    }
                } else {
                    out.println("<p>Error: No rows inserted. Please try again later.</p>");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>Error processing your request: " + e.getMessage() + "</p>");
        }
    }
}
