package projetggts

class Question {
	String type;
	String question;
	Question next;
	static hasMany = [reponses: Reponse];

    static constraints = {
		type blank:  false;
		question blank: false;
		next nullable: true;
		reponses nulllable: true;
    }
}
