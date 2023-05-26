<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<link href="/mysite3/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/mysite3/assets/css/main.css" rel="stylesheet" type="text/css">

</head>

<body>
	<div id="wrap">
		<div id="header">
			<h1><a href="">MySite</a></h1>
			<!-- jstl -->
			<c:if test="${empty user.userId}">
				<ul>
					<li><a href="./user/loginForm">로그인</a></li>
					<li><a href="./user/joinForm">회원가입</a></li>
				</ul>
			</c:if>
			<c:if test="${!empty user.userId}">
				<ul>
					<li>${user.userName}님안녕하세요! ('U')/♣</li>
					<li><a href="./user/logout">로그아웃</a></li>
					<li><a href="./user/modifyForm">회원정보수정</a></li>
				</ul>
			</c:if>
		</div>
		
		<!-- //header -->
		<div id="nav">
			<ul>
				<li><a href="">방명록</a></li>
				<li><a href="">갤러리</a></li>
				<li><a href="">게시판</a></li>
				<li><a href="">입사지원서</a></li>
			</ul>
			<div class="clear"></div>
		</div>
		<!-- //nav -->

		<!-- aside없음 -->

		<div id="full-content">
		
			<!-- content-head 없음 -->

			<div id="index"> 
			
				<img id="profile-img" src="/mysite3/assets/image/profile.jpg">
				
				<div id="greetings">
					<p class="text-xlarge">
						<span class="bold">안녕하세요!!<br>
						이은우의 MySite에 오신 것을 환영합니다.<br>
						<br>
						이 사이트는 웹 프로그램밍 실습과제 예제 사이트입니다.<br>
						</span>
						<br>
						사이트 소개, 회원가입, 방명록, 게시판으로 구성되어 있으며<br>
						jsp&serlvet(모델2) 방식으로 제작되었습니다.<br>
						<br>
						자바 수업 + 데이터베이스 수업 + 웹프로그래밍 수업<br>
						배운 거 있는거 없는 거 다 합쳐서 만들어 놓은 사이트 입니다.<br>
						<br>
						(자유롭게 꾸며보세요!!)<br>
						<br><br>
						<a class="" href="">[방명록에 글 남기기]</a>
					</p>	
				</div>
				<!-- //greetings -->
				
				<div class="clear"></div>
				
			</div>
			<!-- //index -->
			
		</div>
		<!-- //full-content -->
		<div class="clear"></div>
		
		<div id="footer">
			Copyright ⓒ 2023 이은우. All right reserved
		</div>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>