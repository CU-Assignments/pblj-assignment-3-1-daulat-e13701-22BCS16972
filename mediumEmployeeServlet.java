import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class EmployeeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String empId = request.getParameter("id");
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "Vivek", "Root1234");

            String query;
            if (empId != null && !empId.isEmpty()) {
                query = "SELECT * FROM employees WHERE id = ?";
            } else {
                query = "SELECT * FROM employees";
            }

            PreparedStatement ps = conn.prepareStatement(query);

            if (empId != null && !empId.isEmpty()) {
                ps.setInt(1, Integer.parseInt(empId));
            }

            ResultSet rs = ps.executeQuery();

            out.println("<h2>Employee Details</h2>");
            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Department</th><th>Salary</th></tr>");

            boolean found = false;
            while (rs.next()) {
                found = true;
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("department") + "</td>");
                out.println("<td>" + rs.getDouble("salary") + "</td>");
                out.println("</tr>");
            }

            if (!found) {
                out.println("<tr><td colspan='4'>No record found.</td></tr>");
            }

            out.println("</table>");

            conn.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }

        out.close();
    }
}
