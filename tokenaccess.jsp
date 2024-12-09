<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Token Handling Page</title>
</head>
<body>
    <h1>Token Handling Page </h1>
    
    <%-- 여기에서 서버에서 전달받은 accessToken과 refreshToken 값을 받아서 JavaScript 변수에 저장합니다. --%>
    <%-- 받아온 값은 Java 코드로 전달될 것이므로 여기에는 JavaScript 변수에 값을 할당하는 부분만 작성합니다. --%>
	<%
        String accessToken = (String) session.getAttribute("accessToken");
	 	String beforeaccessToken = (String) session.getAttribute("beforeaccessToken");
        String refreshToken = (String) session.getAttribute("refreshToken");
        /* String url = (String) session.getAttribute("url"); */
        String url = (String) session.getAttribute("url");
        System.out.println(url);
   	    System.out.println(session.getAttribute("accessToken"));
   	    System.out.println(session.getAttribute("beforeaccessToken"));
	    System.out.println(session.getAttribute("refreshToken"));
        
    %> 
    <script>
    function jwtload() {
        // 서버에서 받은 accessToken
         const serverAccessToken = "<%= accessToken %>";
         const beforeserverAccessToken = "<%= beforeaccessToken %>";
         const serverRefreshToken = "<%= refreshToken %>";
         const url = "<%= url %>";
         

        // 로컬 스토리지에서 가져온 accessToken
        const localAccessToken = localStorage.getItem('accessToken');
        const localRefreshToken = localStorage.getItem('refreshToken');
        // 서버에서 받은 accessToken과 로컬 스토리지에 저장된 accessToken을 비교
        if (beforeserverAccessToken === localAccessToken) {
            console.log("서버에서 받은 accessToken과 로컬 스토리지의 accessToken이 일치합니다.");
          console.log("serverAccessToken: ", serverAccessToken);
          console.log("localAccessToken: ", localAccessToken);
          saveTokens(serverAccessToken,serverRefreshToken);
          window.location.href = url;
            // accessToken이 일치하면 추가적인 작업 수행
        } else {
            console.log("서버에서 받은 accessToken과 로컬 스토리지의 accessToken이 일치하지 않습다.");
            console.log("serverAccessToken: ", serverAccessToken);
            console.log("localAccessToken: ", localAccessToken);
        	alert('정상이 아닌방법으로 접근하려 했습니다.');
        	window.location.href = "logout.jsp";
            
        }
    }
    </script>
      <script>
        // jwt.js 파일이 로드된 후에 실행되도록 window.onload에 함수를 할당합니다.
        window.onload = function() {
        	jwtload();
        };
    </script>
       <script src="assets/js/jwt.js"></script>

  
 
</body>
</html>