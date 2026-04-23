<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@
   taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>ĐỊA CHỈ</th>
			<th>TÊN LỚP</th>
			<th>NĂM SINH</th>
			<td><b>HÀNH ĐỘNG</b></td>
		</tr>
		<c:forEach var="sv" items="${listSV}">
			<tr>
				<td>${sv.id}</td>
				<td>${sv.name}</td>
				<td>${sv.diaChi}</td>
				<td>${sv.tenLop}</td>
				<td>${sv.namSinh}</td>
				<td>
				<a href="sinhvien?action=edit&id=${sv.id}">Edit</a>
				<a href="sinhvien?action=delete&id=${sv.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
<a href="sinhvien?action=new">THÊM SINH VIÊN</a>
</body>
</html>