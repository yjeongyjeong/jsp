<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <h2>LOGIN FORM</h2>
  <form action="login.do" name="frm" method="post">
    <div class="form-group">
      <label for="userid">User user Id : </label>
      <input type="text" class="form-control" id="userid" placeholder="Enter user Id" name="userid">
    </div>
    <div class="form-group">
      <label for="pwd">User Password : </label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>
    <div class="form-group form-check">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember"> Remember me
      </label>
    </div>
    <button type="submit" class="btn btn-outline-warning">Login</button>
    <button type="reset" class="btn btn-outline-dark">Cancel</button>
    <button type="button" class="btn btn-outline-danger" onclick="location.href='adminMode.do'">Admin Mode</button>
  </form>
  
  <hr>
  <h6 style="font-style: italic;">${message}</h6>
</div>
</body>
</html>