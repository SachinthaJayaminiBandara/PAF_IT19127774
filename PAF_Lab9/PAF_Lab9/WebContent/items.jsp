<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.Item"%>
<%
//Save---------------------------------
if (request.getParameter("Grant_Application_ID") != null) { 
Item itemObj = new Item(); 
String stsMsg = ""; 
	//Insert--------------------------
	if (request.getParameter("hidGrant_Application_IDSave") == "") 
	{ 
	stsMsg = itemObj.insertGrantApplication(request.getParameter("Grant_Application_ID"), 

	request.getParameter("Title"), 
	request.getParameter("Full_Name"),
	request.getParameter("Email"),
	request.getParameter("Phone"),
	request.getParameter("Research_category"),
	request.getParameter("Budget"),
	request.getParameter("Introduction")); 
	} 
	else//Update----------------------
	{ 
	stsMsg = itemObj.updateGrants(request.getParameter("hidGrant_Application_IDSave"), 
			request.getParameter("Title"), 
			request.getParameter("Full_Name"),
			request.getParameter("Email"),
			request.getParameter("Phone"),
			request.getParameter("Research_category"),
			request.getParameter("Budget"),
			request.getParameter("Introduction")); 
	} 
	session.setAttribute("statusMsg", stsMsg); 
} 
//Delete-----------------------------
if (request.getParameter("hidGrant_Application_IDDelete") != null) 
{ 
Item itemObj = new Item(); 
String stsMsg = 
itemObj.deleteGrants(request.getParameter("hidGrant_Application_IDDelete")); 
session.setAttribute("statusMsg", stsMsg); 
}
%>

<html>
<head>
<meta charset=ISO-8859-1">
<title>Items Management</title>
</head>
<link href="Views/bootstrap.min.css" rel="stylesheet" type="text/css">
<script src="Components/jquery.js"></script>
<script src="Components/items.js"></script>
<body>
<!--  
<script type="text/javascript">

if(typeof alertSuccess == "undefined"){
	alert ("not working");
}else{
	alert("working");
}
</script>
-->


<div class="container">
<h1 >Grant Management</h1>
<form method="post" action="items.jsp" id ="formItem">
	 <div class="mb-1 col-6">
   		 <label for="Grant_Application_ID" class="form-label">Grant Application ID</label>
    	<input type="text"name="Grant_Application_ID"  class="form-control" id="Grant_Application_ID">
    	<input  type="hidden" name="hidGrant_Application_IDSave" id ="hidGrant_Application_IDSave" >
    </div>
    <div class="mb-1 col-6">
   		 <label for="Title" class="form-label">Title</label>
    	<input type="text" name="Title"  class="form-control" id="Title">
    </div>
    <div class="mb-1 col-6">
   		 <label for="Full_Name" class="form-label">Full Name</label>
    	<input type="text"name="Full_Name"  class="form-control" id="Full_Name">
    </div>
    <div class="mb-1 col-6">
   		 <label for="Email" class="form-label">Email</label>
    	<input type="text"name="Email"  class="form-control" id="Email">
    </div>
    <div class="mb-1 col-6">
   		 <label for="Phone" class="form-label">Phone</label>
    	<input type="text"name="Phone"  class="form-control" id="Phone">
    </div>
    <div class="mb-1 col-6">
   		 <label for="Research_category" class="form-label">Research category</label>
    	<input type="text"name="Research_category"  class="form-control" id="Research_category">
    </div>
    <div class="mb-1 col-6">
   		 <label for="Budget" class="form-label">Budget</label>
    	<input type="text"name="Budget"  class="form-control" id="Budget">
    </div>
    <div class="mb-4 col-6">
   		 <label for="Introduction" class="form-label">Introduction</label>
    	<input type="text"name="Introduction"  class="form-control" id="Introduction">
    </div>

 <input name="btnSubmit" class="btn btn-primary mb-3" id="btnSave" type="button" value="Save">
 
</form>
<br>
<div class="alert alert-primary"  id="alertSuccess">
	<%
 		out.print(session.getAttribute("statusMsg"));
	%>
</div>
<div class="alert alert-danger"  id="alertError"> </div>


<%
 Item itemObj = new Item();
 out.print(itemObj.readGrants());
%>
</div>
</body>

</html>
