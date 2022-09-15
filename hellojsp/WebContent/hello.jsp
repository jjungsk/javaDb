<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
private String name;

public void init() {
	name = "정세권";
}
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello JSP!</h2>
	<h2>안녕 <%=name %>!</h2>
</body>
</html>