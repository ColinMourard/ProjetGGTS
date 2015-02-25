<%@ page import="projetggts.QuestionnaireDetaille" %>



<div class="fieldcontain ${hasErrors(bean: questionnaireDetailleInstance, field: 'firstQuestion', 'error')} required">
	<label for="firstQuestion">
		<g:message code="questionnaireDetaille.firstQuestion.label" default="First Question" />
		<span class="required-indicator">*</span>
	</label>
	<g:link controller="question" action="create" params="['questionnaireDetaille.id': QuestionnaireDetailleInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'question.label', default: 'Question')])}</g:link>

</div>

<div class="fieldcontain ${hasErrors(bean: questionnaireDetailleInstance, field: 'delai', 'error')} required">
	<label for="delai">
		<g:message code="questionnaireDetaille.delai.label" default="Delai" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="delai" required="" value="${questionnaireDetailleInstance?.delai}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: questionnaireDetailleInstance, field: 'questionnaire', 'error')} required">
	<label for="questionnaire">
		<g:message code="questionnaireDetaille.questionnaire.label" default="Questionnaire" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="questionnaire" name="questionnaire.id" from="${projetggts.QuestionnaireCours.list()}" optionKey="id" required="" value="${questionnaireDetailleInstance?.questionnaire?.id}" class="many-to-one"/>

</div>

