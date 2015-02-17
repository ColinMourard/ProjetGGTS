package projetggts

class QuestionnaireSimple {
	String question;
	String delai; //Le passage int->String et String->int sera fait dans le controlleur.
	static belongsTo = [questionnaire: QuestionnaireCours];
	static hasMany = [reponses: ReponseSimple];

    static constraints = {
		reponses nullable: true;
    }
}
