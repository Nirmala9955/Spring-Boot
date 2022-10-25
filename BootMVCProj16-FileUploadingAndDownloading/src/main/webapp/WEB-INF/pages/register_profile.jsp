<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color: red; text-align: center;">Marriage Seeker Registration</h1>

<form:form modelAttribute="seeker" enctype="multipart/form-data">
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Marriage Seeker Name:</td>
			<td><form:input path="profileName"/></td>
		</tr>
		<tr>
			<td>Marriage Seeker Gender:</td>
			<td>
				<form:radiobutton path="gender" value="male"/>Male &nbsp;&nbsp;
				<form:radiobutton path="gender" value="female"/>Female 
			</td>
		</tr>
		<tr>
			<td>Select Resume:</td>
			<td><form:input type="file" path="resume"/></td>
		</tr>
		<tr>
			<td>Select Photo:</td>
			<td><form:input type="file" path="photo"/></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="reset" value="Cancel"> &nbsp;&nbsp;
				<input type="submit" value="Register">
			</td>
		</tr>
	</table>
</form:form>