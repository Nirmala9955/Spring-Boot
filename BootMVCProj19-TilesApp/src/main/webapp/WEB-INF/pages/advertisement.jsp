<%@page import="java.util.*"%>
<%@ page isELIgnored="false" %>

<%
	String adsImages[] = new String[]{"raymond.jpg","digjam.jpg","siyaram.jpg", "ramraj.jpg"};
	int adsNumber = new Random().nextInt(adsImages.length);
	//To refresh automatic after 2 seconds
    response.setIntHeader("Refresh", 2);
%>
<img src="images/<%=adsImages[adsNumber]%>" width="100%">