<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> - My Page - </h1>
<div class="info-wrap">
  <div class="info-row">
    <div>ID.</div>
    <div>${sessionScope.user.id}</div>
  </div>
  <div class="info-row">
    <div>PW.</div>
    <div>${sessionScope.user.pw}</div>
  </div>
  <div class="info-row">
    <div>NAME.</div>
    <div>${sessionScope.user.name}</div>
  </div>


  <div>
    <button class="movie-btn" onclick="location.href='edit-user'">edit</button>


    <button class="movie-btn" onclick="delUser('${sessionScope.user.pw}')">delete</button>
    <div class="confirm" style="display: none">
      your every data will be gone. are you sure?<br>
      <form action="del-user" method="post">
        <input type="password" name="pw">
        <button class="movie-btn conf">confirm</button>
      </form>
    </div>
  </div>


</div>


</body>
<script>
  function delUser(pw){
    // let ok = prompt("What is your password?","password");
    // if (pw == ok){
    //   location.href = "del-user?pw="+pw;
    // }
document.querySelector('.confirm').style.display = 'block';

  }
</script>
</html>
