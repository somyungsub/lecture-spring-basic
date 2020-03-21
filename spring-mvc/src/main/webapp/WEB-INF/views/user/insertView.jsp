<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

insert 확인<br/>
<form action="insertUser.do" method="post">
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
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="password"></td>
            </tr>
        </tbody>
    </table>
    <br>
    <input type="submit" value="추가하기">
</form>

<a href="/egov"> 첫 화면 </a>

</body>
</html>
