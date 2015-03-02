package projetggts



import static org.springframework.http.HttpStatus.*

import org.apache.tools.ant.Project;

import grails.transaction.Transactional

@Transactional(readOnly = true)
class QuestionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	 
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Question.list(params), model:[questionInstanceCount: Question.count()]
    }

    def show(Question questionInstance) {
        respond questionInstance
    }

    def create() {
        respond new Question(params)
    }

    @Transactional
    def save(Question questionInstance) {
        if (questionInstance == null) {
            notFound()
            return
        }

        if (questionInstance.hasErrors()) {
            respond questionInstance.errors, view:'create'
            return
        }

		println params
        if(params?.firstQuestion == "false"){
			def previousQuestion = projetggts.Question.get(params.id2);
			previousQuestion.next = questionInstance;
			previousQuestion.save flush:true
		}
		else if(params?.firstQuestion == "true"){
			questionInstance.save flush:true
			def quest = projetggts.QuestionnaireDetaille.get(params.questId);
			quest.firstQuestion = questionInstance;
			quest.save flush:true;
		}
		else {
			questionInstance.save flush:true
		}

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'question.label', default: 'Question'), questionInstance.id])
                redirect controller:"questionnaireDetaille", action:"showQuestions", id:params.questId;
            }
            '*' { respond questionInstance, [status: CREATED] }
        }
    }

    def edit(Question questionInstance) {
        respond questionInstance
    }

    @Transactional
    def update(Question questionInstance) {
        if (questionInstance == null) {
            notFound()
            return
        }

        if (questionInstance.hasErrors()) {
            respond questionInstance.errors, view:'edit'
            return
        }

        questionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Question.label', default: 'Question'), questionInstance.id])
                redirect controller:"questionnaireDetaille", action:"showQuestions", id:params.questId;
            }
            '*'{ respond questionInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Question questionInstance) {

        if (questionInstance == null) {
            notFound()
            return
        }
		
		if(questionInstance.precedent != null){
			questionInstance.precedent.next = questionInstance?.next;
			questionInstance?.next?.precedent = null;
			questionInstance?.next = null;
			def temp = questionInstance.precedent;
			questionInstance.precedent = null;
			questionInstance.save flush:true;
			temp.save flush:true;
		}else if(params.questId){
			projetggts.QuestionnaireDetaille.get(params.questId).firstQuestion = questionInstance?.next;
			questionInstance?.next?.precedent = null;
			questionInstance?.next = null;
			projetggts.QuestionnaireDetaille.get(params.questId).save flush:true;
			questionInstance.save flush:true;
		}
        questionInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Question.label', default: 'Question'), questionInstance.id])
                redirect action:"showQuestions", controller:"questionnaireDetaille", id:params.questId;
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'question.label', default: 'Question'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
