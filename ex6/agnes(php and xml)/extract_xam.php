<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Check if a file is uploaded
    if (isset($_FILES['file']) && $_FILES['file']['error'] === UPLOAD_ERR_OK) {
        $uploadedFile = $_FILES['file']['tmp_name'];
        
        // Ensure the uploaded file is an XML or XAM file
        $fileType = mime_content_type($uploadedFile);
        if ($fileType === 'application/xml' || $fileType === 'text/xml') {
            // Load the XML file
            $xml = simplexml_load_file($uploadedFile);
            
            if ($xml === false) {
                echo "Failed to parse the file. Ensure it is a valid XML/XAM file.";
            } else {
                // Display extracted data in a readable format
                echo "<h2>Extracted Book Details:</h2>";
                echo "<ul>";
                foreach ($xml->book as $book) {
                    echo "<li>";
                    echo "<strong>ID:</strong> " . htmlspecialchars($book['id']) . "<br>";
                    echo "<strong>Author:</strong> " . htmlspecialchars($book->author) . "<br>";
                    echo "<strong>Title:</strong> " . htmlspecialchars($book->title) . "<br>";
                    echo "<strong>Genre:</strong> " . htmlspecialchars($book->genre) . "<br>";
                    echo "<strong>Price:</strong> $" . htmlspecialchars($book->price) . "<br>";
                    echo "<strong>Publish Date:</strong> " . htmlspecialchars($book->publish_date) . "<br>";
                    echo "<strong>Description:</strong> " . htmlspecialchars($book->description) . "<br>";
                    echo "</li><hr>";
                }
                echo "</ul>";
            }
        } else {
            echo "Invalid file type. Please upload a valid XML or XAM file.";
        }
    } else {
        echo "Error in file upload.";
    }
} else {
    echo "Invalid request method.";
}
?>
