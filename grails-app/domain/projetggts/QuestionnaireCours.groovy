package projetggts

class QuestionnaireCours {
	static belongsTo = [professeur: Professeur, cours: Cours];
	static hasOne = [simple: QuestionnaireSimple, detaille: QuestionnaireDetaille];

    static constraints = {
		detaille nullable: true;
    }
}
