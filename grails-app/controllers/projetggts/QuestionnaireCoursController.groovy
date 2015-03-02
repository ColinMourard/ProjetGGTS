package projetggts



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class QuestionnaireCoursController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond QuestionnaireCours.list(params), model:[questionnaireCoursInstanceCount: QuestionnaireCours.count()]
    }

    def show(QuestionnaireCours questionnaireCoursInstance) {
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
