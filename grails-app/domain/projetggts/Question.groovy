package projetggts

import javax.validation.Validator;
import utilitaires.QuestionType

class Question {
	QuestionType type;
	String question;
	Question next;
	static hasMany = [reponses: Reponse];
	static belongsTo = [precedent: Question];
    static constraints = {
		type blank:  false;
		question blank: false;
		next validator: {val, obj ->
			return val != obj;
		}
		reponses nullable: true;
		precedent nullable: true;
    }
}
