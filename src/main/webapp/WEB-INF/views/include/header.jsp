<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<div id="header">
		<h1>
			<a href="${pageContext.request.contextPath}/main">MySite</a>
		</h1>
		<!-- jstl start -->
		<c:choose>
			<c:when test="${empty user.userId}">
				<ul>
					<li><a href="${pageContext.request.contextPath}/user/loginForm">로그인</a></li>
					<li><a href="${pageContext.request.contextPath}/user/joinForm">회원가입</a></li>
				</ul>
			</c:when>
			<c:when test="${!empty user.userId}">
				<ul>
					<li>${user.userId}님안녕하세요!(UwU7)</li>
					<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
					<li><a href="${pageContext.request.contextPath}/user/modifyForm">회원정보수정</a></li>
				</ul>
			</c:when>
		</c:choose>
		<!-- jstl end -->
	</div>

