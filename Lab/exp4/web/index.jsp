<!DOCTYPE html>
<html>
<head>
    <title>Mark Calculator</title>
</head>
<body>
    <h2>Enter Marks for 3 Subjects</h2>
    <form action="MarkServlet" method="post">
        <label for="subject1">Subject 1 Marks:</label>
        <input type="number" id="subject1" name="subject1" required><br><br>
        
        <label for="subject2">Subject 2 Marks:</label>
        <input type="number" id="subject2" name="subject2" required><br><br>
        
        <label for="subject3">Subject 3 Marks:</label>
        <input type="number" id="subject3" name="subject3" required><br><br>
        
        <input type="submit" value="Calculate">
    </form>
</body>
</html>
