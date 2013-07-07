<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<s:url value="/css/default.css" var="css"/>
<link rel="stylesheet" type="text/css" href="${css}" />
</head>
<body>
	<s:url var="logout" value="do/logout" />
	<div id="product" class="content">
			<ul id="projectBreadcrumb" class="breadcrumb">
			    <s:url var="homeUrl" value="/do/home" />
		        <s:url var="projectUrl" value="/do/project/${project.key}" />
		        <li><a href="${homeUrl}"><s:message code="home" /></a></li>
			    <li><a href="${projectUrl}"><s:message code="${project.title}" text="${project.title}" /></a></li>
			    <li><s:message code="${product.title}" text="${product.title}" /></li>
			</ul>
		<label for="releaseOptions" class="options"><s:message code="releaseOptionsLabel" /></label>
		<ul id="releaseOptions" class="options">
		<s:url var="releaseUrl" value="/do/release" />
		<c:forEach var="release" items="${project.releases}">
			<li class="option">
				<a class="option-link" href="${releaseUrl}/${release.key}" >
					<span><s:message code="${release.title}" text="${release.title}" /></span>
				</a>
			</li>
		</c:forEach>
		</ul>
	</div>
</body>
</html>
