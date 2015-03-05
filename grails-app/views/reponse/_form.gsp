<%@page import="projetggts.QuestionnaireDetaille"%>
<%@page import="utilitaires.QuestionType"%>
<%@ page import="projetggts.Reponse" %>



	<g:set var="questionBoucle" value="${QuestionnaireDetaille.get(params.id)?.firstQuestion}"/>
	<g:set value="1" var="i"/>
	<g:while test="${questionBoucle != null}">
		<g:field type="hidden" name="${"id" + i}" value="${questionBoucle.id}"/>
		<li class="fieldcontain">
		<span id="firstQuestion-label" class="property-label">${i}.</span>
		<span class="property-value" aria-labelledby="firstQuestion-label">${questionBoucle.question}</span>
		<g:if test="${questionBoucle.type == QuestionType.OuiOuNon}">
		<span class="property-value" aria-labelledby="firstQuestion-label"><g:select name="${"reponse" + i}" from="['Oui','Non']" required=""/></span>
		</g:if>
		<g:if test="${questionBoucle.type == QuestionType.NoteSur5}">
		<span class="property-value" aria-labelledby="firstQuestion-label"><g:select name="${"reponse" + i}" from="[0,1,2,3,4,5]" required=""/></span>
		</g:if>
		<g:if test="${questionBoucle.type == QuestionType.TexteObligatoire}">
		<span class="property-value" aria-labelledby="firstQuestion-label"><g:textArea name="${"reponse" + i}" required=""/></span>
		</g:if>
		<g:if test="${questionBoucle.type == QuestionType.Texte}">
		<span class="property-value" aria-labelledby="firstQuestion-label"><g:textArea name="${"reponse" + i}"/></span>
		</g:if>
		</li>
		<%i++%>
		<%questionBoucle = questionBoucle.next %>
	</g:while>

<!--<div class="fieldcontain ${hasErrors(bean: reponseInstance, field: 'type', 'error')} required">
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

</div>-->

