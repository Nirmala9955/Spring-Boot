<%@ page isELIgnored="false"%>

<h1 style="color:green; text-align: center;">Employee Registration Form</h1>
<form method="post">
	<table align="center">
		<tr>
			<td>Employee No: </td>
			<td><input type="text" name="eno"></td>
		</tr>
		<tr>
			<td>Employee Name: </td>
			<td><input type="text" name="ename"></td>
		</tr>
		<tr>
			<td>Employee Address: </td>
			<td><input type="text" name="eaddress"></td>
		</tr>
		<tr>
			<td>Employee Salary: </td>
			<td><input type="text" name="salary"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Register">
			</td>
		</tr>
	</table>
</form>