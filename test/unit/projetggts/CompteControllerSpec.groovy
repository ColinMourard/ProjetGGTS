package projetggts



import grails.test.mixin.*
import spock.lang.*

@TestFor(CompteController)
@Mock(Compte)
class CompteControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.compteInstanceList
            model.compteInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.compteInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def compte = new Compte()
            compte.validate()
            controller.save(compte)

        then:"The create view is rendered again with the correct model"
            model.compteInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            compte = new Compte(params)

            controller.save(compte)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/compte/show/1'
            controller.flash.message != null
            Compte.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def compte = new Compte(params)
            controller.show(compte)

        then:"A model is populated containing the domain instance"
            model.compteInstance == compte
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def compte = new Compte(params)
            controller.edit(compte)

        then:"A model is populated containing the domain instance"
            model.compteInstance == compte
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/compte/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def compte = new Compte()
            compte.validate()
            controller.update(compte)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.compteInstance == compte

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            compte = new Compte(params).save(flush: true)
            controller.update(compte)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/compte/show/$compte.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/compte/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def compte = new Compte(params).save(flush: true)

        then:"It exists"
            Compte.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(compte)

        then:"The instance is deleted"
            Compte.count() == 0
            response.redirectedUrl == '/compte/index'
            flash.message != null
    }
}
