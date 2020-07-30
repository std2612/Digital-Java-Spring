<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<br>
<h1>
	<a href="<%=request.getContextPath()%>/board/list">게시판</a>
</h1>
<br>

<form action="<%=request.getContextPath()%>/board/delete" method="POST">
	<div class="form-group">
		<label for="num">글 번호</label>
		<input type="text" class="form-control" name="num" value="${board.num}" readonly>
	</div>
	<div class="form-group">
		<label for="title">글 제목 </label>
		<input type="text" class="form-control" name="title" value="${board.title}" readonly>
	</div>
	<div class="form-group">
		<label for="writer">작성자</label>
		<input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
	</div>
	<div class="form-group">
		<label for="registerDate">작성일</label>
		<input type="text" class="form-control" name="registerDate" value="${board.registerDate}" readonly>
	</div>
	<div class="form-group">
		<label for="views">조회수 </label>
		<input type="text" class="form-control" name="views" value="${board.views}" readonly>
	</div>
	<div class="form-group">
		<label for="content">글 내용</label>
		<textarea class="form-control" rows="5" name="content" readonly>${board.content}</textarea>
	</div>
	삭제하시겠습니까?
	<br>
	<br>
	<button type="submit">삭제하기</button>
	<a href="<%=request.getContextPath()%>/board/list">
		<button>게시판 목록</button>
	</a>
</form>