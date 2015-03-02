
<%@ page import="projetggts.ReponseSimple" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'reponseSimple.label', default: 'ReponseSimple')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-reponseSimple" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-reponseSimple" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="reponse" title="${message(code: 'reponseSimple.reponse.label', default: 'Reponse')}" />
					
						<th><g:message code="reponseSimple.questionnaireCours.label" default="Questionnaire Cours" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${reponseSimpleInstanceList}" status="i" var="reponseSimpleInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${reponseSimpleInstance.id}">${fieldValue(bean: reponseSimpleInstance, field: "reponse")}</g:link></td>
					
						<td>${fieldValue(bean: reponseSimpleInstance, field: "questionnaireCours")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${reponseSimpleInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
