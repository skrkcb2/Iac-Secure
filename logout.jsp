<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>커피24 북카페</title>
</head>
<body>
	<script src="assets/js/jwt.js"></script>
	<script type="text/javascript">
		window.onload = function() {
			alert('로그아웃 되었습니다.');
			deleteTokens();
			<% session.invalidate(); %>;
			location.href='${pageContext.request.contextPath}';
		}
	</script>


</body>
</html>


