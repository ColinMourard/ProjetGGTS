
<%@ page import="projetggts.QuestionnaireSimple" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'questionnaireSimple.label', default: 'QuestionnaireSimple')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-questionnaireSimple" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-questionnaireSimple" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="question" title="${message(code: 'questionnaireSimple.question.label', default: 'Question')}" />
					
						<g:sortableColumn property="delai" title="${message(code: 'questionnaireSimple.delai.label', default: 'Delai')}" />
					
						<th><g:message code="questionnaireSimple.questionnaire.label" default="Questionnaire" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${questionnaireSimpleInstanceList}" status="i" var="questionnaireSimpleInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${questionnaireSimpleInstance.id}">${fieldValue(bean: questionnaireSimpleInstance, field: "question")}</g:link></td>
					
						<td>${fieldValue(bean: questionnaireSimpleInstance, field: "delai")}</td>
					
						<td>${fieldValue(bean: questionnaireSimpleInstance, field: "questionnaire")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${questionnaireSimpleInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
