<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Member Management</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>

<div class="container">
    <h2>Member Registration</h2>

    <div class="form-card">
        <form action="all" method="post">
            <div class="input-group">
                <label for="name">Name</label>
                <input type="text" id="name" name="name" placeholder="이름을 입력하세요" required>
            </div>

            <div class="input-group">
                <label for="age">Age</label>
                <input type="number" id="age" name="age" placeholder="나이를 입력하세요" required>
            </div>

            <button type="submit" class="btn-submit">Add Member</button>
        </form>
    </div>

    <div class="nav-section">
        <button class="btn-secondary" onclick="location.href='all'">View All Members</button>
    </div>
</div>

</body>
</html>