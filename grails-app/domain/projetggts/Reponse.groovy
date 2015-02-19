package projetggts

class Reponse {
	String type;
	String reponse;

    static constraints = {
		type blank: false;
		reponse blank: false; 
    }
}
