<%@page import="com.a2m.domain.DTO.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.a2m.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>User</h1>
	<form action="/Base-mvc/user" method="post">
		<label for="">Username</label>
        <input type="text" name="username"> <br>
		<label for="">Fullname</label>
        <input type="text" name="fullname"> <br>
        <label for="">Age</label>
        <input type="number" name="age">
        <button type="submit">Create</button>
	</form>
	
	<% 
		UserDAO dao = new UserDAO();
       	List<UserDTO> listUserDTOs = dao.getAll();
	%>
	<table>
		<thead>
			<tr>
				<th>Username</th>
				<th>Fullname</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
		
	<% for(int i = 0; i < listUserDTOs.size(); i++){ 
		UserDTO u = listUserDTOs.get(i);
	%>
	
			<tr>
				<td><%=u.getUsername() %></td>
				<td><%=u.getFullname() %></td>
				<td><%=u.getAge() %></td>
				
			</tr>
		
		
		<%-- <h3>Fullname: <%=u.getFullname() %></h3> --%>
	
	<%} %>
	
	</tbody>
	</table>
	<%-- <h2>User</h2>
	<h3>Fullname: ${ fullname }</h3>
	<h3>Age: ${ age }</h3> --%>
</body>
</html>