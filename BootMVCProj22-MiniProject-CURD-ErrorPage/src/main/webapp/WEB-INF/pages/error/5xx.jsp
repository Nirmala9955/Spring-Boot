<%@ page isELIgnored="false" %>
<h1 style="color: red; text-align: center;">5XX Error</h1>

<div style="text-align: center;">
	<img alt="sorry image" src="images/5XX.jpg">
</div>

<table border="1" bgcolor="pink" align="center">
	<tr>
		<td>Status</td>
		<td>${status}</td>
	</tr>
	<tr>
		<td>Type</td>
		<td>${type}</td>
	</tr>
	<tr>
		<td>Time stamp</td>
		<td>${timestamp}</td>
	</tr>
	<tr>
		<td>Path</td>
		<td>${path}</td>
	</tr>
	<tr>
		<td>Message</td>
		<td>${message}</td>
	</tr>
</table>