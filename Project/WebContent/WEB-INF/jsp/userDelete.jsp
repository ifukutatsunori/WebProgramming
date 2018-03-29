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
		<c:forEach var="user" items="${userList}">
			<h1 class="title-area">ユーザー削除確認</h1>

			<div>
				<h3>ログインID：${user.loginId}</h3>
			</div>
			<div>
				<h3>を本当に削除してもよろしいでしょうか。</h3>
			</div>

			<div class="select-button-area">
				<a href="UserListServlet"><button type="submit"
						class="btn btn-outline-secondary">キャンセル</button></a>
				<form action="DeleteServlet" method="post">
					<input type="hidden" name="deleteId" value="${user.id}">
					<button type="submit" class="btn btn-outline-dark" name="deleteId">OK</button>
					<div></div>
				</form>
			</div>
		</c:forEach>
	</div>
</body>
</html>
