<%@ page import="projetggts.Question" %>



<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="question.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="type" required="" value="${questionInstance?.type}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'question', 'error')} required">
	<label for="question">
		<g:message code="question.question.label" default="Question" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="question" required="" value="${questionInstance?.question}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'next', 'error')} ">
	<label for="next">
		<g:message code="question.next.label" default="Next" />
		
	</label>
	<g:select id="next" name="next.id" from="${projetggts.Question.list()}" optionKey="id" value="${questionInstance?.next?.id}" class="many-to-one" noSelection="['null': '']"/>

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

