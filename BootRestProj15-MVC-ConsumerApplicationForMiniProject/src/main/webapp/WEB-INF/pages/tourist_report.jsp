<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${!empty touristList}">
		<h1 style="color: green; text-align: center;">The Tourists Info</h1>
		<table  border="1" align="center" bgcolor="cyan">
			<tr>
				<th>TID</th>
				<th>Name</th>
				<th>City</th>
				<th>Package Type</th>
				<th>Budget</th>
				<th>Operations</th>
			</tr>
			<c:forEach var="tst" items="${touristList}">
				<tr>
					<td>${tst.tid}</td>
					<td>${tst.name}</td>
					<td>${tst.city}</td>
					<td>${tst.packageType}</td>
					<td>${tst.budget}</td>
					<td><a href="edit?id=${tst.tid}">Edit</a></td>
					<td><a href="edit?id=${tst.tid}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="text-align: center; color: red;">Tourist not found</h1>
	</c:otherwise>
</c:choose>
<br>
<h2 style="text-align: center;"><a href="add">Add Tourist</a></h2>
<br><br>
<h1 style="color: green; text-align: center;">${resultMsg}</h1>