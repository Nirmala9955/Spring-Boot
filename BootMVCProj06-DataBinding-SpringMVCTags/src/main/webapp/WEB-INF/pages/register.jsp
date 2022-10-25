<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color:green; text-align: center;">Employee Registration Form</h1>
<form:form modelAttribute="emp">
	<table align="center">
		<tr>
			<td>Employee No: </td>
			<td><form:input path="eno"/></td>
		</tr>
		<tr>
			<td>Employee Name: </td>
			<td><form:input path="ename"/></td>
		</tr>
		<tr>
			<td>Employee Address: </td>
			<td><form:input path="eaddress"/></td>
		</tr>
		<tr>
			<td>Employee Salary: </td>
			<td><form:input path="salary"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Register">
			</td>
		</tr>
	</table>
</form:form>