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

<g:if test="${params.firstQuestion == "false"}">
<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'precedent', 'error')} ">
	<label for="precedent">
		<g:message code="question.precedent.label" default="Precedent" />
		
	</label>
	${Question.get(params.id)?.question}

</div>
</g:if>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'next', 'error')} required">
	<label for="next">
		<g:message code="question.next.label" default="Next" />
	</label>
	<g:if test="${params.firstQuestion == "false"}">
		${Question.get(params.id)?.next?.question}
		<g:field type="hidden" id="next" name="next.id" value="${Question.get(params.id)?.next?.id}"/>
	</g:if>
	<g:else>
		${Question.get(params.id)?.question}
		<g:field type="hidden" id="next" name="next.id" value="${Question.get(params.id)?.id}"/>
	</g:else>

</div>

<!--div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'reponses', 'error')} ">
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


</div>-->

