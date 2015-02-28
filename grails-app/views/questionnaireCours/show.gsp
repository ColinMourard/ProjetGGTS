
<%@ page import="projetggts.QuestionnaireCours" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'questionnaireCours.label', default: 'QuestionnaireCours')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-questionnaireCours" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-questionnaireCours" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list questionnaireCours">
			
				<g:if test="${questionnaireCoursInstance?.cours}">
				<li class="fieldcontain">
					<span id="cours-label" class="property-label"><g:message code="questionnaireCours.cours.label" default="Cours" /></span>
					
						<span class="property-value" aria-labelledby="cours-label"><g:link controller="cours" action="show" id="${questionnaireCoursInstance?.cours?.id}">${questionnaireCoursInstance?.cours?.intitule}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${questionnaireCoursInstance?.question}">
				<li class="fieldcontain">
					<span id="question-label" class="property-label"><g:message code="questionnaireCours.question.label" default="Question" /></span>
					
						<span class="property-value" aria-labelledby="question-label"><g:fieldValue bean="${questionnaireCoursInstance}" field="question"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${questionnaireCoursInstance?.delai}">
				<li class="fieldcontain">
					<span id="delai-label" class="property-label"><g:message code="questionnaireCours.delai.label" default="Delai" /></span>
					
						<span class="property-value" aria-labelledby="delai-label"><g:formatDate date="${questionnaireCoursInstance?.delai}" type="date"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${questionnaireCoursInstance?.detaille}">
				<li class="fieldcontain">
					<span id="detaille-label" class="property-label"><g:message code="questionnaireCours.detaille.label" default="Detaille" /></span>
					
						<span class="property-value" aria-labelledby="detaille-label"><g:link controller="questionnaireDetaille" action="show" id="${questionnaireCoursInstance?.detaille?.id}">${questionnaireCoursInstance?.detaille?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${questionnaireCoursInstance?.reponses}">
				<li class="fieldcontain">
					<span id="reponses-label" class="property-label"><g:message code="questionnaireCours.reponses.label" default="Reponses" /></span>
					
						<g:each in="${questionnaireCoursInstance.reponses}" var="r">
						<span class="property-value" aria-labelledby="reponses-label"><g:link controller="reponseSimple" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${questionnaireCoursInstance?.professeur}">
				<li class="fieldcontain">
					<span id="professeur-label" class="property-label"><g:message code="questionnaireCours.professeur.label" default="Professeur" /></span>
					
						<span class="property-value" aria-labelledby="professeur-label"><g:link controller="compte" action="show" id="${questionnaireCoursInstance?.professeur?.id}">${questionnaireCoursInstance?.professeur?.prenom} ${questionnaireCoursInstance?.professeur?.nom}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:questionnaireCoursInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${questionnaireCoursInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
