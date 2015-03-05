package projetggts

import utilitaires.QuestionType

class Reponse {
	String reponse;
	static belongsTo = [question: Question];

    static constraints = {
		reponse validator: {val, obj ->
			if (obj.question.type == QuestionType.TexteObligatoire) {
				return val != null || !val.equals("");
			}
			if (obj.question.type == QuestionType.OuiOuNon) {
				return val.equals("Oui") || val.equals("Non");
			}
			if (obj.question.type == QuestionType.NoteSur5) {
				return val.equals("0") || val.equals("1") || val.equals("2") || val.equals("3") || val.equals("4") || val.equals("5");
			}
		}
    }
}
