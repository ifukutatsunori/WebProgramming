<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<title>文書のタイトル</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/common.css">

</head>
<body>

<div class="container">



 		<h1 class="title-area">ログイン画面</h1>

 		<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>

 <form class="form-signin" action="LoginServlet" method="post">
          <span id="reauth-email" class="reauth-email"></span>
    	<div class="login-form-area">

	      <div class="row form-group">
	         <div  class="col-sm-4">
	           <label for="inputPassword" class="col-form-label">ログインID</label>

	         </div>

	        <div  class="col-sm-8">
	         <input type="text" name="loginId" id="inputLoginId" class="form-control" placeholder="ログインID" required autofocus>

	        </div>
	        </div>

	      <div class="row form-group">
	         <div  class="col-sm-4">
	           <label for="inputPassword" class="scol-form-label">パスワード</label>

	         </div>

	        <div  class="col-sm-8">
	         <input type="password" name="password" id="inputPassword" class="form-control" placeholder="パスワード" required>

	        </div>
	      </div>
		<div class="button-area3">
	      <button type="submit" class="btn3 btn-primary btn-md button-area">ログイン</button>
		</div>
	    </div>
	    </form>
    </div>

</body>
</html>
