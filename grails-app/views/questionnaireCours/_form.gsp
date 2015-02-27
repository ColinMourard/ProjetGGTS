<%@ page import="projetggts.QuestionnaireCours" %>



<div class="fieldcontain ${hasErrors(bean: questionnaireCoursInstance, field: 'simple', 'error')} ">
	<label for="simple">
		<g:message code="questionnaireCours.simple.label" default="Simple" />
		
	</label>
	<g:select id="simple" name="simple.id" from="${projetggts.QuestionnaireSimple.list()}" optionKey="id" value="${questionnaireCoursInstance?.simple?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: questionnaireCoursInstance, field: 'detaille', 'error')} ">
	<label for="detaille">
		<g:message code="questionnaireCours.detaille.label" default="Detaille" />
		
	</label>
	<g:select id="detaille" name="detaille.id" from="${projetggts.QuestionnaireDetaille.list()}" optionKey="id" value="${questionnaireCoursInstance?.detaille?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: questionnaireCoursInstance, field: 'cours', 'error')} required">
	<label for="cours">
		<g:message code="questionnaireCours.cours.label" default="Cours" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="cours" name="cours.id" from="${projetggts.Cours.list()}" optionKey="id" required="" value="${questionnaireCoursInstance?.cours?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: questionnaireCoursInstance, field: 'professeur', 'error')} required">
	<label for="professeur">
		<g:message code="questionnaireCours.professeur.label" default="Professeur" />
		<span class="required-indicator">*</span>
	</label>
	<g:message code="session.compte.label" default="M./Me./Mlle ${session.compte.nom}"/>
	<g:field type="hidden" id="professeur" name="professeur.id" value="${session.compte.id}"/>

</div>

