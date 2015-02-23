
<%@ page import="projetggts.QuestionnaireDetaille" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'questionnaireDetaille.label', default: 'QuestionnaireDetaille')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-questionnaireDetaille" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-questionnaireDetaille" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="questionnaireDetaille.firstQuestion.label" default="First Question" /></th>
					
						<g:sortableColumn property="delai" title="${message(code: 'questionnaireDetaille.delai.label', default: 'Delai')}" />
					
						<th><g:message code="questionnaireDetaille.questionnaire.label" default="Questionnaire" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${questionnaireDetailleInstanceList}" status="i" var="questionnaireDetailleInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${questionnaireDetailleInstance.id}">${fieldValue(bean: questionnaireDetailleInstance, field: "firstQuestion")}</g:link></td>
					
						<td>${fieldValue(bean: questionnaireDetailleInstance, field: "delai")}</td>
					
						<td>${fieldValue(bean: questionnaireDetailleInstance, field: "questionnaire")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${questionnaireDetailleInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
