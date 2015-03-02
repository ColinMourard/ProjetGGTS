<html>
	<head>
    <meta name="layout" content="main" />
    <title>Eleve</title>         
  </head>
  <body>
  		<g:if test="${flash.message}">
        	<div class="message">${flash.message}</div>
        	</g:if>
      	<g:form url="[resource:compteInstance, action:'eleve']" >
				<fieldset class="buttons">
					<g:link controller="compte" action="show" id="${eleveInstance?.id}">Voir le questionnaire</g:link>
				</fieldset>
			</g:form>
		
  </body>
</html>