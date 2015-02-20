package projetggts

import utilitaires.QuestionType

class Reponse {
	QuestionType type;
	String reponse;
	static belongsTo = [question: Question];

    static constraints = {
		type blank: false;
		reponse validator: {val, obj ->
			if (obj.type == QuestionType.TexteObligatoire) {
				return val != null || !val.equals("");
			}
			if (obj.type == QuestionType.OuiOuNon) {
				return val.equals("Oui") || val.equals("Non");
			}
			if (obj.type == QuestionType.NoteSur5) {
				return val.equals("0") || val.equals("1") || val.equals("2") || val.equals("3") || val.equals("4") || val.equals("5");
			}
		}
		question nullable: true;
    }
}
