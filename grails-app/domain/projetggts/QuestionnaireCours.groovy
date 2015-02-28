package projetggts

class QuestionnaireCours {
	Calendar delai
	static belongsTo = [professeur: Compte, cours: Cours];
	static hasOne = [simple: QuestionnaireSimple, detaille: QuestionnaireDetaille];

    static constraints = {
		simple unique: true;
		detaille nullable: true, unique: true;
    }
}
