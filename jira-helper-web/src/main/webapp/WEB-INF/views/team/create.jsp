<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
<s:url value="/css/default.css" var="css"/>
<link rel="stylesheet" type="text/css"
	href="${css}" />
</head>
<body>
	<div id="createTeam" class="content">
		<p class="header">
			<s:message code="createTeamIntroduction" />
		</p>
		<form method="POST" >
			<label for="teamTitle"><s:message code="teamTitleLabel" /></label>
			<input id="teamTitle" name="title" type="text" required="required" /> 
			<label for="teamDescription"><s:message code="teamDescriptionLabel" /></label> 
			<textarea id="teamDescription" name="description"  ></textarea> 
			<input type="submit">
		</form>
	</div>
</body>
</html>
