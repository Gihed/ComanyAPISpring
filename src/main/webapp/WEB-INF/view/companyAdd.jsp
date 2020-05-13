<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding Company</title>
<link href="/css/bootstrap.css" rel="stylesheet">
</head>
<body>

	<div class="Container">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<form:form action="/add" method="post" modelAttribute="company">
				<h3>Add new Company:</h3>
					<div class="form-group">
						<form:label path="nom">Company Name</form:label> 
						<form:input type="text"
							class="form-control" path="nom" placeholder="example xyz"/>
					</div>
					<div class="form-group">
						<form:label path="siren">Company SIREN</form:label> 
						<form:input type="text"
							class="form-control" path="siren" placeholder="9 numbers"/>
					</div>
					<div class="form-group">
						<form:label path="rcs">Company RCS</form:label> 
						<form:input type="text"
							class="form-control" path="rcs" placeholder="5 numbers"/>
					</div>
					<div class="form-group">
						<form:label path="address.country">Country</form:label> 
						<form:input type="text"
							class="form-control" path="address.country" placeholder="exple tunis"/>
					</div>
					<div class="form-group">
						<form:label path="address.city">City</form:label> 
						<form:input type="text"
							class="form-control" path="address.city" placeholder="exple tunis"/>
					</div>
					<div class="form-group">
						<form:label path="address.zipCode">Zipcode</form:label> 
						<form:input type="text"
							class="form-control" path="address.zipCode" placeholder="numbers"/>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form:form>
			</div>
			<div class="col-3"></div>
		</div>
	</div>


</body>
</html>