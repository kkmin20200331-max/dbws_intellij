<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Restaurant List</title>
    <link rel="stylesheet" href="res.css">
    <script>
        function delRes(nooo) {
            let ok = confirm("really??");
            if (ok) {
                location.href = "DC?no="+nooo;
            }
        }
        function updateRes(nooo,naaame){
         let change =   prompt("really??",naaame);
            if (change!=null && change != "") {
                location.href = "UC?no="+nooo +"&name="+change;
            }
        }
    </script>
</head>
<body>

<div class="container">
    <h2>Restaurant List</h2>

<div class="add-res">
    <form action="CRC" method="post" enctype="multipart/form-data">
    Restaurant : <input type="text" name="name" required> <br>
    Place : <input type="text" name="place" required> <br>
    Img : <input type="file" name="img"> <br>
        <button>add</button>
    </form>
</div>

    <div class="card-grid">
        <c:forEach items="${restaurants}" var="res">
            <div class="card" style="position: relative">
                <button style="position: absolute; bottom: 0; right: 10px" onclick="updateRes('${res.no}','${res.name}')">edit</button>
                <div class="card-image" style="position:relative">
<%--                    <c:if test="${res.img eq 'defaultimg.jpg'}">--%>
<%--                        <img src="staticResource/${res.img}">--%>
<%--                    </c:if>--%>
                    <img src="./imgFile/${res.img}" >
                    <button style="position: absolute; top:0;right:0;" onclick="delRes('${res.no}')">del</button>
                </div>

                <div class="card-content">
                    <h3 class="res-name">${res.name}</h3>
                    <p class="res-place">
                        <i class="location-icon">📍</i> ${res.place}
                    </p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>