<html>
  <head>
    <meta name="layout" content="main" />
    <title>Deconnexion</title>         
  </head>
  <body>
  <g:link controller="authentification" action="login">Se connecter</g:link>
  <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
  </body>
</html>