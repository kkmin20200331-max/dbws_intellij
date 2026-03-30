<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="review-container">
    <div>
        <div class="review-title">
            Review Page <a href="review-add">[write]</a>
        </div>
        <c:forEach var="r" items="${reviews}">
            <div class="review-row">
                <div>
                    <span onclick="location.href='review-detail?no=${r.no}'">${r.title }</span>
                </div>
                <div>${r.date }</div>
            </div>
        </c:forEach>
    </div>
</div>


<div>
    <c:choose>
        <c:when test="${currentPage==1}">
            <button class="movie-btn pn shake">prev</button>
        </c:when>
        <c:otherwise>
            <button class="movie-btn pn" onclick="location.href='review?p=${currentPage-1}'">prev</button>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${totalPage != currentPage }">
            <button class="movie-btn pn" onclick="location.href='review?p=${currentPage+1}'">next</button>
        </c:when>
        <c:otherwise>
            <button class="movie-btn pn shake">next</button>
        </c:otherwise>
    </c:choose>
</div>
</div>



<div>
    <a href="review">[start]</a>
    <c:forEach begin="1" end="${totalPage}"  var="i">
        <c:choose>
            <c:when test="${i==currentPage}">
                <a href="review?p=${i}" style="color: red">[${i}]</a>
            </c:when>
            <c:otherwise>
                <a href="review?p=${i}">[${i}]</a>
            </c:otherwise>
        </c:choose>


    </c:forEach>
    <a href="review?p=${totalPage}">[end]</a>
</div>
</body>
</html>
