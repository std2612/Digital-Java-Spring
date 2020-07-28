<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<br>
<h1>
	<a href="<%=request.getContextPath()%>/board/list">게시판</a>
</h1>
<br>
<table class="table table-striped">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${list.size() != 0}">
			<c:forEach var="board" items="${list}">
				<tr>
					<td>${board.num}</td>
					<td><a
						href="<%=request.getContextPath()%>/board/detail?num=${board.num}&page=${pm.cri.page}&type=${pm.cri.type}&search=${pm.cri.search}">
							${board.title} </a></td>
					<td>${board.writer}</td>
					<td>${board.registerDate}</td>
					<td>${board.views}</td>
				</tr>
			</c:forEach>
		</c:if>

		<c:if test="${list.size() == 0}">
			<tr>
				<td colspan="5">등록된 게시글이 없습니다.</td>
			</tr>
		</c:if>
	</tbody>
</table>
<a href="<%=request.getContextPath()%>/board/list"><button>게시판
		목록</button></a>
<c:if test="${user != null}">
	<a href="<%=request.getContextPath()%>/board/register"><button>글쓰기</button></a>
</c:if>
<br>
<br>

<ul class="pagination justify-content-center">
	<li class="page-item <c:if test="${!pm.prev}">disabled</c:if>"><a
		class="page-link"
		href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}&type=${pm.cri.type}&search=${pm.cri.search}">
			<i class="fas fa-angle-double-left"></i>
	</a></li>

	<li class="page-item <c:if test="${pm.cri.page == 1}">disabled</c:if>">
		<a class="page-link"
		href="<%=request.getContextPath()%>/board/list?page=${pm.cri.page-1}&type=${pm.cri.type}&search=${pm.cri.search}">
			<i class="fas fa-chevron-left"></i>
	</a>
	</li>

	<c:forEach var="index" begin="${pm.startPage}" end="${pm.endPage}">
		<li
			class="page-item <c:if test="${pm.cri.page == index}">active</c:if>">
			<a class="page-link"
			href="<%=request.getContextPath()%>/board/list?page=${index}&type=${pm.cri.type}&search=${pm.cri.search}">
				${index} </a>
		</li>
	</c:forEach>

	<li
		class="page-item <c:if test="${pm.cri.page == pm.lastEndPage}">disabled</c:if>">
		<a class="page-link"
		href="<%=request.getContextPath()%>/board/list?page=${pm.cri.page+1}&type=${pm.cri.type}&search=${pm.cri.search}">
			<i class="fas fa-chevron-right"></i>
	</a>
	</li>

	<li class="page-item <c:if test="${!pm.next}">disabled</c:if>"><a
		class="page-link"
		href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}&type=${pm.cri.type}&search=${pm.cri.search}">
			<i class="fas fa-angle-double-right"></i>
	</a></li>
</ul>

<form>
	<div class="input-group mb-3">
		<select class="form-control" id="sel1" name="type">
			<option value="0" <c:if test="${pm.cri.type==0}">selected</c:if>>전체</option>
			<option value="1" <c:if test="${pm.cri.type==1}">selected</c:if>>작성자</option>
			<option value="2" <c:if test="${pm.cri.type==2}">selected</c:if>>제목</option>
			<option value="3" <c:if test="${pm.cri.type==3}">selected</c:if>>내용</option>
		</select> <input type="text" class="form-control search" placeholder="검색"
			name="search" value="${pm.cri.search}">
		<div class="input-group-append">
			<button class="btn btn-success" type="submit">검색</button>
		</div>
	</div>
</form>

<input type="hidden" value="${isRegister}" id="isRegister">
<input type="hidden" value="${isModify}" id="isModify">
<input type="hidden" value="${isDelete}" id="isDelete">
<script>
	$(function() {
		var isRegister = $('#isRegister').val();
		if (isRegister == "true") {
			alert("게시글이 등록되었습니다.");
		}
		var isModify = $('#isModify').val();
		if (isModify == "true") {
			alert("게시글이 수정되었습니다.");
		}
		var isDelete = $('#isDelete').val();
		if (isDelete == "true") {
			alert("게시글이 삭제되었습니다.");
		}
	});
</script>