package projetggts

class QuestionnaireDetaille {
	ArrayList<Question> questions;
	String delai;
	static belongsTo = [questionnaire: QuestionnaireCours];
	static hasMany = [reponses: ReponseDetaille];

    static constraints = {
		reponses nullable: true;
    }
}
