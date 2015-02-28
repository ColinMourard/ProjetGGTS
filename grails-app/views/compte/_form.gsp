<%@ page import="projetggts.Compte" %>



<div class="fieldcontain ${hasErrors(bean: compteInstance, field: 'identifiant', 'error')} required">
	<label for="identifiant">
		<g:message code="compte.identifiant.label" default="Identifiant" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="identifiant" required="" value="${compteInstance?.identifiant}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: compteInstance, field: 'mdp', 'error')} required">
	<label for="mdp">
		<g:message code="compte.mdp.label" default="Mdp" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="password" name="mdp" required="" value="${compteInstance?.mdp}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: compteInstance, field: 'prenom', 'error')} required">
	<label for="prenom">
		<g:message code="compte.prenom.label" default="Prenom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="prenom" required="" value="${compteInstance?.prenom}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: compteInstance, field: 'nom', 'error')} required">
	<label for="nom">
		<g:message code="compte.nom.label" default="Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nom" required="" value="${compteInstance?.nom}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: compteInstance, field: 'mail', 'error')} required">
	<label for="mail">
		<g:message code="compte.mail.label" default="Mail" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="mail" required="" value="${compteInstance?.mail}"/>

</div>

<g:if test="${params.id == "eleve"}">
<div class="fieldcontain ${hasErrors(bean: compteInstance, field: 'annee', 'error')} required">
	<label for="annee">
		<g:message code="compte.annee.label" default="Annee" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="annee" type="number" value="${compteInstance.annee}" required=""/>

</div>
</g:if>

<g:if test="${params.id == "eleve"}">
<div class="fieldcontain ${hasErrors(bean: compteInstance, field: 'groupe', 'error')} required">
	<label for="groupe">
		<g:message code="compte.groupe.label" default="Groupe" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="groupe" type="number" value="${compteInstance.groupe}" required=""/>

</div>
</g:if>

<!--<div class="fieldcontain ${hasErrors(bean: compteInstance, field: 'questionnaires', 'error')} ">
	<label for="questionnaires">
		<g:message code="compte.questionnaires.label" default="Questionnaires" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${compteInstance?.questionnaires?}" var="q">
    <li><g:link controller="questionnaireCours" action="show" id="${q.id}">${q?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="questionnaireCours" action="create" params="['compte.id': compteInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'questionnaireCours.label', default: 'QuestionnaireCours')])}</g:link>
</li>
</ul>


</div>-->

<g:if test="${params.id == "professeur"}">
<div class="fieldcontain ${hasErrors(bean: compteInstance, field: 'cours', 'error')} ">
	<label for="cours">
		<g:message code="compte.cours.label" default="Cours" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${compteInstance?.cours?}" var="c">
    <li><g:link controller="cours" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="cours" action="create" params="['compte.id': compteInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'cours.label', default: 'Cours')])}</g:link>
</li>
</ul>


</div>
</g:if>

<!--<div class="fieldcontain ${hasErrors(bean: compteInstance, field: 'matieres', 'error')} ">
	<label for="matieres">
		<g:message code="compte.matieres.label" default="Matieres" />
		
	</label>
	

</div>-->

<!--<div class="fieldcontain ${hasErrors(bean: compteInstance, field: 'estConnecte', 'error')} ">
	<label for="estConnecte">
		<g:message code="compte.estConnecte.label" default="Est Connecte" />
		
	</label>
	<g:checkBox name="estConnecte" value="${compteInstance?.estConnecte}" />

</div>-->

<!--<div class="fieldcontain ${hasErrors(bean: compteInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="compte.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="type" from="${utilitaires.TypeCompte?.values()}" keys="${utilitaires.TypeCompte.values()*.name()}" required="" value="${compteInstance?.type?.name()}" />

</div>-->

<g:if test="${params.id == "professeur"}">
	<g:field type="hidden" name="type" value="${utilitaires.TypeCompte.Professeur}"/>
</g:if>
<g:if test="${params.id == "eleve"}">
	<g:field type="hidden" name="type" value="${utilitaires.TypeCompte.Eleve}"/>
</g:if>

