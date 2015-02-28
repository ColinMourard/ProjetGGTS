package projetggts

class QuestionnaireDetaille {
	Question firstQuestion;
	Date delai;
	static belongsTo = [questionnaire: QuestionnaireCours];

    static constraints = {
    }
}
