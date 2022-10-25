<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color: blue; text-align: center;">Edit Employee</h1>

<script type="text/javascript" src="js/form_validation.js"></script> 

<form:form modelAttribute="emp"  onsubmit="return validate(this)">
	<%-- <p style="color: red; text-align: center;">
		<form:errors path="*"/>
	</p> --%>
	<form:hidden path="vflag"/>
	<table border="0" bgcolor="cyan" align="center">
		<tr>
			<td>Employee No : </td>
			<td><form:input path="empno" readonly="true"/></td>
		</tr>
		<tr>
			<td>Employee Name : </td>
			<td>
				<form:input path="ename"/>
				<form:errors path="ename" cssStyle="color:red"/>
				<span id="enameErr"  style="color: red;"></span> 
			</td>
		</tr>
		<tr>
			<td>Employee Designation : </td>
			<td>
				<form:input path="job"/>
				<form:errors path="job" cssStyle="color:red"/>
				<span id="jobErr" style="color: red;"></span> 
			</td>
		</tr>
		<tr>
			<td>Employee Salary : </td>
			<td>
				<form:input path="sal"/> 
				<form:errors path="sal" cssStyle="color:red"/>
				<span id="salErr" style="color: red;"></span>
			</td>
		</tr>
		<tr>
			<td>Employee Dept No : </td>
			<td>
				<form:input path="deptno"/>
				<form:errors path="deptno" cssStyle="color:red"/>
				<span id="deptnoErr" style="color: red;"></span> 
			</td>
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