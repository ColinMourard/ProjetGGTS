package projetggts



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CompteController {
	static scope = "session"

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	
	def envoyer(){
		def eleve;
		for (eleveId in projetggts.QuestionnaireCours.get(params.id).cours.eleves){
			eleve = projetggts.Compte.findByIdentifiant(eleveId);
			eleve.addToQuestionnairesElevesId(new Integer(params.id));
			println eleve.questionnairesElevesId;
			eleve.save flush:true
			if(eleve.hasErrors()){
				println eleve.getErrors();
			}
		}
		redirect controller:"questionnaireCours", action:"show", id:params.id;
	}

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Compte.list(params), model:[compteInstanceCount: Compte.count()]
    }

    def show(Compte compteInstance) {
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
