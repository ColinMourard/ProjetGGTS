package projetggts

import utilitaires.TypeCompte

class AuthentificationController {

    
    def index = {}
	
	def login = {}
	
	def authentification = {
	  def compte = Compte.findByIdentifiantAndMdp(params.login, params.password)
	  if(compte){
		session.compte = compte
		flash.message = "Bonjour ${compte.nom}!"
		if(compte.type.equals(TypeCompte.Eleve)){
			redirect(controller:"reponse",action:"index")	
		}
		else if(compte.type.equals(TypeCompte.Professeur)){
			redirect(controller:"questionnaireCours",action:"index")
		}
		else{
			redirect(controller:"compte",action:"index")
		}
	  }else{
		flash.message = "${params.login} ou mot de passe invalide!."
		redirect(action:"login")
	  }
	}
	
	def logout = {
	  flash.message = "Aurevoir ${session.compte.nom}"
	  session.compte = null
	  redirect(controller:"authentification", action:"authentification")
	}
}
