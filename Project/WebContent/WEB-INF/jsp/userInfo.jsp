<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>文書のタイトル</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/common.css">

</head>
<header>

	<div class="alert alert-dark" role="alert">

		<div class="header-area">
			<ul class="nav navbar-nav navbar-right">
				<li class="navbar-text"><h4>${userInfo.name}さん</h4></li>
				<li class="dropdown"><a href="LogoutServlet"
					class="navbar-link logout-link"><button type="submit"
							class="btn btn-outline-danger">ログアウト</button></a></li>
			</ul>
		</div>
	</div>
</header>
<body>

	<div class="container">


		<h1 class="title-area">ユーザー情報詳細参照</h1>

		<c:forEach var="user" items="${userList}">
			<div class="login-form-area">

				<div class="row form-group">

					<div class="col-sm-4">
						<label for="inputPassword" class="col-form-label">ログインID</label>
					</div>
					<div class="col-sm-8">${user.loginId}</div>
				</div>
				<div class="row form-group">
					<div class="col-sm-4">
						<label for="inputPassword" class="scol-form-label">ユーザー名</label>
					</div>
					<div class="col-sm-8">${user.name}</div>
				</div>
				<div class="login-form-area">
					<div class="row form-group">
						<div class="col-sm-4">
							<label for="inputPassword" class="col-form-label">生年月日</label>
						</div>
						<div class="col-sm-8">${user.birthDate}</div>
					</div>
					<div class="row form-group">
						<div class="col-sm-4">
							<label for="inputPassword" class="col-form-label">登録日時</label>
						</div>
						<div class="col-sm-8">${user.createDate}</div>
					</div>
					<div class="row form-group">
						<div class="col-sm-4">
							<label for="inputPassword" class="col-form-label">更新日時</label>
						</div>
						<div class="col-sm-8">${user.updateDate}</div>
					</div>
				</div>
				<a href="UserListServlet">
					<button type="button" class="btn-return btn-link">戻る</button>
				</a>
			</div>

		</c:forEach>
	</div>

</body>
</html>
