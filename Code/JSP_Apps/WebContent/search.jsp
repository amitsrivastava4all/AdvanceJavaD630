<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="bmpl" tagdir="/WEB-INF/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<bmpl:jqueryhead/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search </title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<bmpl:date/>
Calendar <bmpl:calendar currentid="dob"/>
<fieldset>
<legend>Search Employee</legend>
<form action="empctrl" method="post">
<div class="form-group">
<input class="form-control" type="text" name="salary" placeholder="Type Salary to Search"/>
</div>
<div class="form-group">
<button class="btn btn-primary" type="submit" ><span class="glyphicon glyphicon-search"></span>Search</button>
</div>
</form>
</fieldset>
<fieldset>
<legend>Search Result</legend>
<!--  This is EL (Expression Language -->
<%-- ${searchdata} --%>
<c:if test="${searchdata.size() gt 0 }">
<table class="table table-bordered table-hover table-striped" >
<tr>
<th>S.No</th>
<th>Empno</th>
<th>Name</th>
<th>Salary</th>
</tr>
<c:forEach items="${searchdata}" var="empobject" varStatus="loopcurrentpos">
<c:if test ="${ loopcurrentpos.count mod 2 eq 0}">

<tr style="background-color: aqua;">
<td>${loopcurrentpos.count}</td>
<td>${empobject.id}</td>
<td>${empobject.name}</td>
<td>${empobject.salary}</td>
</tr>


</c:if>
<c:if test ="${ loopcurrentpos.count mod 2 ne 0}">

<tr style="background-color: gray;">
<td>${loopcurrentpos.count}</td>
<td>${empobject.id}</td>
<td>${empobject.name}</td>
<td>${empobject.salary}</td>
</tr>


</c:if>

</c:forEach>
</table>
</c:if>
</fieldset>
</div>
</body>
</html>