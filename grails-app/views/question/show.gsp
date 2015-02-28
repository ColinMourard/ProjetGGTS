
<%@ page import="projetggts.Question" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-question" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-question" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list question">
			
				<g:if test="${questionInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="property-label"><g:message code="question.type.label" default="Type" /></span>
					
						<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${questionInstance}" field="type"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${questionInstance?.question}">
				<li class="fieldcontain">
					<span id="question-label" class="property-label"><g:message code="question.question.label" default="Question" /></span>
					
						<span class="property-value" aria-labelledby="question-label"><g:fieldValue bean="${questionInstance}" field="question"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${questionInstance?.next}">
				<li class="fieldcontain">
					<span id="next-label" class="property-label"><g:message code="question.next.label" default="Next" /></span>
					
						<span class="property-value" aria-labelledby="next-label"><g:link controller="question" action="show" id="${questionInstance?.next?.id}">${questionInstance?.next?.question}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${questionInstance?.precedent}">
				<li class="fieldcontain">
					<span id="precedent-label" class="property-label"><g:message code="question.precedent.label" default="Precedent" /></span>
					
						<span class="property-value" aria-labelledby="precedent-label"><g:link controller="question" action="show" id="${questionInstance?.precedent?.id}">${questionInstance?.precedent?.question}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${questionInstance?.reponses}">
				<li class="fieldcontain">
					<span id="reponses-label" class="property-label"><g:message code="question.reponses.label" default="Reponses" /></span>
					
						<g:each in="${questionInstance.reponses}" var="r">
						<span class="property-value" aria-labelledby="reponses-label"><g:link controller="reponse" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:questionInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${questionInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
