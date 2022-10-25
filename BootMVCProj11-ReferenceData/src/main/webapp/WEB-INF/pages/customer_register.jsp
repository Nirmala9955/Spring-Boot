<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="register_customer" modelAttribute="cust">
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Customer Name: </td>
			<td><form:input path="cname"/></td>
		</tr>
		<tr>
			<td>Select Country: </td>
			<td>
				<form:select path="country">
					<form:options items="${countriesInfo}"/>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Select Known Languages: </td>
			<td>
				<form:select path="languages" multiple="multiple" size="5">
					<form:options items="${languagesInfo}"/>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Select Hobbies: </td>
			<td>
				<form:checkboxes items="${hobbiesInfo}" path="hobbies"/>
			</td>
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