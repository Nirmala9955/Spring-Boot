<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color: blue; text-align: center;">Edit Employee</h1>

<form:form modelAttribute="emp">
	<table border="0" bgcolor="cyan" align="center">
		<tr>
			<td>Employee No : </td>
			<td><form:input path="empno" readonly="true"/></td>
		</tr>
		<tr>
			<td>Employee Name : </td>
			<td><form:input path="ename"/> </td>
		</tr>
		<tr>
			<td>Employee Designation : </td>
			<td><form:input path="job"/> </td>
		</tr>
		<tr>
			<td>Employee Salary : </td>
			<td><form:input path="sal"/> </td>
		</tr>
		<tr>
			<td>Employee Dept No : </td>
			<td><form:input path="deptno"/> </td>
		</tr>
		<tr>
			<td></td>
			<td>
				<button type="reset">
					<img class="operation-btn" alt="rest image" src="images/cancel.png">
				</button> 
				&nbsp;&nbsp;
				<input class="operation-btn" type="image" src="images/update-user.png">
			</td>
		</tr>
	</table>
</form:form>

<style>
.operation-btn{
	width: 50px;
	height: 50px;
}
</style>