<?php
// Database connection settings
$host = 'localhost';
$username = 'root';
$password = '';
$dbname = 'disaster_management';

// Create connection
$conn = new mysqli($host, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Fetch all feedback records from the database
$sql = "SELECT * FROM feedback ORDER BY submitted_at DESC";
$result = $conn->query($sql);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Feedbacks</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #333;
            color: #f1f1f1;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
        }
        h2 {
            color: #ff6600;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #444;
            border-radius: 8px;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ccc;
        }
        th {
            background-color: #555;
        }
        tr:nth-child(even) {
            background-color: #555;
        }
        tr:nth-child(odd) {
            background-color: #666;
        }
        a {
            color: #ff6600;
            text-decoration: none;
            font-size: 16px;
            margin-top: 20px;
            display: block;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>All Feedbacks</h2>

        <?php
        if ($result->num_rows > 0) {
            // Display feedbacks in a table
            echo "<table><tr><th>ID</th><th>Name</th><th>Email</th><th>Feedback</th><th>Submitted At</th></tr>";
            while($row = $result->fetch_assoc()) {
                echo "<tr><td>" . $row["id"] . "</td><td>" . $row["name"] . "</td><td>" . $row["email"] . "</td><td>" . $row["feedback"] . "</td><td>" . $row["submitted_at"] . "</td></tr>";
            }
            echo "</table>";
        } else {
            echo "<p>No feedbacks found.</p>";
        }

        // Close the database connection
        $conn->close();
        ?>

        <a href="m.php">Click here to submit new feedback</a>
    </div>

</body>
</html>
