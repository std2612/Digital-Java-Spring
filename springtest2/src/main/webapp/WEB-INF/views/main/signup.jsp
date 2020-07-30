<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<br>
<h1>회원가입</h1>
<form method="post" action="<%=request.getContextPath()%>/signup">
    <div class="form-group">
        <label for="id">아이디</label>
        <input type="text" class="form-control" id="id" placeholder="아이디">
    </div>
    <div class="form-group">
        <label for="pw">비밀번호</label>
        <input type="password" class="form-control" id="pw" placeholder="비밀번호">
    </div>
    <div class="form-group">
        <label for="pw">비밀번호 확인</label>
        <input type="password" class="form-control" id="pw2" placeholder="비밀번호 확인">
    </div>
    <div class="form-group">
        <label for="gender">성별</label>
        <select class="form-control" id="gender">
            <option>성별</option>
            <option>남성</option>
            <option>여성</option>
        </select>
    </div>
    <div class="form-group">
        <label for="email">이메일</label>
        <input type="email" class="form-control" id="email" placeholder="이메일">
    </div>
    <button class="btn btn-success">가입하기</button>
    <a href="<%=request.getContextPath()%>/">
    	<button type="button" class="btn btn-danger">가입 취소</button>
    </a>
</form>

<script>
    $(function () {
        $('#id').keyup(function () {
            var id = (this).val();
            if (id.length >= 4) {
                $ajax({
                    async: true,
                    type: 'POST',
                    data: id,
                    url: "<%=request.getContextPath()%>/idCheck",
                    dataType: "json",
                    contentType: "application/json; charset=UTF-8",
                    success: function (data) {
                        var str;
                        if (data['res']) {
                            str = '<p style="color:green;">사용 가능한 아아디입니다.</p>'
                        } else {
                            str = '<p style="color:red;">이미 가입되있거나 탈퇴한 아이디입니다.</p>'
                        }
                        $('#id-error').html(str);
                    }
                });
            }
        });
    });
</script>