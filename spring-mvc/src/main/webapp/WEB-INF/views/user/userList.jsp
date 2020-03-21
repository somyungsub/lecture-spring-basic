<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .btn {
        color: coral;
        font-weight: bold;
        font-size: x-large;
        cursor: pointer;
    }
</style>
<body>
User 관련 테스트 페이지 <br/>
${msg}

<form id="userListForm">
    <input type="hidden" id="id" name="id">
    <table border="1" style="color : black;">
        <thead>
            <tr style="color: red;">
                <th>ID</th>
                <th>NAME</th>
                <th>PASSWORD</th>
                <th>삭제기능</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td><span name="userId">${user.id}</span></td>
                <td>${user.name}</td>
                <td>${user.password}</td>
                <td><input type="button" value="삭제" class="btn" onclick="deleteUser('${user.id}')"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <input type="button" value="추가" onclick="insertUser()" class="btn">
</form>

<a href="/egov"> 첫 화면 </a>
</body>
<script type="application/javascript">
  var names = document.getElementsByName("userId");

  names.forEach(function (value) {
    value.setAttribute("style", "cursor:pointer; color:green;");
    value.addEventListener("click", function (e) {
      var form = document.getElementById("userListForm");
      var id = document.getElementById("id");
      id.value = e.target.innerText;
      form.action = 'selectUserOne.do';
      form.method = 'post';
      form.submit();
    });
  });

  function deleteUser(userId) {
    var form = document.getElementById("userListForm");
    var id = document.getElementById("id");
    id.value = userId;
    form.action = 'deleteUser.do';
    form.method = 'post';
    form.submit();
  }

  function insertUser() {
    var form = document.getElementById("userListForm");
    form.action = 'insertView.do';
    form.method = 'post';
    form.submit();
  }


</script>
</html>
