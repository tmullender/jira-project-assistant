<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<s:url value="/css/default.css" var="css"/>
<link rel="stylesheet" type="text/css" href="${css}" />
</head>
<body>
	<s:url var="logout" value="do/logout" />
	<div id="project" class="content">
			<ul id="projectBreadcrumb" class="breadcrumb">
			    <s:url var="homeUrl" value="/do/home" />
		        <li><a href="${homeUrl}"><s:message code="home" /></a></li>
			    <li><s:message code="${project.title}" text="${project.title}" /></li>
			</ul>
		<label for="productOptions" class="options"><s:message code="productOptionsLabel" /></label>
		<ul id="productOptions" class="options">
		<s:url var="productUrl" value="/do/product" />
		<c:forEach var="product" items="${project.products}">
			<li class="option">
				<a class="option-link" href="${productUrl}/${product.key}" >
					<span><s:message code="${product.title}" text="${product.title}" /></span>
				</a>
				
			</li>
		</c:forEach>
		</ul>
	</div>
</body>
</html>