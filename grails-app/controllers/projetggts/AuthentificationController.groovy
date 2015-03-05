package projetggts

import java.util.TimerTask;

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
			if(compte.nouveauQuestionnaire == 1){
				redirect(controller:"compte",action:"eleve",params:[identifiant:compte.identifiant])
			}
			else{
				redirect(controller:"compte",action:"show",id:compte.id);
			}
		}
		else if(compte.type.equals(TypeCompte.Professeur)){
			if(compte.nouvelleReponseSimple == 1){
				redirect(controller:"compte",action:"prof",params:[identifiant:compte.identifiant])
			}
			else{
				redirect(controller:"questionnaireCours",action:"index")
			}
		}
		else{
			redirect(url: "/compte/show/${session.compte.getId()}")
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
		flash.message = "Au revoir ${session.compte.nom}"
		session.compte = null
		redirect(url: "/")
	}
}
