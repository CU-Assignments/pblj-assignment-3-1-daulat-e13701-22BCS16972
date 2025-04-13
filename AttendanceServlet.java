import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AttendanceServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("student_name");
        String subject = request.getParameter("subject");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_portal", "Vivek", "Root1234");

            String sql = "insert into attendance (student_name, subject, date, status) values (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, subject);
            ps.setString(3, date);
            ps.setString(4, status);
            ps.executeUpdate();

            out.println("<h2>Attendance Submitted Successfully!</h2>");
            con.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
