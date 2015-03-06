package projetggts



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import utilitaires.TypeCompte

@Transactional(readOnly = true)
class CompteController {
	static scope = "session"

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	
	def envoyer(){
		def eleve;
		for (eleveId in projetggts.QuestionnaireCours.get(params.id).cours.eleves){
			eleve = projetggts.Compte.findByIdentifiant(eleveId);
			eleve.addToQuestionnairesElevesId(new Integer(params.id));
			eleve.nouveauQuestionnaire = 1;
			eleve.save flush:true
			if(eleve.hasErrors()){
				println eleve.getErrors();
			}
		}
		flash.message ="Le questionnaire a bien ete envoye!";
		redirect controller:"questionnaireCours", action:"index";
	}
	def eleve(){
		def ele = projetggts.Compte.findByIdentifiant(params.identifiant);
		flash.message = "Un nouveau questionnaire vous attend!";
		ele.nouveauQuestionnaire = 0;
		ele.save flush:true
		redirect(controller:"compte",action:"show",id:ele.id);
	}
	def prof(){
		def prof = projetggts.Compte.findByIdentifiant(params.identifiant);
		flash.message = "Des eleves ont repondus a votre questionnaire!";
		prof.nouvelleReponseSimple = 0;
		prof.save flush:true
		redirect(controller:"compte",action:"show",id:prof.id);
	}
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Compte.list(params), model:[compteInstanceCount: Compte.count()]
    }

    def show(Compte compteInstance) {
		if(compteInstance.type.equals(TypeCompte.Eleve)){
			//A chaque fois que l'on appelle show sur le compte d'un �l�ve
			//On compare la date actuelle avec les d�lais(on laisse jusqu'� minuit) de chaque questionnaire
			//Si le questionnaire est caduque alors on enl�ve � l'�l�ve la possibilit� d'y r�pondre
			//Sinon on n'y touche pas!
			Date date = new Date();
			date.setHours(23);
			date.setMinutes(59);
			date.setSeconds(59);
			def quest = projetggts.QuestionnaireCours.get(compteInstance.questionnairesElevesId);
			for(element in quest){
				if(element.delai.compareTo(date)==-1 || element.delai.compareTo(date) == 0){
					compteInstance.removeFromQuestionnairesElevesId(new Integer((int)element.id));
					compteInstance.save flush: true;
				}
			}
		}
        respond compteInstance
    }

    def create() {
        respond new Compte(params)
    }

    @Transactional
    def save(Compte compteInstance) {
        if (compteInstance == null) {
            notFound()
            return
        }

        if (compteInstance.hasErrors()) {
            respond compteInstance.errors, view:'create'
            return
        }

        compteInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'compte.label', default: 'Compte'), compteInstance.id])
                redirect compteInstance
            }
            '*' { respond compteInstance, [status: CREATED] }
        }
    }

    def edit(Compte compteInstance) {
        respond compteInstance
    }

    @Transactional
    def update(Compte compteInstance) {
        if (compteInstance == null) {
            notFound()
            return
        }

        if (compteInstance.hasErrors()) {
            respond compteInstance.errors, view:'edit'
            return
        }

        compteInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Compte.label', default: 'Compte'), compteInstance.id])
                redirect compteInstance
            }
            '*'{ respond compteInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Compte compteInstance) {

        if (compteInstance == null) {
            notFound()
            return
        }

        compteInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Compte.label', default: 'Compte'), compteInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'compte.label', default: 'Compte'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
