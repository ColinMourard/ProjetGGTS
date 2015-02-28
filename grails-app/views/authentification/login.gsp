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
                  <label for="ident">Identifiant:</label>
                </td>
                <td>
                  <input type="text" id="ident" name="ident"/>
                </td>
              </tr> 
          
              <tr class="prop">
                <td class="name">
                  <label for="motdepasse">Mot de Passe:</label>
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
            <input class="save" type="submit" value="Se Connecter" />
          </span>
        </div>
      </g:form>
    </div>
  </body>
</html>