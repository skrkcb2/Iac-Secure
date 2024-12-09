<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Token Handling Page</title>
</head>
<body>
    <h1>Token Handling Page</h1>
    
    <%-- 여기에서 서버에서 전달받은 accessToken과 refreshToken 값을 받아서 JavaScript 변수에 저장합니다. --%>
    <%-- 받아온 값은 Java 코드로 전달될 것이므로 여기에는 JavaScript 변수에 값을 할당하는 부분만 작성합니다. --%>
	<%
        String accessToken = (String) session.getAttribute("accessToken");
        String refreshToken = (String) session.getAttribute("refreshToken");
        String url= request.getContextPath();
        System.out.println(accessToken);
        System.out.println(refreshToken);
    %> 
    
    <script>
    function firstToken(){
    	alert("함수 호출");
        // 서버에서 전달받은 accessToken과 refreshToken 값을 JavaScript 변수에 저장합니다.
		var accessToken = "<%= accessToken %>";
        var refreshToken = "<%= refreshToken %>";
        var url = "<%= url %>"
        
/*         alert(accessToken);
        alert(refreshToken); */
		// 로컬 스토리지에 accessToken과 refreshToken을 저장합니다.
      	saveTokens(accessToken,refreshToken);
        
        // 저장된 후에 원래의 로직으로 돌아갑니다.
        // 여기에는 원래의 페이지로 리다이렉트하는 코드 또는 다른 작업을 수행하는 코드를 작성합니다.
        window.location.href = url;
    }
    
    window.onload = function(){
    	firstToken();
    }
    
    </script>
    <script src="assets/js/jwt.js"></script>
</body>
</html>