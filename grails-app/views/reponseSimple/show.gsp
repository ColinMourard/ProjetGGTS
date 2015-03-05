
<%@ page import="projetggts.ReponseSimple" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'reponseSimple.label', default: 'ReponseSimple')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-reponseSimple" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-reponseSimple" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list reponseSimple">
			
				<g:if test="${reponseSimpleInstance?.reponse}">
				<li class="fieldcontain">
					<span id="reponse-label" class="property-label"><g:message code="reponseSimple.reponse.label" default="Reponse" /></span>
					
						<span class="property-value" aria-labelledby="reponse-label"><g:fieldValue bean="${reponseSimpleInstance}" field="reponse"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reponseSimpleInstance?.questionnaireCours}">
				<li class="fieldcontain">
					<span id="questionnaireCours-label" class="property-label"><g:message code="reponseSimple.questionnaireCours.label" default="Questionnaire Cours" /></span>
					
						<span class="property-value" aria-labelledby="questionnaireCours-label"><g:link controller="questionnaireCours" action="show" id="${reponseSimpleInstance?.questionnaireCours?.id}">${reponseSimpleInstance?.questionnaireCours?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:reponseSimpleInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${reponseSimpleInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
