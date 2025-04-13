<!DOCTYPE html>
<html>
<head>
    <title>Student Attendance Portal</title>
</head>
<body>
    <h2>Enter Attendance Details</h2>
    <form action="AttendanceServlet" method="post">
        Name: <input type="text" name="student_name" required><br><br>
        Subject: <input type="text" name="subject" required><br><br>
        Date: <input type="date" name="date" required><br><br>
        Status: 
        <select name="status">
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select><br><br>
        <input type="submit" value="Submit Attendance">
    </form>
</body>
</html>
