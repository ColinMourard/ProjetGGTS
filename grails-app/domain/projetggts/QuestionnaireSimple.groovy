package projetggts

class QuestionnaireSimple {
	String question;
	String delai;
	static belongsTo = [questionnaire: QuestionnaireCours];
	static hasMany = [reponses: ReponseSimple];

    static constraints = {
		reponses nullable: true;
    }
}
