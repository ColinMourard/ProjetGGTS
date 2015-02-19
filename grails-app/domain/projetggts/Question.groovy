package projetggts

import javax.validation.Validator;

class Question {
	String type;
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
