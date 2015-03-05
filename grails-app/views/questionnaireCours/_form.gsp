<%@ page import="projetggts.QuestionnaireCours" %>

<g:set var="userId" value="${session.compte.id}"/>

<!-- <div class="fieldcontain ${hasErrors(bean: questionnaireCoursInstance, field: 'detaille', 'error')} ">
	<label for="detaille">
		<g:message code="questionnaireCours.detaille.label" default="Detaille" />
		
	</label>
	<g:select id="detaille" name="detaille.id" from="${projetggts.QuestionnaireDetaille.list()}" optionKey="id" value="${questionnaireCoursInstance?.detaille?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>-->

<!--div class="fieldcontain ${hasErrors(bean: questionnaireCoursInstance, field: 'reponses', 'error')} ">
	<label for="reponses">
		<g:message code="questionnaireCours.reponses.label" default="Reponses" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${questionnaireCoursInstance?.reponses?}" var="r">
    <li><g:link controller="reponseSimple" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="reponseSimple" action="create" params="['questionnaireCours.id': questionnaireCoursInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'reponseSimple.label', default: 'ReponseSimple')])}</g:link>
</li>
</ul>


</div>-->

<div class="fieldcontain ${hasErrors(bean: questionnaireCoursInstance, field: 'cours', 'error')} required">
	<label for="cours">
		<g:message code="questionnaireCours.cours.label" default="Cours" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="cours" name="cours.id" from="${projetggts.Compte.get(userId).cours}" optionValue="intitule" optionKey="id" required="" value="${questionnaireCoursInstance?.cours?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: questionnaireCoursInstance, field: 'question', 'error')} required">
	<label for="question">
		<g:message code="questionnaireCours.question.label" default="Question" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="question" required="" value="Tapez ici la question pour le questionnaire simple"/>

</div>

<div class="fieldcontain ${hasErrors(bean: questionnaireCoursInstance, field: 'delai', 'error')} required">
	<label for="delai">
		<g:message code="questionnaireCours.delai.label" default="Delai" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="delai" precision="day"  value="${questionnaireCoursInstance?.delai}"  />

</div>

<g:field type="hidden" id="professeur" name="professeur.id" value="${projetggts.Compte.get(userId).id}"/>

