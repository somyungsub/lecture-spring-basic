<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}
<br/>
조회 결과!
<table border="1" style="color : black;">
    <tr>
        <td>id</td><td>${user.id}</td>
    </tr>
    <tr>
        <td>name</td><td>${user.name}</td>
    </tr>
    <tr>
        <td>password</td><td>${user.password}</td>
    </tr>

</table>
<form id="userForm" name="userForm">
    <input type="hidden" name="id" value="${user.id}">
    <input type="hidden" name="name" value="${user.name}">
    <input type="hidden" name="password" value="${user.password}">
    <input type="button" value="수정" onclick="userUpdate()"/>
    <input type="button" value="목록" onclick="userList()"/>
</form>
<a href="/egov"> 첫 화면 </a>
<script>
  function userList() {
    var userForm = document.getElementById("userForm");
    userForm.action = "selectUserList.do";
    userForm.method = "post";
    userForm.submit();
  }

  function userUpdate() {
    var userForm = document.getElementById("userForm");
    userForm.action = "updateView.do";
    userForm.method = "post";
    userForm.submit();
  }
</script>
</body>
</html>
