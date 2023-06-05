<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User JoinForm</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
</head>

<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //nav -->

		<div id="aside">
			<h2>회원</h2>
			<ul>
				<li>회원정보</li>
				<li>로그인</li>
				<li>회원가입</li>
			</ul>
		</div>
		<!-- //aside -->

		<div id="content">
			
			<div id="content-head">
            	<h3>회원가입</h3>
            	<div id="location">
            		<ul>
            			<li>홈</li>
            			<li>회원</li>
            			<li class="last">회원가입</li>
            		</ul>
            	</div>
                <div class="clear"></div>
            </div>
            <!-- //content-head -->

			<div id="user">
				<div id="joinForm">
					<form action="${pageContext.request.contextPath}/user/join" method="get">

						<!-- 아이디 -->
						<div class="form-group">
							<label class="form-text" for="input-uid">아이디</label> 
							<input type="text" id="input-uid" name="userId" value="" placeholder="아이디를 입력하세요">
							<button type="button" id="btnIdCheck">중복체크</button>
							<p id="idCheckMsg">아이디를 입력하라옹</p>
						</div>

						<!-- 비밀번호 -->
						<div class="form-group">
							<label class="form-text" for="input-pass">패스워드</label> 
							<input type="text" id="input-pass" name="userPwd" value="" placeholder="비밀번호를 입력하세요"	>
						</div>

						<!-- 이메일 -->
						<div class="form-group">
							<label class="form-text" for="input-name">이름</label> 
							<input type="text" id="input-name" name="userName" value="" placeholder="이름을 입력하세요">
						</div>

						<!-- //나이 -->
						<div class="form-group">
							<span class="form-text">성별</span> 
							
							<label for="rdo-male">남</label> 
							<input type="radio" id="rdo-male" name="gender" value="male" > 
							
							<label for="rdo-female">여</label> 
							<input type="radio" id="rdo-female" name="gender" value="female" > 

						</div>

						<!-- 약관동의 -->
						<div class="form-group">
							<span class="form-text">약관동의</span> 
							
							<input type="checkbox" id="chk-agree" value="" name="" required>
							<label for="chk-agree">서비스 약관에 동의합니다.</label> 
						</div>
						
						<!-- 버튼영역 -->
		                <div class="button-area">
		                    <button type="submit" id="btn-submit">회원가입</button>
		                </div>
						
					</form>
				</div>
				<!-- //joinForm -->
			</div>
			<!-- //user -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>
		
		<div id="footer">
			Copyright ⓒ 2023 이은우. All right reserved
		</div>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

<script type="text/javascript">
	//아이디 체크 버튼 클릭했을때
	$("#btnIdCheck").on("click", function() {
		console.log("버튼 클릭");

		//id 추출
		var id = $("[name=userId]").val();

		console.log(id);

		//통신 id
		$.ajax({
			url : "${pageContext.request.contextPath }/user/idcheck",
			type : "post",

			data : {id : id},

			dataType : "json",
			success : function(jsonResult) {
				console.log(jsonResult);

				if(jsonResult.result == 'success'){
					//사용가능하진 불가능 한지 표현한다
					if(jsonResult.data == true){
						$("#idCheckMsg").css("color","blue");  
						$("#idCheckMsg").html( id+ "는 사용가능 합니다.");  
					}else{
						$("#idCheckMsg").css("color","red");  
						$("#idCheckMsg").html( id+ "는 사용중 입니다."); 
					}//inner if
				}else{
					  
				}
			},//success : function(jsonResult)
			error : function(XHR, status, error) {
			  
				console.error(status + " : " + error);
			}
		});//ajax

	}); //$("#btnIdCheck").on
</script>

</html>