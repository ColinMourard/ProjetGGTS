<html>
  <head>
    <meta name="layout" content="main" />
    <title>Login</title>         
  </head>
  <body>
    <div class="body">
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:form action="authentification" method="post" >
        <div class="dialog">
          <table>
            <tbody>            
              <tr class="prop">
                <td class="name">
                  <label for="ident"><font color=black>Identifiant:</font></label>
                </td>
                <td>
                  <input type="text" id="ident" name="ident"/>
                </td>
              </tr> 
          
              <tr class="prop">
                <td class="name">
                  <label for="motdepasse"><font color = black>Mot de Passe:</font></label>
                </td>
                <td>
                  <input type="password" id="motdepasse" name="motdepasse"/>
                </td>
              </tr> 
            </tbody>
          </table>
        </div>
        <div class="buttons">
          <span class="button">
            <input class="save" type="submit" value="Connexion" />
          </span>
        </div>
      </g:form>
    </div>
  </body>
</html>