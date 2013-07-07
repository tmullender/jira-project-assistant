<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<s:url value="/dwr/interface/DwrTeamService.js" var="interface" />
<script type="text/javascript" src="${interface}"></script>
<s:url value="/dwr/engine.js" var="engine" />
<script type="text/javascript" src="${engine}"></script>
<s:url value="/css/default.css" var="css"/>
<link rel="stylesheet" type="text/css" href="${css}" />
</head>
<body>
	<s:url var="logout" value="/do/logout" />
	<s:url var="createMemberUrl" value="/do/user/create" />
	<s:url var="memberUrl" value="/do/user/view" />
	<div id="team" class="content">
		<p class="title"><s:message code="${team.title}" text="${team.title}" /></p>
		<p class="description"><s:message code="${team.description}" text="${team.description}" /></p>
		<label for="teamMembers" class="options"><s:message code="teamMembersLabel" /></label>
		<a href="${createMemberUrl}" ><span><s:message code="createUserLink" /></span></a>
		<ul id="teamMembers" class="options">
		<c:forEach var="member" items="${team.members}">
			<li class="option" id="${member.key}">
				<a class="option-link" href="${memberUrl}/${member.key}" >
					<span><s:message code="${member.name}" text="${member.name}" /></span>
				</a>
			</li>
			<div id="rating-${member.key}" class="slider" ></div>
		</c:forEach>
		</ul>
		<ul id="availableMembers" class="options">
		<c:forEach var="member" items="${members}">
			<li class="option" id="${member.key}">
				<a class="option-link" href="${memberUrl}/${member.key}" >
					<span><s:message code="${member.name}" text="${member.name}" /></span>
				</a>
			</li>
		</c:forEach>
		</ul>
	</div>
	<script type="text/javascript">
	  var teamKey = ${team.key};
	  $(function() {
		    $("#availableMembers").sortable({
		    	connectWith: "#teamMembers", 
		    	receive: function(event, ui){
				  DwrTeamService.removeTeamMember(teamKey, ui.item.attr('id'));
			    }
			});
		    $("#teamMembers").sortable({
		    	connectWith: "#availableMembers", 
		    	receive: function(event, ui){
				  DwrTeamService.addTeamMember(teamKey, ui.item.attr('id'));
			    }
			});
		    $(".slider").slider();
		  });
	</script>
</body>
</html>