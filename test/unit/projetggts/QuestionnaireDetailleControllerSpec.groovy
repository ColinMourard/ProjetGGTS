package projetggts



import grails.test.mixin.*
import spock.lang.*

@TestFor(QuestionnaireDetailleController)
@Mock(QuestionnaireDetaille)
class QuestionnaireDetailleControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.questionnaireDetailleInstanceList
            model.questionnaireDetailleInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.questionnaireDetailleInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def questionnaireDetaille = new QuestionnaireDetaille()
            questionnaireDetaille.validate()
            controller.save(questionnaireDetaille)

        then:"The create view is rendered again with the correct model"
            model.questionnaireDetailleInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            questionnaireDetaille = new QuestionnaireDetaille(params)

            controller.save(questionnaireDetaille)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/questionnaireDetaille/show/1'
            controller.flash.message != null
            QuestionnaireDetaille.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def questionnaireDetaille = new QuestionnaireDetaille(params)
            controller.show(questionnaireDetaille)

        then:"A model is populated containing the domain instance"
            model.questionnaireDetailleInstance == questionnaireDetaille
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def questionnaireDetaille = new QuestionnaireDetaille(params)
            controller.edit(questionnaireDetaille)

        then:"A model is populated containing the domain instance"
            model.questionnaireDetailleInstance == questionnaireDetaille
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/questionnaireDetaille/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def questionnaireDetaille = new QuestionnaireDetaille()
            questionnaireDetaille.validate()
            controller.update(questionnaireDetaille)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.questionnaireDetailleInstance == questionnaireDetaille

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            questionnaireDetaille = new QuestionnaireDetaille(params).save(flush: true)
            controller.update(questionnaireDetaille)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/questionnaireDetaille/show/$questionnaireDetaille.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/questionnaireDetaille/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def questionnaireDetaille = new QuestionnaireDetaille(params).save(flush: true)

        then:"It exists"
            QuestionnaireDetaille.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(questionnaireDetaille)

        then:"The instance is deleted"
            QuestionnaireDetaille.count() == 0
            response.redirectedUrl == '/questionnaireDetaille/index'
            flash.message != null
    }
}
