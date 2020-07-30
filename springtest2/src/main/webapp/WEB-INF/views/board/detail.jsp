<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:if test="${board == null}">
	<h1>해당 게시물은 없는 게시글입니다.</h1>
</c:if>
<c:if test="${board != null}">
	<c:if test="${board.isDel == 'Y'.charAt(0)}">
		<h1>삭제된 게시글입니다.</h1>
	</c:if>
	<c:if test="${board.isDel == 'N'.charAt(0)}">
		<div class="form-group">
			<label for="num">번호</label>
			<input type="text" class="form-control" id="num" value="${board.num}" readonly>
		</div>
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" class="form-control" id="title" value="${board.title}" readonly>
		</div>
		<div class="form-group">
			<label for="registerDate">작성</label>
			<input type="text" class="form-control" id="registerDate" value="${board.registerDate}" readonly>
		</div>
		<div class="form-group">
			<label for="views">조회</label>
			<input type="text" class="form-control" id="views" value="${board.views}" readonly>
		</div>
		<div class="form-group">
			<label for="up">UP</label>
			<input type="text" class="form-control" id="up" value="${board.up}" readonly>
		</div>
		<div class="form-group">
			<button type="button" class="btn btn-outline-danger btn-up">UP</button>
		</div>
		<div class="form-group">
			<label for="like">LIKE</label>
			<input type="text" class="form-control" id="like" value="${board.like}" readonly>
		</div>
		<div class="form-group">
			<button type="button" class="btn btn-outline-danger btn-like">LIKE</button>
		</div>
		<div class="form-group">
			<label for="content">내용</label>
			<textarea class="form-control" rows="5" id="content" readonly>${board.content}</textarea>
		</div>
	</c:if>
</c:if>

<script>
	
</script>