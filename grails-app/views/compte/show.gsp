
<%@page import="projetggts.QuestionnaireCours"%>
<%@page import="utilitaires.TypeCompte"%>
<%@ page import="projetggts.Compte" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'compte.label', default: 'Compte')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-compte" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
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
		<div id="show-compte" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list compte">
			
				<g:if test="${compteInstance?.identifiant}">
				<li class="fieldcontain">
					<span id="identifiant-label" class="property-label"><g:message code="compte.identifiant.label" default="Identifiant" /></span>
					
						<span class="property-value" aria-labelledby="identifiant-label"><g:fieldValue bean="${compteInstance}" field="identifiant"/></span>
					
				</li>
				</g:if>
			
				<!--<g:if test="${compteInstance?.mdp}">
				<li class="fieldcontain">
					<span id="mdp-label" class="property-label"><g:message code="compte.mdp.label" default="Mdp" /></span>
					
						<span class="property-value" aria-labelledby="mdp-label"><g:fieldValue bean="${compteInstance}" field="mdp"/></span>
					
				</li>
				</g:if>-->
			
				<g:if test="${compteInstance?.prenom}">
				<li class="fieldcontain">
					<span id="prenom-label" class="property-label"><g:message code="compte.prenom.label" default="Prenom" /></span>
					
						<span class="property-value" aria-labelledby="prenom-label"><g:fieldValue bean="${compteInstance}" field="prenom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${compteInstance?.nom}">
				<li class="fieldcontain">
					<span id="nom-label" class="property-label"><g:message code="compte.nom.label" default="Nom" /></span>
					
						<span class="property-value" aria-labelledby="nom-label"><g:fieldValue bean="${compteInstance}" field="nom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${compteInstance?.mail}">
				<li class="fieldcontain">
					<span id="mail-label" class="property-label"><g:message code="compte.mail.label" default="Mail" /></span>
					
						<span class="property-value" aria-labelledby="mail-label"><g:fieldValue bean="${compteInstance}" field="mail"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${compteInstance?.annee}">
				<li class="fieldcontain">
					<span id="annee-label" class="property-label"><g:message code="compte.annee.label" default="Annee" /></span>
					
						<span class="property-value" aria-labelledby="annee-label"><g:fieldValue bean="${compteInstance}" field="annee"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${compteInstance?.groupe}">
				<li class="fieldcontain">
					<span id="groupe-label" class="property-label"><g:message code="compte.groupe.label" default="Groupe" /></span>
					
						<span class="property-value" aria-labelledby="groupe-label"><g:fieldValue bean="${compteInstance}" field="groupe"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${compteInstance?.questionnaires}">
				<li class="fieldcontain">
					<span id="questionnaires-label" class="property-label"><g:message code="compte.questionnaires.label" default="Questionnaires" /></span>
					
						<g:each in="${compteInstance.questionnaires}" var="q">
						<g:if test="${q.delai.before(new Date()) && q.detaille == null}">
							<span class="urgent" aria-labelledby="questionnaires-label"><g:link controller="questionnaireCours" action="show" id="${q.id}">${q?.cours?.type} ${q?.cours?.intitule} - En attente de questionnaire detaille</g:link></span>
						</g:if>
						<g:else>
							<span class="property-value" aria-labelledby="questionnaires-label"><g:link controller="questionnaireCours" action="show" id="${q.id}">${q?.cours?.type} ${q?.cours?.intitule}</g:link></span>
						</g:else>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${compteInstance?.questionnairesElevesId}">
				<li class="fieldcontain">
					<span id="questionnairesElevesId-label" class="property-label"><g:message code="compte.questionnaires.label" default="Questionnaires a remplir" /></span>
					
						<g:each in="${compteInstance.questionnairesElevesId}" var="q">
						<g:if test="${QuestionnaireCours.get(q).detaille != null || QuestionnaireCours.get(q).delai.after(new Date())}">
							<span class="property-value" aria-labelledby="questionnaires-label"><g:link controller="questionnaireCours" action="show" id="${q}">${QuestionnaireCours.get(q).cours?.type} ${QuestionnaireCours.get(q).cours?.intitule}</g:link></span>
						</g:if>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${compteInstance?.cours}">
				<li class="fieldcontain">
					<span id="cours-label" class="property-label"><g:message code="compte.cours.label" default="Cours" /></span>
					
						<g:each in="${compteInstance.cours}" var="c">
						<span class="property-value" aria-labelledby="cours-label"><g:link controller="cours" action="show" id="${c.id}">${c?.intitule}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<!--<g:if test="${compteInstance?.matieres}">
				<li class="fieldcontain">
					<span id="matieres-label" class="property-label"><g:message code="compte.matieres.label" default="Matieres" /></span>
					
						<span class="property-value" aria-labelledby="matieres-label"><g:fieldValue bean="${compteInstance}" field="matieres"/></span>
					
				</li>
				</g:if>-->
			
				<!--<g:if test="${compteInstance?.estConnecte}">
				<li class="fieldcontain">
					<span id="estConnecte-label" class="property-label"><g:message code="compte.estConnecte.label" default="Est Connecte" /></span>
					
						<span class="property-value" aria-labelledby="estConnecte-label"><g:formatBoolean boolean="${compteInstance?.estConnecte}" /></span>
					
				</li>
				</g:if>-->
			
				<!--<g:if test="${compteInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="property-label"><g:message code="compte.type.label" default="Type" /></span>
					
						<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${compteInstance}" field="type"/></span>
					
				</li>
				</g:if>-->
			
			</ol>
			<g:form url="[resource:compteInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:if test="${compteInstance?.id == session?.compte?.id || session?.compte?.type == TypeCompte.Administrateur}">
						<g:link class="edit" action="edit" resource="${compteInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					</g:if>
					<g:if test="${session?.compte?.type == TypeCompte.Administrateur}">
						<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					</g:if>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
