<%@ page import="projetggts.QuestionnaireSimple" %>



<div class="fieldcontain ${hasErrors(bean: questionnaireSimpleInstance, field: 'reponses', 'error')} ">
	<label for="reponses">
		<g:message code="questionnaireSimple.reponses.label" default="Reponses" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${questionnaireSimpleInstance?.reponses?}" var="r">
    <li><g:link controller="reponseSimple" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="reponseSimple" action="create" params="['questionnaireSimple.id': questionnaireSimpleInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'reponseSimple.label', default: 'ReponseSimple')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: questionnaireSimpleInstance, field: 'question', 'error')} required">
	<label for="question">
		<g:message code="questionnaireSimple.question.label" default="Question" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="question" required="" value="${questionnaireSimpleInstance?.question}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: questionnaireSimpleInstance, field: 'delai', 'error')} required">
	<label for="delai">
		<g:message code="questionnaireSimple.delai.label" default="Delai" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="delai" required="" value="${questionnaireSimpleInstance?.delai}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: questionnaireSimpleInstance, field: 'questionnaire', 'error')} required">
	<label for="questionnaire">
		<g:message code="questionnaireSimple.questionnaire.label" default="Questionnaire" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="questionnaire" name="questionnaire.id" from="${projetggts.QuestionnaireCours.list()}" optionKey="id" required="" value="${questionnaireSimpleInstance?.questionnaire?.id}" class="many-to-one"/>

</div>

