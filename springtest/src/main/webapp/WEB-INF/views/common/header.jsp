<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<div class="container">
		<a class="navbar-brand" href="<%=request.getContextPath()%>/">스프링</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="<%=request.getContextPath()%>/board/list">게시판</a>
				</li>
				<c:if test="${user == null}">
					<li class="nav-item">
						<a class="nav-link" href="<%=request.getContextPath()%>/user/signin">Sign in</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="<%=request.getContextPath()%>/user/signup">Sign Up</a>
					</li>
				</c:if>
				<c:if test="${user != null}">
					<li class="nav-item">
						<a class="nav-link" href="<%=request.getContextPath()%>/user/signout">Sign out</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>