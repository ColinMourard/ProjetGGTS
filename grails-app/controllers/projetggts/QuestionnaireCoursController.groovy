package projetggts



import static org.springframework.http.HttpStatus.*
import utilitaires.TypeCompte;
import grails.transaction.Transactional

@Transactional(readOnly = true)
class QuestionnaireCoursController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond QuestionnaireCours.list(params), model:[questionnaireCoursInstanceCount: QuestionnaireCours.count()]
    }

    def show(QuestionnaireCours questionnaireCoursInstance) {
		if(projetggts.Compte.get(session?.compte?.id)?.type == TypeCompte.Eleve){
			def prof = questionnaireCoursInstance.professeur;
			prof.nouvelleReponseSimple = 1;
			prof.save flush:true;
			if(questionnaireCoursInstance.delai.before(new Date())){
				redirect controller:"reponse", action:"create", id:questionnaireCoursInstance?.detaille.id;
			}else{
				redirect controller:"reponseSimple", action:"create", id:questionnaireCoursInstance.id;
			}
		}
		if(projetggts.Compte.get(session?.compte?.id)?.type == TypeCompte.Professeur){
			if(questionnaireCoursInstance.nombreDeReponses == 0){
				
			}
			if(questionnaireCoursInstance.nombreDeReponses == 1){
				flash.message="${questionnaireCoursInstance.nombreDeReponses} reponse pour ce questionnaire";
			}
			if(questionnaireCoursInstance.nombreDeReponses > 1){
				flash.message="${questionnaireCoursInstance.nombreDeReponses} reponses pour ce questionnaire";
			}
			//Affichage de la moyenne obtenue sur les réponses
			
			if(questionnaireCoursInstance.nombreDeReponses>0){
				flash.message = "Les eleves donnent a votre cours une moyenne de ${questionnaireCoursInstance.moyenne}/5";
			}
		}
        respond questionnaireCoursInstance
    }

    def create() {
        respond new QuestionnaireCours(params)
    }

    @Transactional
    def save(QuestionnaireCours questionnaireCoursInstance) {
        if (questionnaireCoursInstance == null) {
            notFound()
            return
        }

        if (questionnaireCoursInstance.hasErrors()) {
            respond questionnaireCoursInstance.errors, view:'create'
            return
        }

        questionnaireCoursInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'questionnaireCours.label', default: 'QuestionnaireCours'), questionnaireCoursInstance.id])
                redirect questionnaireCoursInstance
            }
            '*' { respond questionnaireCoursInstance, [status: CREATED] }
        }
    }

    def edit(QuestionnaireCours questionnaireCoursInstance) {
        respond questionnaireCoursInstance
    }

    @Transactional
    def update(QuestionnaireCours questionnaireCoursInstance) {
        if (questionnaireCoursInstance == null) {
            notFound()
            return
        }

        if (questionnaireCoursInstance.hasErrors()) {
            respond questionnaireCoursInstance.errors, view:'edit'
            return
        }

        questionnaireCoursInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'QuestionnaireCours.label', default: 'QuestionnaireCours'), questionnaireCoursInstance.id])
                redirect questionnaireCoursInstance
            }
            '*'{ respond questionnaireCoursInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(QuestionnaireCours questionnaireCoursInstance) {

        if (questionnaireCoursInstance == null) {
            notFound()
            return
        }

        questionnaireCoursInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'QuestionnaireCours.label', default: 'QuestionnaireCours'), questionnaireCoursInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'questionnaireCours.label', default: 'QuestionnaireCours'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
