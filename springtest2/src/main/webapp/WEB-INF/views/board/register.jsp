<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<br>
<h1>�۾���</h1>
<br>
<form method="post" action="<%=request.getContextPath()%>/board/register">
	<div class="form-group">
		<label for="title">�� ����</label>
		<input type="text" class="form-control" name="title" value="${board.title}">
	</div>
	<div class="form-group">
		<label for="writer">�ۼ���</label>
		<input type="text" class="form-control" name="writer" value="${user.id}" readonly>
	</div>
	<div class="form-group">
		<label for="content">�� ����</label>
		<textarea class="form-control" rows="5" name="content">${board.content}</textarea>
	</div>
	<button class="btn btn-success">�ۼ� �Ϸ�</button>
</form>