<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
<s:url value="/css/default.css" var="css"/>
<link rel="stylesheet" type="text/css" href="${css}" />
</head>
<body>
	<div id="create" class="content">
		<p class="header">
			<s:message code="createIntroduction" />
		</p>
		<form method="POST">
			<label for="username"><s:message code="usernameLabel" /></label>
			<input id="username" name="username" type="text" required="required" /> 
			<label for="name"><s:message code="nameLabel" /></label> 
			<input id="name" name="name" type="text" /> 
			<label for="emailAddress"><s:message code="emailAddressLabel" /></label> 
			<input id="emailAddress" name="emailAddress" type="email" /> 
			<input type="submit">
		</form>
	</div>
</body>
</html>
