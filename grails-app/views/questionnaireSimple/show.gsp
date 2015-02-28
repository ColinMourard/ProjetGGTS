
<%@ page import="projetggts.QuestionnaireSimple" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'questionnaireSimple.label', default: 'QuestionnaireSimple')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-questionnaireSimple" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-questionnaireSimple" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list questionnaireSimple">
			
				<g:if test="${questionnaireSimpleInstance?.reponses}">
				<li class="fieldcontain">
					<span id="reponses-label" class="property-label"><g:message code="questionnaireSimple.reponses.label" default="Reponses" /></span>
					
						<g:each in="${questionnaireSimpleInstance.reponses}" var="r">
						<span class="property-value" aria-labelledby="reponses-label"><g:link controller="reponseSimple" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${questionnaireSimpleInstance?.question}">
				<li class="fieldcontain">
					<span id="question-label" class="property-label"><g:message code="questionnaireSimple.question.label" default="Question" /></span>
					
						<span class="property-value" aria-labelledby="question-label"><g:fieldValue bean="${questionnaireSimpleInstance}" field="question"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${questionnaireSimpleInstance?.delai}">
				<li class="fieldcontain">
					<span id="delai-label" class="property-label"><g:message code="questionnaireSimple.delai.label" default="Delai" /></span>
					
						<span class="property-value" aria-labelledby="delai-label"><g:fieldValue bean="${questionnaireSimpleInstance}" field="delai"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${questionnaireSimpleInstance?.questionnaire}">
				<li class="fieldcontain">
					<span id="questionnaire-label" class="property-label"><g:message code="questionnaireSimple.questionnaire.label" default="Questionnaire" /></span>
					
						<span class="property-value" aria-labelledby="questionnaire-label"><g:link controller="questionnaireCours" action="show" id="${questionnaireSimpleInstance?.questionnaire?.id}">${questionnaireSimpleInstance?.questionnaire?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:questionnaireSimpleInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${questionnaireSimpleInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
