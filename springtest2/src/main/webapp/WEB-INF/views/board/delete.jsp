<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<br>
<h1>�����Ͻðڽ��ϱ�?</h1>
<br>
<form method="post" action="<%=request.getContextPath()%>/board/delete">
	<input type="hidden" name="num" value="${board.num}" readonly>
	<input type="hidden" name="title" value="${board.title}" readonly>
	<input type="hidden" name="content" value="${board.content}">
	<input type="hidden" name="writer" value="${board.writer}" readonly>
	<input type="hidden" name="registerDate" value="${board.registerDate}" readonly>
	<input type="hidden" name="views" value="${board.views}" readonly>
	<input type="hidden" name="up" value="${board.up}" readonly>
	<input type="hidden" name="like" value="${board.like}" readonly>
	<button class="btn btn-danger">�����ϱ�</button>
	<a href="<%=request.getContextPath()%>/board/detail?num=${board.num}">
		<button type="button" class="btn btn-secondary">���� ���</button>
	</a>
</form>

<br>
<br>