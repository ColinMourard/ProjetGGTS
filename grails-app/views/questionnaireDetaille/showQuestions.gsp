
<%@ page import="projetggts.QuestionnaireDetaille" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'questionnaireDetaille.label', default: 'QuestionnaireDetaille')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="show-questionnaireDetailleQuestions" class="content scaffold-show" role="main">
			<h1>Liste des questions</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list questionnaireDetailleQuestion">
			
				<g:set var="questionBoucle" value="${QuestionnaireDetaille.get(params.id)?.firstQuestion}"/>
				<g:set value="1" var="i"/>
				<g:while test="${questionBoucle != null}">
					<li class="fieldcontain">
					<span id="firstQuestion-label" class="property-label">${i}.</span>
					<span class="property-value" aria-labelledby="firstQuestion-label">${questionBoucle.type}</span>
					<span class="property-value" aria-labelledby="firstQuestion-label">${questionBoucle.question}</span>
					</li>
					<%i++%>
					<%questionBoucle = questionBoucle.next %>
				</g:while>
			
			</ol>
		</div>
	</body>
</html>
