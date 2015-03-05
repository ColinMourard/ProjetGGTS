
<%@ page import="projetggts.Compte" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'compte.label', default: 'Compte')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-compte" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<g:if test="${session?.compte?.type == utilitaires.TypeCompte.Administrateur}">
					<li><g:link class="create" url="[action:'create', id:'professeur']"><g:message message="Nouveau Professeur"/></g:link></li>
					<li><g:link class="create" url="[action:'create', id:'eleve']"><g:message message="Nouvel Eleve"/></g:link></li>
				</g:if>
			</ul>
		</div>
		<div id="list-compte" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="identifiant" title="${message(code: 'compte.identifiant.label', default: 'Identifiant')}" />
					
						<!--g:sortableColumn property="mdp" title="${message(code: 'compte.mdp.label', default: 'Mdp')}" /-->
					
						<g:sortableColumn property="prenom" title="${message(code: 'compte.prenom.label', default: 'Prenom')}" />
					
						<g:sortableColumn property="nom" title="${message(code: 'compte.nom.label', default: 'Nom')}" />
					
						<g:sortableColumn property="mail" title="${message(code: 'compte.mail.label', default: 'Mail')}" />
					
						<!--g:sortableColumn property="annee" title="${message(code: 'compte.annee.label', default: 'Annee')}" /-->
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${compteInstanceList}" status="i" var="compteInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${compteInstance.id}">${fieldValue(bean: compteInstance, field: "identifiant")}</g:link></td>
					
						<!--td>${fieldValue(bean: compteInstance, field: "mdp")}</td-->
					
						<td>${fieldValue(bean: compteInstance, field: "prenom")}</td>
					
						<td>${fieldValue(bean: compteInstance, field: "nom")}</td>
					
						<td>${fieldValue(bean: compteInstance, field: "mail")}</td>
					
						<!--td>${fieldValue(bean: compteInstance, field: "annee")}</td-->
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${compteInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
