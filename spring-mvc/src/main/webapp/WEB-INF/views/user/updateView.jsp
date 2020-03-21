<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Update 확인<br/>
<form action="updateUser.do" method="post">
    <table>
        <thead>
            <tr>
              <td>컬럼</td>
              <td>값</td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>ID</td>
                <td><input type="text" readonly="readonly" name="id" value="${userVO.id}" style="background-color: gray"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"  value="${userVO.name}"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="password" value="${userVO.password}"></td>
            </tr>
        </tbody>
    </table>
    <input type="submit" value="수정하기">
</form>

<a href="/egov"> 첫 화면 </a>

</body>
</html>
