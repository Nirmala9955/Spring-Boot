<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form modelAttribute="cktr">
	<table border="0" bgcolor="cyan" align="center">
		<p style="color: red;">
			<form:errors path="*"/>
		</p>
		<tr>
			<td>Cricketer Name</td>
			<td><form:input path="name"/> </td>
		</tr>
		<tr>
			<td>Cricketer Type</td>
			<td><form:input path="type"/> </td>
		</tr>
		<tr>
			<td>Cricketer DOB</td>
			<td><form:input path="dob" type="date"/> </td>
		</tr>		
		<tr>
			<td>Cricketer DOJ</td>
			<td><form:input path="doj" type="date"/> </td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="reset" value="Cancel">&nbsp;&nbsp;
				<input type="submit" value="Register">
			</td>		
		</tr>
	
	
	
	</table>
</form:form>
