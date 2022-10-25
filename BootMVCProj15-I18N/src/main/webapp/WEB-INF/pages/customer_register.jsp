<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h1 style="color: green; text-align: center;">
	<spring:message code="cust.reg.title"/>
</h1>

<form:form modelAttribute="customer">
	<table align="center" bgcolor="cyan">
		<tr>
			<td><spring:message code="cust.reg.name"/></td>
			<td><form:input path="cname"/></td>
		</tr>
		<tr>
			<td><spring:message code="cust.reg.address"/></td>
			<td><form:input path="caddress"/></td>
		</tr>
		<tr>
			<td><spring:message code="cust.reg.billAmount"/></td>
			<td><form:input path="billAmount"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="<spring:message code="cust.reg.submit"/>">
			</td>
		</tr>
	</table>
</form:form>
<br>

<div style="text-align: center;">
	<fmt:setLocale value="${response.locale}"/>
	<jsp:useBean id="dt" class="java.util.Date"/>
	<fmt:formatDate value="${dt}" var="fDate" type="date" dateStyle="FULL"/>
	System Date : ${fDate}<br>
	<fmt:formatDate value="${dt}" var="fTime" type="time"/>
	System Date : ${fTime}<br>
	
	<fmt:formatNumber value="10000000000" var="fPrice" type="currency"/>
	Item Price : ${fPrice}<br>
	<fmt:formatNumber value="9876543210" var="fNumber" type="number"/>
	Item Number : ${fNumber}<br>
</div>

<br>
<p style="text-align: center;">
	<a href="?lang=en_US">English</a>&nbsp;&nbsp;
	<a href="?lang=fr_FR">French</a>&nbsp;&nbsp;
	<a href="?lang=de_DE">German</a>&nbsp;&nbsp;
	<a href="?lang=hi_IN">Hindi</a>&nbsp;&nbsp;
	<a href="?lang=zh_CN">Chainese</a>&nbsp;&nbsp;
</p>
