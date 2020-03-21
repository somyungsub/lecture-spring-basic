<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Hello~~ Return VO ! <br/><br/>
========= MSG =========<br/>
${msg}
<br/>
${msg2}
<br/><br/>
========= 1 user =========<br/>
${user.id}<br/>
${user.name}<br/>
${user.password}<br/><br/>

========= 2 userVO =========<br/>
${userVO.id}<br/>
${userVO.name}<br/>
${userVO.password}<br/><br/>


<a href="/egov"> 첫 화면 </a>

</body>
</html>
