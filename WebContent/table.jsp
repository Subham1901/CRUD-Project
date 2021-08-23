<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<link href="../css/page.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>

</head>
<body >
<div style="background-color: aqua;">
<center>


<h1>InsertData</h1>
<form action="InsertData" method="post">

<input type="text" name="id" placeholder="Enter ID">
<input type="text" name="name" placeholder="Enter Name">
<input type="text" name="state" placeholder="Enter State">
<input type="text" name="email" placeholder="Enter Email">
<input type="submit" value="ADD">
</form>

<h1>FindData</h1>
<form action="DataFind" method="post">
Enter ID to Search:<input type="text" name="name">
<input type="submit" value="find">
</form> <br><br>



<h1>ALLData</h1>
<form action="AllData" method="post">
AllData:
<input type="submit">


</form>
</center>
</div>

</body>
</html>