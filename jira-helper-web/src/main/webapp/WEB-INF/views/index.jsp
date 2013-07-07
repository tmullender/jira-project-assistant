<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
<s:url value="/css/default.css" var="css"/>
<link rel="stylesheet" type="text/css" href="${css}" />
</head>
<body>
	<s:url var="login" value="/do/login" />
	<s:url var="create" value="/do/user/create" />
	<s:url var="support" value="/do/support" />
	<div id="welcome" class="content">
		<p id="welcomeHeader" class="header">
			<s:message code="welcomeHeader" />
		</p>
		<label for="welcomeOptions" class="options"><s:message code="welcomeOptionsLabel" /></label>
		<ul id="welcomeOptions" class="options">
			<li class="option login">
				<a class="option-link" href="${login}">
					<span><s:message code="login" /></span>
				</a>
			</li>
			<li class="option register">
				<a class="option-link" href="${create}">
					<span><s:message code="register" /></span>
				</a>
			</li>
			<li class="option support">
				<a class="option-link" href="${support}">
					<span><s:message code="support" /></span>
				</a>
			</li>
			<li class="option random">
				<a class="option-link" href="http://www.randomwebsite.com/cgi-bin/random.pl">
					<span><s:message code="random" /></span>
				</a>
			</li>
		</ul>
	</div>
</body>
</html>
