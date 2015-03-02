package projetggts



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ReponseSimpleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ReponseSimple.list(params), model:[reponseSimpleInstanceCount: ReponseSimple.count()]
    }

    def show(ReponseSimple reponseSimpleInstance) {
        respond reponseSimpleInstance
    }

    def create() {
        respond new ReponseSimple(params)
    }

    @Transactional
    def save(ReponseSimple reponseSimpleInstance) {
        if (reponseSimpleInstance == null) {
            notFound()
            return
        }

        if (reponseSimpleInstance.hasErrors()) {
            respond reponseSimpleInstance.errors, view:'create'
            return
        }

        reponseSimpleInstance.save flush:true
		def eleve = projetggts.Compte.get(session?.compte?.id);
		eleve.removeFromQuestionnairesElevesId(new Integer((int)reponseSimpleInstance.questionnaireCours.id));
		eleve.save flush:true
		if(eleve.hasErrors()){
			println eleve.getErrors();
		}

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'reponseSimple.label', default: 'ReponseSimple'), reponseSimpleInstance.id])
                redirect controller:"compte", action:"show", id:session?.compte.id;
            }
            '*' { respond reponseSimpleInstance, [status: CREATED] }
        }
    }

    def edit(ReponseSimple reponseSimpleInstance) {
        respond reponseSimpleInstance
    }

    @Transactional
    def update(ReponseSimple reponseSimpleInstance) {
        if (reponseSimpleInstance == null) {
            notFound()
            return
        }

        if (reponseSimpleInstance.hasErrors()) {
            respond reponseSimpleInstance.errors, view:'edit'
            return
        }

        reponseSimpleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ReponseSimple.label', default: 'ReponseSimple'), reponseSimpleInstance.id])
                redirect reponseSimpleInstance
            }
            '*'{ respond reponseSimpleInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ReponseSimple reponseSimpleInstance) {

        if (reponseSimpleInstance == null) {
            notFound()
            return
        }

        reponseSimpleInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ReponseSimple.label', default: 'ReponseSimple'), reponseSimpleInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'reponseSimple.label', default: 'ReponseSimple'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
