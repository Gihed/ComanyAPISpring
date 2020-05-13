<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Info</title>
<link href="/css/bootstrap.css" rel="stylesheet">

</head>
<body>

<div class="container">
<h2>Company information</h2>
 <div class="alert alert-primary" role="alert">Company name: ${company.nom}</div>
 <div class="alert alert-primary" role="alert">Company siren: ${company.siren}</div>
 <div class="alert alert-primary" role="alert">Company rcs: ${company.rcs}</div>
 <h2>Address </h2>
 <div class="alert alert-primary" role="alert">Company Country: ${company.address.country}</div>
 <div class="alert alert-primary" role="alert">Company City: ${company.address.city}</div>
 <div class="alert alert-primary" role="alert">Company zipcode: ${company.address.zipCode}</div>
 
</div>
</body>
</html>