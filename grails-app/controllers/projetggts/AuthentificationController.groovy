package projetggts

class AuthentificationController {

    
    def index = {}
	
	def login = {}
	
	def authentification = {
	  def compte = Compte.findByIdentifiantAndMdp(params.identifiant, params.mdp)
	  if(compte){
		session.compte = compte
		flash.message = "Bonjour ${compte.nom}!"
		redirect(controller:"compte",action:"show")//=> Par défaut! Il faut prendre en compte le fait que la personne qui se connecte est soit un prof soit un élève soit un administrateur (modifier les classes du domaines selon le nouveau diagramme de classe UML
	  }else{
		flash.message = "${params.identifiant} ou mot de passe invalide!."
		redirect(action:"login")
	  }
	}
	
	def logout = {
	  flash.message = "Aurevoir ${session.compte.nom}"
	  session.compte = null
	  redirect(controller:"compte", action:"authenticate")
	}
}
