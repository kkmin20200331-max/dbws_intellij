<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="member.css">
    <script>
        function deleteMember(id) {
            let ok = confirm("really?")
            if (ok) {
                location.href = 'member-c?id=' + id;
            }
        }

        function updateMember(name, id) {
            let edit = prompt('edit?', name)
            
            if (edit != null && edit != "") {
                location.href = 'udc?edit=' + edit + '&id=' + id;
            }
        }
    </script>
</head>
<body>
<%--<button onclick = "location.href='index.jsp'">돌아가기</button>--%>
<div class="container">
    <h2>Member List</h2>
    <table class="member-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${members}" var="member">
            <tr>
                <td>${member.id}</td>
                <td><span onclick="updateMember('${member.name}','${member.id}')"> ${member.name}</span></td>
                <td>${member.age}
                    <button onclick="deleteMember(${member.id})">del</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>
