<%@tag import="java.text.DateFormat"%>
<%@tag import="java.util.Locale"%>
<%@tag import="java.util.Date"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%
Date date = new Date();
Locale locale = new Locale("hi","IN");
DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,locale);
String formattedDate = df.format(date);

%>
<h2>Date is <%=formattedDate %></h2>
