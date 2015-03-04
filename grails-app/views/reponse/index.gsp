
<%@ page import="projetggts.Reponse" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'reponse.label', default: 'Reponse')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-reponse" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-reponse" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="type" title="${message(code: 'reponse.type.label', default: 'Type')}" />
					
						<g:sortableColumn property="reponse" title="${message(code: 'reponse.reponse.label', default: 'Reponse')}" />
					
						<th><g:message code="reponse.question.label" default="Question" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${reponseInstanceList}" status="i" var="reponseInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${reponseInstance.id}">${fieldValue(bean: reponseInstance, field: "type")}</g:link></td>
					
						<td>${fieldValue(bean: reponseInstance, field: "reponse")}</td>
					
						<td>${fieldValue(bean: reponseInstance, field: "question")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${reponseInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
