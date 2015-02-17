package projetggts

class QuestionnaireCours {
	static belongsTo = [professeur: Professeur, cours: Cours];
	static hasOne = [simple: QuestionnaireSimple, detaille: QuestionnaireDetaille];

    static constraints = {
		simple nullable: false;
		detaille nullable: true;
    }
}
