<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
	<c:when test="${!empty facultiesList}">
		<table border="1" align="center">
			<tr>
				<th>Faculty ID</th>
				<th>Faculty Name</th>
				<th>Qualification</th>
				<th>Subject</th>
			</tr>
			<c:forEach var="fac" items="${facultiesList}">
				<tr>
					<td>${fac.fid}</td>
					<td>${fac.fname}</td>
					<td>${fac.qlfy}</td>
					<td>${fac.subject}</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: red; text-align: center;">No records found</h1>
	</c:otherwise>
</c:choose>