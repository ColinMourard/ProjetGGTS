package projetggts

class QuestionnaireCours {
	static belongsTo = [professeur: Compte, cours: Cours];
	static hasOne = [simple: QuestionnaireSimple, detaille: QuestionnaireDetaille];

    static constraints = {
		detaille nullable: true;
    }
}
