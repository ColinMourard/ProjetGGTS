package projetggts

class Question {
	String type;
	String question;

    static constraints = {
		type blank:  false;
		question blank: false;
    }
}
