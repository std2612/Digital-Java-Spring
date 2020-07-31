<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<br>
<h1>로그인</h1>
<br>
<form method="post" action="<%=request.getContextPath()%>/signin">
	<div class="form-group">
		<label for="id">아이디</label>
		<input type="text" class="form-control" name="id" id="id" placeholder="아이디">
	</div>
	<div class="form-group">
		<label for="id">비밀번호</label>
		<input type="password" class="form-control" name="pw" id="pw" placeholder="비밀번호">
	</div>
	<button class="btn btn-success">로그인</button>
</form>