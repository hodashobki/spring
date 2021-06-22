<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Song</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<style>
input[type=text], input[type=number] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #5a3d3d;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
</head>
<body>
<h3>Add New Song</h3>

<div>
  <form action="/creatsong" method="post">
    <label for="fname">Title</label>
    <input type="text" id="fname" name="title" placeholder="The Title..">

    <label for="lname">Artist</label>
    <input type="text" id="lname" name="artist" placeholder="The Artist..">
    
    <label for="rat">Rating</label>
    <input type="number" id="lname" name="rating" placeholder="Add Rating..">
  
    <input type="submit" value="Submit">
  </form>
</div>
</body>
</html>