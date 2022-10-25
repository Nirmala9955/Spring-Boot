<%@page import="java.util.Random"%>
<%@ page isELIgnored="false" %>

<h1 style="color: blue; text-align: center;">Show Balance page</h1>
<div style="text-align: center;">
	<b>Balance : <%=new Random().nextInt(10000000)%></b>
</div>

<div style="text-align: center;">
	<a href="./">Home</a>&nbsp;&nbsp;
	<a href="offers">Show Offers</a>&nbsp;&nbsp;
	<a href="loanApprove">Approve Loan</a>
	<a href="logout">Logout</a>
</div>