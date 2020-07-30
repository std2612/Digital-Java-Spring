<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<br>
<h1>게시판</h1>
<br>
<table class="table table-dark table-hover">
	<thead>
		<tr>
			<th width="8%">번호</th>
			<th width="55%">제목</th>
			<th width="10%">작성자</th>
			<th width="20%">작성일</th>
			<th width="10%">조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${list != null}">
			<c:forEach var="board" items="${list}">
				<tr>
					<td>${board.num}</td>
					<td>
						<a href="<%=request.getContextPath()%>/board/detail?num=${board.num}">${board.title}</a>
					</td>
					<td>${board.writer}</td>
					<td>${board.registerDate}</td>
					<td>${board.views}</td>
				</tr>
			</c:forEach>
			<c:if test="${list == null || list.size() == 0}">
				<tr>
					<td colspan="5">등록된 게시글이 없습니다</td>
				</tr>
			</c:if>
		</c:if>
	</tbody>
</table>
<a href="<%=request.getContextPath()%>/board/register">
	<button type="button" class="btn btn-danger">글쓰기</button>
</a>
<br>
<ul class="pagination justify-content-center">
	<li class="page-item <c:if test="${!pm.prev}">disabled</c:if>">
		<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}&search=${pm.cri.search}&type=${pm.cri.type}">Previous</a>
	</li>
	<c:forEach var="index" begin="${pm.startPage}" end="${pm.endPage}">
		<li class="page-item <c:if test="${pm.cri.page == index}">active</c:if>">
			<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${index}&search=${pm.cri.search}&type=${pm.cri.type}">${index}</a>
		</li>
	</c:forEach>
	<li class="page-item <c:if test="${!pm.next}">disabled</c:if>">
		<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}&search=${pm.cri.search}&type=${pm.cri.type}">Next</a>
	</li>
</ul>

<form action="<%=request.getContextPath()%>/board/list">
	<div class="input-group mb-3">
		<select class="form-control" id="sel1" name="type">

			<option value="0" <c:if test="${pm.cri.type == 0}">selected</c:if>>전체</option>
			<option value="1" <c:if test="${pm.cri.type == 1}">selected</c:if>>작성자</option>
			<option value="2" <c:if test="${pm.cri.type == 2}">selected</c:if>>제목</option>
			<option value="3" <c:if test="${pm.cri.type == 3}">selected</c:if>>내용</option>
		</select>
		<input type="text" class="form-control" placeholder="Search" name="search" value="${pm.cri.search}">
		<div class="input-group-append">
			<button class="btn btn-success" type="submit">Go</button>
		</div>
	</div>
</form>
