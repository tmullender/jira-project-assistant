<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<s:url value="/css/default.css" var="css"/>
<link rel="stylesheet" type="text/css" href="${css}" />
</head>
<body>
	<s:url var="logout" value="/do/logout" />
	<div id="home" class="content">
		<p id="homeHeader" class="header">
			<s:message code="homeHeader" />
		</p>
		<label for="projectOptions" class="options"><s:message code="projectOptionsLabel" /></label>
		<ul id="projectOptions" class="options">
		<s:url var="projectUrl" value="/do/project" />
		<c:forEach var="project" items="${projects}">
			<li class="option">
				<a class="option-link" href="${projectUrl}/${project.key}" >
					<span><s:message code="${project.title}" text="${project.title}" /></span>
				</a>
			</li>
		</c:forEach>
		</ul>
		<label for="teamOptions" class="options"><s:message code="teamOptionsLabel" /></label>
		<s:url var="createTeamUrl" value="/do/team/create" />
		<a class="create team" href="${createTeamUrl}"><span><s:message code="createTeamLink" /></span></a>
		<ul id="teamOptions" class="options">
		<s:url var="teamUrl" value="/do/team" />
		<c:forEach var="team" items="${teams}">
			<li class="option">
				<a class="option-link" href="${teamUrl}/${team.key}" >
					<span><s:message code="${team.title}" text="${team.title}" /></span>
				</a>
			</li>
		</c:forEach>
		</ul>
	</div>
</body>
</html>
