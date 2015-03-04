<%@ page import="projetggts.Reponse" %>



<div class="fieldcontain ${hasErrors(bean: reponseInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="reponse.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="type" from="${utilitaires.QuestionType?.values()}" keys="${utilitaires.QuestionType.values()*.name()}" required="" value="${reponseInstance?.type?.name()}" />

</div>

<div class="fieldcontain ${hasErrors(bean: reponseInstance, field: 'reponse', 'error')} required">
	<label for="reponse">
		<g:message code="reponse.reponse.label" default="Reponse" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="reponse" required="" value="${reponseInstance?.reponse}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reponseInstance, field: 'question', 'error')} ">
	<label for="question">
		<g:message code="reponse.question.label" default="Question" />
		
	</label>
	<g:select id="question" name="question.id" from="${projetggts.Question.list()}" optionKey="id" value="${reponseInstance?.question?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

