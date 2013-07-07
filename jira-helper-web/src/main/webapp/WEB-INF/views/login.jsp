<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
<s:url value="/css/default.css" var="css"/>
<link rel="stylesheet" type="text/css"
	href="${css}" />
</head>
<body>
	<div id="login" class="content">
		<p class="header">
			<s:message code="loginIntroduction" />
		</p>
		<s:url value="/j_spring_security_check" var="login"/>
		<form method="POST" action="${login}">
			<label for="j_username"><s:message code="usernameLabel" /></label>
			<input id="j_username" name="j_username" type="text" required="required" /> 
			<label for="j_password"><s:message code="passwordLabel" /></label>
			<input id="j_password" name="j_password" type="password" required="required" />
			<input type="submit">
		</form>
	</div>
</body>
</html>