<%@page import="projetggts.QuestionnaireCours"%>
<%@ page import="projetggts.ReponseSimple" %>



<label for="question">
	<g:message message="Question" />
</label>
<g:message message="${QuestionnaireCours.get(params.id)?.question}"/>


<div class="fieldcontain ${hasErrors(bean: reponseSimpleInstance, field: 'reponse', 'error')} required">
	<label for="reponse">
		<g:message code="reponseSimple.reponse.label" default="Reponse" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="reponse" from="${reponseSimpleInstance.constraints.reponse.inList}" required="" value="${fieldValue(bean: reponseSimpleInstance, field: 'reponse')}" valueMessagePrefix="reponseSimple.reponse"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reponseSimpleInstance, field: 'questionnaireCours', 'error')} required">
	<!--<label for="questionnaireCours">
		<g:message code="reponseSimple.questionnaireCours.label" default="Questionnaire Cours" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="questionnaireCours" name="questionnaireCours.id" from="${projetggts.QuestionnaireCours.list()}" optionKey="id" required="" value="${reponseSimpleInstance?.questionnaireCours?.id}" class="many-to-one"/>-->
	<g:field type="hidden" name="questionnaireCours.id" value="${params.id}"/>

</div>

