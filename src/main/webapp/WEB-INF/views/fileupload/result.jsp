<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/gallery.css" rel="stylesheet" type="text/css">

</head>

<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //header -->

		<c:import url="/WEB-INF/views/include/nav.jsp"></c:import>
		<!-- //nav -->


		<div id="container" class="clearfix">
			<c:import url="/WEB-INF/views/include/galleryAside.jsp"></c:import>
			<!-- //aside -->


			<div id="content">

				<div id="content-head">
					<h3>첨부파일연습</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>갤러리</li>
							<li class="last">첨부파일연습</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->


				<div id="file">

					<div>
						<img id="resultImg" src="${pageContext.request.contextPath}/upload/${saveName}">
					</div>
					<p>
						<a id="btnUpload" href="${pageContext.request.contextPath}/fileupload/form"> 다시 업로드 하기 </a>
					</p>

				</div>
				<!-- //file -->

			</div>
			<!-- //content  -->

		</div>
		<!-- //container  -->


			<div id="footer">Copyright ⓒ 2023 이은우. All right reserved</div>
	</div>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>