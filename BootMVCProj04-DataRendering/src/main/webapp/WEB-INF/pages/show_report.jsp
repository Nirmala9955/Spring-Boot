<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- <h1 style="color: red; text-align: center;">Reading Simple Values</h1>
<b>Name : ${name}</b><br>
<b>Age : ${age}</b><br>
<b>Address : ${address}</b> --%>

<%-- <h1 style="color: red; text-align: center;">Reading Arrays, Collection Values</h1>
<b>Nick name : </b><br>
<c:forEach var="name" items="${nickNames}">
	${name}<br>
</c:forEach>
<hr>
<b>Phone number : </b><br>
<c:forEach var="phNo" items="${mobileNoSet}">
	${phNo}<br>
</c:forEach>
<hr>
<b>Phone number : </b><br>
<c:forEach var="course" items="${courseList}">
	${course}<br>
</c:forEach>
<hr>
<b>Phone number : </b><br>
<c:forEach var="ids" items="${idsMap}">
	${ids.key} : ${ids.value}<br>
</c:forEach>
 --%>

<%-- <h1 style="color: red; text-align: center;">Reading List of </h1>
<table border="1" align="center">
	<tr>
		<th>Employee No</th>
		<th>Employee Name</th>
		<th>Designation</th>
		<th>Salary</th>
	</tr>
	<c:forEach var="emp" items="${empList}">
		<tr>
			<td>${emp.eno}</td>
			<td>${emp.ename}</td>
			<td>${emp.desg}</td>
			<td>${emp.salary}</td>
		</tr>
	</c:forEach>
</table> --%>

<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color: red; text-align: center;">Reading Model object </h1>
<b>Employee No : ${employee. eno}</b><br>
<b >Employee Name : ${employee.ename}</b><br>
<b> Designation : ${employee.desg}</b><br>
<b>Salary : ${employee.salary}</b>

