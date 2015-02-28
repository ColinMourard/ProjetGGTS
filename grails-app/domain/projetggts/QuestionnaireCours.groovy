package projetggts

class QuestionnaireCours {
	Calendar delai
	static hasMany = [reponses: ReponseSimple];
	static belongsTo = [professeur: Compte, cours: Cours];
	static hasOne = [detaille: QuestionnaireDetaille];

    static constraints = {
		cours;
		question blank: false;
		delai;
		detaille nullable: true, unique: true;
		reponses nullable: true;
    }
}
