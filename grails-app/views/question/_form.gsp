<%@ page import="projetggts.Question" %>



<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="question.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="type" from="${utilitaires.QuestionType?.values()}" keys="${utilitaires.QuestionType.values()*.name()}" required="" value="${questionInstance?.type?.name()}" />

</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'question', 'error')} required">
	<label for="question">
		<g:message code="question.question.label" default="Question" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="question" required="" value="${questionInstance?.question}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'next', 'error')} required">
	<label for="next">
		<g:message code="question.next.label" default="Next" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="next" name="next.id" from="${projetggts.Question.list()}" optionKey="id" required="" value="${questionInstance?.next?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'reponses', 'error')} ">
	<label for="reponses">
		<g:message code="question.reponses.label" default="Reponses" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${questionInstance?.reponses?}" var="r">
    <li><g:link controller="reponse" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="reponse" action="create" params="['question.id': questionInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'reponse.label', default: 'Reponse')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'precedent', 'error')} ">
	<label for="precedent">
		<g:message code="question.precedent.label" default="Precedent" />
		
	</label>
	<g:select id="precedent" name="precedent.id" from="${projetggts.Question.list()}" optionKey="id" value="${questionInstance?.precedent?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

