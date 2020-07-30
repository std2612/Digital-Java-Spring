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

<button type="button" class="btn btn-danger">
	<a href="<%=  %>">글쓰기</a>
</button>
<br>