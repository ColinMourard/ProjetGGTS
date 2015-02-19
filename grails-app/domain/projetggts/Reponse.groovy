package projetggts

class Reponse {
	String type;
	String reponse;
	static belongsTo = [question: Question];

    static constraints = {
		type blank: false;
		reponse blank: false;
		question nullable: true;
    }
}
