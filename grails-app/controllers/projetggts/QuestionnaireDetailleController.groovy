package projetggts



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class QuestionnaireDetailleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond QuestionnaireDetaille.list(params), model:[questionnaireDetailleInstanceCount: QuestionnaireDetaille.count()]
    }

    def show(QuestionnaireDetaille questionnaireDetailleInstance) {
        respond questionnaireDetailleInstance
    }

    def create() {
        respond new QuestionnaireDetaille(params)
    }

    @Transactional
    def save(QuestionnaireDetaille questionnaireDetailleInstance) {
        if (questionnaireDetailleInstance == null) {
            notFound()
            return
        }

        if (questionnaireDetailleInstance.hasErrors()) {
            respond questionnaireDetailleInstance.errors, view:'create'
            return
        }
		
        questionnaireDetailleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'questionnaireDetaille.label', default: 'QuestionnaireDetaille'), questionnaireDetailleInstance.id])
                redirect questionnaireDetailleInstance
            }
            '*' { respond questionnaireDetailleInstance, [status: CREATED] }
        }
    }

    def edit(QuestionnaireDetaille questionnaireDetailleInstance) {
        respond questionnaireDetailleInstance
    }

    @Transactional
    def update(QuestionnaireDetaille questionnaireDetailleInstance) {
        if (questionnaireDetailleInstance == null) {
            notFound()
            return
        }

        if (questionnaireDetailleInstance.hasErrors()) {
            respond questionnaireDetailleInstance.errors, view:'edit'
            return
        }

        questionnaireDetailleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'QuestionnaireDetaille.label', default: 'QuestionnaireDetaille'), questionnaireDetailleInstance.id])
                redirect questionnaireDetailleInstance
            }
            '*'{ respond questionnaireDetailleInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(QuestionnaireDetaille questionnaireDetailleInstance) {

        if (questionnaireDetailleInstance == null) {
            notFound()
            return
        }

        questionnaireDetailleInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'QuestionnaireDetaille.label', default: 'QuestionnaireDetaille'), questionnaireDetailleInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'questionnaireDetaille.label', default: 'QuestionnaireDetaille'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
