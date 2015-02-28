package projetggts

class QuestionnaireCours {
	Calendar delai
	static hasMany = [reponses: ReponseSimple];
	static belongsTo = [professeur: Compte, cours: Cours];
	static hasOne = [simple: QuestionnaireCours, detaille: QuestionnaireDetaille];

    static constraints = {
		simple unique: true;
		detaille nullable: true, unique: true;
    }
}
