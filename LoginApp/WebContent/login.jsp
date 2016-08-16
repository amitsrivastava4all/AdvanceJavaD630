<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="login.title"/></title>
</head>
<body>
<%-- <s:form theme="simple"> --%>
<s:form action="login" method="post">
<s:textfield name="userid" key="login.lbluserid" tooltip="Type Userid Here"/>
<s:password name="pwd" key="login.lblpassword" tooltip="Type Password Here"/>
<s:submit key="login.submit"/>
<s:reset  key="login.reset" />
</s:form>
</body>
</html>