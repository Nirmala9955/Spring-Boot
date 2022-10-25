<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color: red; text-align: center;">Edit Tourist</h1>
<frm:form modelAttribute="tst">
	<table border="0" align="center" bgcolor="cyan">
		<tr>
			<td>Tourist Id: </td>
			<td><frm:input path="tid" readonly="true"/></td>
		</tr>
		<tr>
			<td>Tourist Name: </td>
			<td><frm:input path="name"/></td>
		</tr>
		<tr>
			<td>City: </td>
			<td><frm:input path="city"/></td>
		</tr>
		<tr>
			<td>Package Type: </td>
			<td><frm:input path="packageType"/></td>
		</tr>
		<tr>
			<td>Budget: </td>
			<td><frm:input path="budget"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Register Tourist"/></td>
		</tr>
	</table>
</frm:form>