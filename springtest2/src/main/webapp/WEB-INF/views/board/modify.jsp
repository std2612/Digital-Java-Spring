<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<form method="post" action="<%=request.getContextPath()%>/board/modify">
	<div class="form-group">
		<label for="writer">�ۼ���</label>
		<input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
	</div>
	<div class="form-group">
		<label for="title">�� ����</label>
		<input type="text" class="form-control" name="title" value="${board.title}">
	</div>
	<div class="form-group">
		<label for="content">�� ����</label>
		<textarea class="form-control" rows="5" name="content">${board.content}</textarea>
	</div>
	<button class="btn btn-success">���� �Ϸ�</button>
	<input type="hidden" name="num" value="${board.num}" readonly>
	<input type="hidden" name="writer" value="${board.writer}" readonly>
	<input type="hidden" name="registerDate" value="${board.registerDate}" readonly>
	<input type="hidden" name="views" value="${board.views}" readonly>
	<input type="hidden" name="up" value="${board.up}" readonly>
	<input type="hidden" name="like" value="${board.like}" readonly>
</form>