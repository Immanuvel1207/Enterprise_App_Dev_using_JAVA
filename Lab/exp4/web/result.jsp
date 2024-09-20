<!DOCTYPE html>
<html>
<head>
    <title>Mark Calculator Result</title>
</head>
<body>
    <h2>Mark Calculation Result</h2>

    <p>Marks:</p>
    <ul>
        <li>Subject 1: <%= request.getAttribute("subject1") %></li>
        <li>Subject 2: <%= request.getAttribute("subject2") %></li>
        <li>Subject 3: <%= request.getAttribute("subject3") %></li>
    </ul>
    
    <p><strong>Total Marks: </strong><%= request.getAttribute("total") %></p>
    <p><strong>Average Marks: </strong><%= request.getAttribute("average") %></p>

    <a href="index.jsp">Go Back</a>
</body>
</html>
