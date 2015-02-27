package projetggts

class QuestionnaireCours {
	static belongsTo = [professeur: Compte, cours: Cours];
	static hasOne = [simple: QuestionnaireSimple, detaille: QuestionnaireDetaille];

    static constraints = {
		simple nullable: true, unique: true; // nullable que pour les tests
		detaille nullable: true, unique: true;
    }
}
