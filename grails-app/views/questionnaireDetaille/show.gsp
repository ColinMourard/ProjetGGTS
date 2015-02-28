
<%@ page import="projetggts.QuestionnaireDetaille" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'questionnaireDetaille.label', default: 'QuestionnaireDetaille')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-questionnaireDetaille" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-questionnaireDetaille" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list questionnaireDetaille">
			
				<g:if test="${questionnaireDetailleInstance?.delai}">
				<li class="fieldcontain">
					<span id="delai-label" class="property-label"><g:message code="questionnaireDetaille.delai.label" default="Delai" /></span>
					
						<span class="property-value" aria-labelledby="delai-label"><g:formatDate date="${questionnaireDetailleInstance?.delai}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${questionnaireDetailleInstance?.firstQuestion}">
				<li class="fieldcontain">
					<span id="firstQuestion-label" class="property-label"><g:message code="questionnaireDetaille.firstQuestion.label" default="First Question" /></span>
					
						<span class="property-value" aria-labelledby="firstQuestion-label"><g:link controller="question" action="show" id="${questionnaireDetailleInstance?.firstQuestion?.id}">${questionnaireDetailleInstance?.firstQuestion?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${questionnaireDetailleInstance?.questionnaire}">
				<li class="fieldcontain">
					<span id="questionnaire-label" class="property-label"><g:message code="questionnaireDetaille.questionnaire.label" default="Questionnaire" /></span>
					
						<span class="property-value" aria-labelledby="questionnaire-label"><g:link controller="questionnaireCours" action="show" id="${questionnaireDetailleInstance?.questionnaire?.id}">${questionnaireDetailleInstance?.questionnaire?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:questionnaireDetailleInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${questionnaireDetailleInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
