<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h1> - Edit Page - </h1>
<form action="edit-user" method="post">
    <div class="info-wrap">
        <div class="info-row">
            <div>ID.</div>
            <div>${sessionScope.user.id}</div>
        </div>
        <div class="info-row">
            <div>PW.</div>
            <div><input type="text" name="pw" value="${sessionScope.user.pw}"></div>
        </div>
        <div class="info-row">
            <div>NAME.</div>
            <div><input type="text" name="name" value="${sessionScope.user.name}"></div>
        </div>


        <div>
            <button class="movie-btn" name="id" value="${sessionScope.user.id}">done</button>

            <button class="movie-btn" onclick="history.back()" type="button">cancel</button>


        </div>


    </div>
</form>

</body>
</html>
