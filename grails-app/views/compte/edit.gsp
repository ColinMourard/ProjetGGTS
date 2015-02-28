<%@ page import="projetggts.Compte" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'compte.label', default: 'Compte')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#edit-compte" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<g:if test="${session?.compte?.type == utilitaires.TypeCompte.Administrateur}">
					<li><g:link class="create" url="[action:'create', id:'professeur']"><g:message message="Nouveau Professeur"/></g:link></li>
					<li><g:link class="create" url="[action:'create', id:'eleve']"><g:message message="Nouvel Eleve"/></g:link></li>
				</g:if>
			</ul>
		</div>
		<div id="edit-compte" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${compteInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${compteInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:compteInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${compteInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
