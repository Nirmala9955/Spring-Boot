<%@page import="java.util.Random"%>
<%@ page isELIgnored="false" %>

<h1 style="color: blue; text-align: center;">Loan Approval page</h1>
<div style="text-align: center;">
	<b>Your approved for Loan amount : <%=new Random().nextInt(10000000)%></b>
</div>

<div style="text-align: center;">
	<a href="./">Home</a>&nbsp;&nbsp;
	<a href="balance">Check Balance</a>&nbsp; &nbsp;
	<a href="offers">Show Offers</a>
	<a href="logout">Logout</a>
</div>