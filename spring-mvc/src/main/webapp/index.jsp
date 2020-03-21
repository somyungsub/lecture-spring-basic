<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
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
Hello~~@ Spring MVC <br/>
세션 정보 : ${sessionUser}<br/>
<p>============= 1. 예제 및 실습 =============</p>
<table border="1">
    <thead>
    <tr style="color: red">
        <th>Mapping</th>
        <th>내용</th>
        <th>실행</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td rowspan="17">RequestMapping</td>
        <td>method 속성 (get)</td>
        <td>
            <form action="hello.do" method="get">
                <input type="submit" value="helloGet" class="btn"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>method 속성 (post)</td>
        <td>
            <form action="hello.do" method="post">
                <input type="submit" value="helloPost" class="btn"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>@RequestParam 사용 (속성)</td>
        <td>
            <form action="helloRequestParam.do" method="get">
                msg : <input type="text" name="msg"/>
                msg2 : <input type="text" name="msg2"/>
                <input type="submit" value="helloGetRequestParam" class="btn"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>@RequestParam 사용 (생략)</td>
        <td>
            <form action="helloRequestParamDefault.do" method="get">
                id : <input type="text" name="id"/>
                name : <input type="text" name="name"/>
                password : <input type="text" name="password"/>
                <input type="submit" value="hellRequest" class="btn"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>@ModelAttribute 사용 (param 설정)</td>
        <td>
            <form action="helloModelAttributeParam.do" method="get">
                id : <input type="text" name="id"/>
                name : <input type="text" name="name"/>
                password : <input type="text" name="password"/>
                <input type="submit" value="helloModelAttributeParam" class="btn"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>@ModelAttribute 사용 (param 생략)</td>
        <td>
            <form action="helloModelAttributeSkip.do" method="get">
                id : <input type="text" name="id"/>
                name : <input type="text" name="name"/>
                password : <input type="text" name="password"/>
                <input type="submit" value="helloModelAttributeMethod" class="btn"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>@ModelAttribute 사용 (param 생략, default 1)</td>
        <td>
            <form action="helloModelAttributeDefault.do" method="get">
                id : <input type="text" name="id"/>
                name : <input type="text" name="name"/>
                password : <input type="text" name="password"/>
                <input type="submit" value="helloModelAttributeDefault" class="btn"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>@ModelAttribute 사용 (param 생략, default 2)</td>
        <td>
            <form action="helloModelAttributeDefault2.do" method="get">
                id : <input type="text" name="id"/>
                name : <input type="text" name="name"/>
                password : <input type="text" name="password"/>
                <input type="submit" value="helloModelAttributeDefault2" class="btn"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>@SessionAttributes 사용 (생성)</td>
        <td>
            <form action="helloSession.do" method="get">
                <input type="submit" value="helloSession" class="btn"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>@SessionAttributes 사용 (수정)</td>
        <td>
            <form action="helloSessionUpdate.do" method="get">
                id : <input type="text" name="id"/>
                name : <input type="text" name="name"/>
                password : <input type="text" name="password"/>
                <input type="submit" value="helloSessionUpdate" class="btn"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>@SessionAttributes 사용 (삭제)</td>
        <td>
            <form action="helloSessionLogOut.do" method="get">
                <input type="submit" value="helloSessionLogOut" class="btn"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>Return 종류 사용 (Map)</td>
        <td>
            <form action="helloReturnMap.do" method="get">
                <input type="submit" value="helloReturnMap" class="btn"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>Return 종류 사용 (ModelAndView)</td>
        <td>
            <form action="helloReturnMav.do" method="get">
                id : <input type="text" name="id"/>
                name : <input type="text" name="name"/>
                password : <input type="text" name="password"/>
                <input type="submit" value="helloReturnModelAndView" class="btn"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>Return 종류 사용 (void)</td>
        <td>
            <form action="helloReturnVoid.do" method="get">
                id : <input type="text" name="id"/>
                name : <input type="text" name="name"/>
                password : <input type="text" name="password"/>
                <input type="submit" value="helloReturnVoid" class="btn"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>Return 종류 사용 (void)</td>
        <td>
            <form action="helloReturnVO.do" method="get">
                id : <input type="text" name="id"/>
                name : <input type="text" name="name"/>
                password : <input type="text" name="password"/>
                <input type="submit" value="helloReturnVO" class="btn"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>ExceptionHandler 사용</td>
        <td>
            <form action="helloError.do" method="get">
                <input type="submit" value="error" class="btn"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>@PathVariable</td>
        <td>
            <form action="user/selectUserOne.do" method="post">
                <input type="hidden" name="id" value="10">
                <input type="submit" value="userSelectOne" class="btn"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>BeanNameMapping</td>
        <td>Controller 인터페이스 구현 기반</td>
        <td>
            <form action="implController.do" method="post">
                <input type="submit" value="implController" class="btn"/>
            </form>
        </td>
    </tr>

    <tr>
        <td rowspan="5" style="color: brown">UserController 실습</td>
        <td>UserList (다건 조회)</td>
        <td>
            <form action="user/selectUserList.do" method="post">
                <input type="submit" value="userSelectList" class="btn"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>데이터 초기화</td>
        <td>
            <form action="user/setupData.do" method="post">
                <input type="submit" value="setupData" class="btn"/>
            </form>
        </td>
    </tr>

    <tr>
        <td>간단한 기능 구현</td>
        <td>
            <form action="practice.do" method="post">
                <input type="submit" value="Practice" class="btn"/>
            </form>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
