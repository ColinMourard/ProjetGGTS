package projetggts



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class QuestionnaireSimpleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
	def delai(QuestionnaireSimple questionnaireSimpleInstance){
		String deadline = questionnaireSimpleInstance.delai;
		//Passage du format String au format temporel (avec des entiers) pour la date
		
		
	}
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond QuestionnaireSimple.list(params), model:[questionnaireSimpleInstanceCount: QuestionnaireSimple.count()]
    }

    def show(QuestionnaireSimple questionnaireSimpleInstance) {
        respond questionnaireSimpleInstance
    }

    def create() {
        respond new QuestionnaireSimple(params)
    }

    @Transactional
    def save(QuestionnaireSimple questionnaireSimpleInstance) {
        if (questionnaireSimpleInstance == null) {
            notFound()
            return
        }

        if (questionnaireSimpleInstance.hasErrors()) {
            respond questionnaireSimpleInstance.errors, view:'create'
            return
        }

        questionnaireSimpleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'questionnaireSimple.label', default: 'QuestionnaireSimple'), questionnaireSimpleInstance.id])
                redirect questionnaireSimpleInstance
            }
            '*' { respond questionnaireSimpleInstance, [status: CREATED] }
        }
    }

    def edit(QuestionnaireSimple questionnaireSimpleInstance) {
        respond questionnaireSimpleInstance
    }

    @Transactional
    def update(QuestionnaireSimple questionnaireSimpleInstance) {
        if (questionnaireSimpleInstance == null) {
            notFound()
            return
        }

        if (questionnaireSimpleInstance.hasErrors()) {
            respond questionnaireSimpleInstance.errors, view:'edit'
            return
        }

        questionnaireSimpleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'QuestionnaireSimple.label', default: 'QuestionnaireSimple'), questionnaireSimpleInstance.id])
                redirect questionnaireSimpleInstance
            }
            '*'{ respond questionnaireSimpleInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(QuestionnaireSimple questionnaireSimpleInstance) {

        if (questionnaireSimpleInstance == null) {
            notFound()
            return
        }

        questionnaireSimpleInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'QuestionnaireSimple.label', default: 'QuestionnaireSimple'), questionnaireSimpleInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'questionnaireSimple.label', default: 'QuestionnaireSimple'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
