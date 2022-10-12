<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri = "http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body style = "background:white;">
<div align="center">
<u><i>Company Share List</u>
	<h3 style = "red" color:""#FFC0CB";>
		<a href="company-entry">Enlist a new Company</a>
	</h3>
	<hr size = "5" color="cyan"/>
	<table border="2">
	  	<tr style = "background-color:#FFA500; color:#0000ff;">
		    <th>COMPANY ID</th>
		    <th>COMPANY Name</th>
		    <th>SHARE Price</th>
		    <th>Action</th>
	    </tr>
	    <c:forEach  items="${companyList}" var="company">
	      <tr style = "background-color:#FFFF00; color:#0000ff;">
		      <td>${company.companyId}</td>
		      <td>${company.companyName}</td>
		      <td>${company.sharePrice}</td>
		      <td>
			      <h3>
				    
				      <a href = "edit-company/${company.companyId}">Edit Share Price</a> 
				      <a href="delete-company/${company.companyId}">Delete Company</a>
			      </h3>
		      </td>
	      </tr>
	     </c:forEach>
 		</table>
</div>
</body>
</html>