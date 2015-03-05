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
			//A chaque fois que l'on appelle show sur le compte d'un élève
			//On compare la date actuelle avec les délais(on laisse jusqu'à minuit) de chaque questionnaire
			//Si le questionnaire est caduque alors on enlève à l'élève la possibilité d'y répondre
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
		if(compteInstance.type.equals(TypeCompte.Professeur)){
			Date date = new Date();
			date.setHours(23);
			date.setMinutes(59);
			date.setSeconds(59);
			def questionnaires = compteInstance.questionnaires;
			if(questionnaires != null){
				def quest = projetggts.QuestionnaireCours.get(questionnaires.id);
				for(element in quest){
						redirect(controller:"questionnaireCours",action:"show",id:element.id);	
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
