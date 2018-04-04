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


		<h1 class="title-area">ユーザー情報更新</h1>

		<form action="UpDateServlet" method="post">

			<c:forEach var="user" items="${userList}">
				<c:if test="${errMsg != null}">
					<div class="alert alert-danger" role="alert">${errMsg}</div>
				</c:if>


				<div class="login-form-area">
					<div class="row form-group">
						<div class="col-sm-4">
							<input type="hidden" name="id" value="${user.id}"> <input
								type="hidden" name="updateDate" value="now()"> <label
								for="inputPassword" class="col-form-label">ログインID</label>
						</div>
						<div class="col-sm-8">${user.loginId}</div>
					</div>
					<div class="row form-group">
						<div class="col-sm-4">
							<label for="inputPassword" class="scol-form-label">パスワード</label>
						</div>
						<div class="col-sm-8">
							<input type="password" class="form-control" name="password"
								id="inputPassword" placeholder="">
						</div>
					</div>
					<div class="login-form-area">
						<div class="row form-group">
							<div class="col-sm-4">
								<label for="inputPassword" class="col-form-label">パスワード確認</label>
							</div>
							<div class="col-sm-8">
								<input type="password" class="form-control"
									name="passwordConfirm" id="inputPassword" placeholder="">
							</div>
						</div>
						<div class="row form-group">
							<div class="col-sm-4">
								<label for="inputText" class="col-form-label">ユーザー名</label>
							</div>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="name"
									id="inputText" value="${user.name}">
							</div>
						</div>
						<div class="row form-group">
							<div class="col-sm-4">
								<label for="inputDate" class="col-form-label">生年月日</label>
							</div>
							<div class="col-sm-8">
								<input type="date" class="form-control" name="birthDate"
									id="inputDate" value="${user.birthDate}">
							</div>
						</div>

						<button type="submit" class="btn btn-primary btn-md button-area">
							更新</button>

					</div>
					<a href="UserListServlet"><button type="button"
							class="btn-return btn-link">戻る</button></a>
				</div>
			</c:forEach>
		</form>
	</div>
</body>
</html>
