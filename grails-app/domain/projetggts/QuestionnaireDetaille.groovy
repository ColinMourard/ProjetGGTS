package projetggts

class QuestionnaireDetaille {
	Question firstQuestion;
	String delai;
	static belongsTo = [questionnaire: QuestionnaireCours];

    static constraints = {
    }
}
