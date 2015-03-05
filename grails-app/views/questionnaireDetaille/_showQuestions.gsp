
<%@ page import="projetggts.QuestionnaireDetaille" %>


<div id="show-questionnaireDetailleQuestions" class="content scaffold-show" role="main">
	<h1>Liste des questions</h1>
	<ol class="property-list questionnaireDetailleQuestion">
	
		<g:set var="questionBoucle" value="${QuestionnaireDetaille.get(params.id)?.firstQuestion}"/>
		<fieldset class="buttons">
			<g:link class="create" action="create" controller="question" id="${questionBoucle?.id}" params="[questId: params.id, firstQuestion:'true']"><g:message code="default.button.create.label" default="Create" /></g:link>
		</fieldset>
		<g:set value="1" var="i"/>
		<g:while test="${questionBoucle != null}">
			<li class="fieldcontain">
			<span id="firstQuestion-label" class="property-label">${i}.</span>
			<span class="property-value" aria-labelledby="firstQuestion-label">${questionBoucle.type}</span>
			<span class="property-value" aria-labelledby="firstQuestion-label">${questionBoucle.question}</span>
			<fieldset class="buttons">
				<g:form action="delete" controller="question" id="${questionBoucle.id}" params="[questId:params.id]" method="DELETE">
					<g:link class="edit" action="edit" controller="question" id="${questionBoucle.id}" params="[questId: params.id]"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:link class="create" action="create" controller="question" id="${questionBoucle.id}" params="[questId: params.id, firstQuestion:'false']"><g:message code="default.button.create.label" default="Create" /></g:link>
					<g:actionSubmit class="delete" action="delete" controller="question" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</g:form>
			</fieldset>
			</li>
			<%i++%>
			<%questionBoucle = questionBoucle.next %>
		</g:while>
	
	</ol>
</div>
