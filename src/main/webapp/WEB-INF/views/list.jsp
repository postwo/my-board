<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<link rel="stylesheet" href="resources/css/common.css" type="text/css">
</head>
<body>
	<button onclick="location.href='writeForm'">글쓰기</button>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<!-- 내용 -->
		<c:if test="${list.size() == 0 }">
			<tr><td colspan="5">게시물이 존재하지 않습니다.</td></tr>
		</c:if>
		<c:forEach items="${list}" var="bbs">
			<tr>
				<td>${bbs.idx}</td>
				<td><a href="detail?idx=${bbs.idx}">${bbs.subject}</a></td>
				<td>${bbs.user_name}</td>
				<td>${bbs.bHit}</td>
				<td>${bbs.reg_date}</td>
			</tr>		
		</c:forEach>
	</table>
</body>
<script></script>
</html>