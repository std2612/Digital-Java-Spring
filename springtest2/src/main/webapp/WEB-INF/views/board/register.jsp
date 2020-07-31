<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<br>
<h1>글쓰기</h1>
<br>
<form method="post" action="<%=request.getContextPath()%>/board/register">
	<div class="form-group">
		<label for="title">글 제목</label>
		<input type="text" class="form-control" name="title" value="${board.title}">
	</div>
	<div class="form-group">
		<label for="writer">작성자</label>
		<input type="text" class="form-control" name="writer" value="${user.id}" readonly>
	</div>
	<div class="form-group">
		<label for="content">글 내용</label>
		<textarea class="form-control" rows="5" name="content">${board.content}</textarea>
	</div>
	<button class="btn btn-success">작성 완료</button>
</form>