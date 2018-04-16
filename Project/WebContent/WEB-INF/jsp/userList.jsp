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

		<h1 class="title-area">ユーザー一覧</h1>
		<div class="userList-area">
			<div class="button-area2">
				<a href="SignUpServlet"><button type="submit"
						class="btn btn-outline-primary btn-md">新規登録</button></a>
			</div>
			<form action="UserListServlet" method="post">
				<div class="login-form-area">
					<div class="row form-group">
						<div class="col-sm-4">
							<label for="inputText" class="col-form-label">ログインID</label>
						</div>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="loginId1"
								id="inputText" placeholder="ログインID">
						</div>
					</div>
					<div class="row form-group">
						<div class="col-sm-4">
							<label for="inputText" class="scol-form-label">ユーザー名</label>
						</div>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="name1"
								id="inputText" placeholder="ユーザー名">
						</div>
					</div>
					<div class="row form-group">
						<div class="col-sm-4">
							<label for="inputDate" class="scol-form-label">生年月日</label>
						</div>
						<div class="col-sm-3">
							<input type="date" class="form-control" name="birthDate1"
								id="inputDate" placeholder="年/月/日">
						</div>
						<div>～</div>
						<div class="col-sm-3">
							<input type="date" class="form-control" name="birthDate2"
								id="inputDate" placeholder="年/月/日">
						</div>
					</div>
				</div>
				<div class="button-area2">
					<button type="submit" class="btn btn-primary btn-md">検索</button>
				</div>
			</form>
		</div>
	</div>

	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ログインID</th>
					<th>ユーザ名</th>
					<th>生年月日</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="buy" items="${userList}">
					<tr>
						<td>${buy.loginId}</td>
						<td>${buy.name}</td>
						<td>${buy.birthDateFmt}</td>
						<td><a class="btn btn-primary"
							href="UserDetailServlet?id=${user.id}">詳細</a> <a
							class="btn btn-success" href="UpDateServlet?id=${user.id}">更新</a>
							<a class="btn btn-danger" href="DeleteServlet?id=${user.id}">削除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>

