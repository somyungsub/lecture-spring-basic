<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: myungsubso
  Date: 2019/11/04
  Time: 12:21 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    UserController와 user view정보를 참조하여 간단한 기능구현 <br>
    Controller와 JSP 를 생성하여 구현. 페이징은 제외<br>
    <table border="1">
        <thead>
            <tr>
                <th>문제</th>
                <th>설명</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1. 초기 JSP 만들기</td>
                <td>적당한 이름의 진입 jsp 파일를 만듭니다. (insert, delete, select 등)</td>
            </tr>
            <tr>
                <td>2. Controller 만들기</td>
                <td>적당한 이름(PracticeController)를 만듭니다.</td>
            </tr>
            <tr>
                <td>3. 기능 구현</td>
                <td> User리스트 (다건조회), 삭제</td>
            </tr>
        </tbody>
    </table>

    <br>
    <form action="">
        <input type="submit" value="Practice UserList 조회">
    </form>

    <table border="1">
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.password}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
