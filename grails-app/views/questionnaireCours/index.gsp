
<%@ page import="projetggts.QuestionnaireCours" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'questionnaireCours.label', default: 'QuestionnaireCours')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-questionnaireCours" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-questionnaireCours" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="questionnaireCours.detaille.label" default="Detaille" /></th>
					
						<g:sortableColumn property="question" title="${message(code: 'questionnaireCours.question.label', default: 'Question')}" />
					
						<th><g:message code="questionnaireCours.cours.label" default="Cours" /></th>
					
						<g:sortableColumn property="delai" title="${message(code: 'questionnaireCours.delai.label', default: 'Delai')}" />
					
						<th><g:message code="questionnaireCours.professeur.label" default="Professeur" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${questionnaireCoursInstanceList}" status="i" var="questionnaireCoursInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${questionnaireCoursInstance.id}">${fieldValue(bean: questionnaireCoursInstance, field: "detaille")}</g:link></td>
					
						<td>${fieldValue(bean: questionnaireCoursInstance, field: "question")}</td>
					
						<td>${fieldValue(bean: questionnaireCoursInstance, field: "cours")}</td>
					
						<td><g:formatDate date="${questionnaireCoursInstance.delai}" /></td>
					
						<td>${fieldValue(bean: questionnaireCoursInstance, field: "professeur")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${questionnaireCoursInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
