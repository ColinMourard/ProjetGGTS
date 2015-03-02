package projetggts

class QuestionnaireCours {
	static belongsTo = [professeur: Professeur, cours: Cours];
	static hasOne = [simple: QuestionnaireSimple, detaille: QuestionnaireDetaille];

    static constraints = {
		simple unique: true;
		detaille nullable: true, unique: true;
    }
}
