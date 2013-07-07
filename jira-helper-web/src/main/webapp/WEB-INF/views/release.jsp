<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<s:url value="/css/default.css" var="css" />
<s:url value="/js/actions.js" var="actions" />
<link rel="stylesheet" type="text/css" href="${css}" />
<script src="http://code.jquery.com/jquery-1.9.1.js" ></script>
<script src="${actions}" ></script>
</head>
<body>
	<s:url var="logout" value="/do/logout" />
	<div id="release" class="content">
		<ul id="projectBreadcrumb" class="breadcrumb">
			<s:url var="homeUrl" value="/do/home" />
			<s:url var="projectUrl" value="/do/project/${project.key}" />
			<s:url var="productUrl" value="/do/product/${product.key}" />
			<li><a href="${homeUrl}"><s:message code="home" /></a></li>
			<li><a href="${projectUrl}"><s:message
						code="${project.title}" text="${project.title}" /></a></li>
			<li><a href="${productUrl}"><s:message
						code="${product.title}" text="${product.title}" /></a></li>
			<li><s:message code="${release.title}project.title"
					text="${release.title}" /></li>
		</ul>
		<label for="taskOptions" class="options"><s:message
				code="taskOptionsLabel" /></label>
		<div class="control collapse" onclick="collapse('.child-options')" ></div>
		<div class="control expand" onclick="expand('.child-options')" ></div>
		<form method="POST">
			<input id="start" name="start" type="date" value="${start}">
			<input id="end" name="end" type="date" value="${end}"> <input
				type="submit" value="Update">
		</form>
		<ul id="taskOptions" class="options">
			<s:url var="taskUrl" value="${jira.url}" />
			<c:forEach var="task" items="${tasklist.items}">
				<li class="option">
					<div class="option-parent" onclick="hideChildren(this)">
					<a class="option-link"
					href="${taskUrl}/${task.key}"><s:message code="${task.key}"
							text="${task.key}" /></a> <a class="option-link"
					href="${taskUrl}/${task.key}"><s:message code="${task.title}"
							text="${task.title}" /></a> <span><s:message
							code="${task.timeSpent}" text="${task.timeSpent}" /></span> <span><s:message
							code="${task.totalSpent}" text="${task.totalSpent}" /></span>
							</div>
					<ul class="child-options">
						<c:forEach var="child" items="${task.children}">
							<li class="option-child"><a class="option-link"
								href="${taskUrl}/${child.key}"><s:message
										code="${child.key}" text="${child.key}" /></a> <a
								class="option-link" href="${taskUrl}/${child.key}"><s:message
										code="${child.title}" text="${child.title}" /></a> <span><s:message
										code="${child.timeSpent}" text="${child.timeSpent}" /></span> <span><s:message
										code="${child.totalSpent}" text="${child.totalSpent}" /></span></li>
						</c:forEach>
					</ul></li>
			</c:forEach>
		</ul>
		<label for="userOptions" class="options"><s:message
				code="userOptionsLabel" /></label>
		<ul id="userOptions" class="options">
			<s:url var="userUrl" value="/do/user" />
			<c:forEach var="entry" items="${tasklist.userTime}">
				<li class="option"><span><s:message code="${entry.key}"
							text="${entry.key}" /></span> <span><s:message
							code="${entry.value}" text="${entry.value}" /></span></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
