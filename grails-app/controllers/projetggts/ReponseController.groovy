package projetggts



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ReponseController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Reponse.list(params), model:[reponseInstanceCount: Reponse.count()]
    }

    def show(Reponse reponseInstance) {
        respond reponseInstance
    }

    def create() {
        respond new Reponse(params)
    }

    @Transactional
    def save(Reponse reponseInstance) {
        if (reponseInstance == null) {
            notFound()
            return
        }

        if (reponseInstance.hasErrors()) {
            respond reponseInstance.errors, view:'create'
            return
        }
		
        reponseInstance.save flush:true
		
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'reponse.label', default: 'Reponse'), reponseInstance.id])
                redirect reponseInstance
            }
            '*' { respond reponseInstance, [status: CREATED] }
        }
    }

    def edit(Reponse reponseInstance) {
        respond reponseInstance
    }

    @Transactional
    def update(Reponse reponseInstance) {
        if (reponseInstance == null) {
            notFound()
            return
        }

        if (reponseInstance.hasErrors()) {
            respond reponseInstance.errors, view:'edit'
            return
        }

        reponseInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Reponse.label', default: 'Reponse'), reponseInstance.id])
                redirect reponseInstance
            }
            '*'{ respond reponseInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Reponse reponseInstance) {

        if (reponseInstance == null) {
            notFound()
            return
        }

        reponseInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Reponse.label', default: 'Reponse'), reponseInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'reponse.label', default: 'Reponse'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
