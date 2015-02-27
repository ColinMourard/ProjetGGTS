package projetggts

import utilitaires.TypeCompte

class AuthentificationController {

    
    def index = {}
	
	def login = {}
	
	def authentification = {
	  def compte = Compte.findByIdentifiantAndMdp(params.ident, params.motdepasse)
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
		flash.message = "${params.ident} ou mot de passe invalide!."
		redirect(action:"login")
	  }
	}
	
	def logout = {
	  redirect(controller:"authentification", action:"deconnexion")
	}
	def deconnexion ={
		flash.message = "Aurevoir ${session.compte.nom}"
		session.compte = null
	}
}
