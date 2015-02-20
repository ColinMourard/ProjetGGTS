package projetggts

import javax.validation.Validator;
import utilitaires.QuestionType

class Question {
	QuestionType type;
	String question;
	Question next;
	static hasMany = [reponses: Reponse];

    static constraints = {
		type blank:  false;
		question blank: false;
		next nullable: true;
		reponses nullable: true;
    }
}
