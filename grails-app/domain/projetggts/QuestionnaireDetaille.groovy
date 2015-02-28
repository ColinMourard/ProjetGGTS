package projetggts

class QuestionnaireDetaille {
	Question firstQuestion;
	Calendar delai;
	static belongsTo = [questionnaire: QuestionnaireCours];

    static constraints = {
    }
}
