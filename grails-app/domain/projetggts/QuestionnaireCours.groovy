package projetggts

class QuestionnaireCours {
	String question;
	Calendar delai;
	static hasMany = [reponses: ReponseSimple];
	static belongsTo = [professeur: Compte, cours: Cours];
	static hasOne = [detaille: QuestionnaireDetaille];

    static constraints = {
		detaille nullable: true, unique: true;
		reponses nullable: true;
		question blank: false;
    }
}
