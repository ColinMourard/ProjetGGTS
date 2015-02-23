package projetggts

class CompteController {

    def index = {}
	
	def login = {}
	
	def authentification = {
	  def compte = Compte.findByIdentifiantAndMdp(params.identifiant, params.mdp)
	  if(compte){
		session.compte = compte
		flash.message = "Bonjour ${compte.nom}!"
		if(compte.admin){
			redirect(controller:"compte.admin", action:"index")
		}
		if(compte.eleve){
			redirect(controller:"compte.eleve", action:"index")
		}
		if(compte.professeur){
			redirect(controller:"compte.professeur", action:"index")
		}
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
