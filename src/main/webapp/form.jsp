<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Form Sinh Viên</h2>
	<form action="sinhvien" method="post">
		<c:if test="${sv !=null }">
			<input type="hidden" name="id" value="${sv.id}">
		</c:if>
		<table>
			<tr>
				<td>HỌ TÊN</td>
				<td><input type="text" name="hoTen" value="${sv.hoTen}"></td>
			</tr>
			<tr>
				<td>ĐỊA CHỈ</td>
				<td><input type="text" name="diaChi" value="${sv.diaChi }"></td>
			</tr>
			<tr>
				<td>TÊN LỚP</td>
				<td><input type="text" name="tenLop" value="${sv.tenLop }"></td>
			</tr>
			<tr>
				<td>NĂM SINH</td>
				<td><input type="date" name="namSinh" value="${sv.namSinh}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>
</body>
</html>