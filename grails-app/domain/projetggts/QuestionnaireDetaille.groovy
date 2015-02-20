package projetggts

class QuestionnaireDetaille {
//	List<HashMap<String, String>> questions;
	String delai;
	static belongsTo = [questionnaire: QuestionnaireCours];
	static hasMany = [reponses: ReponseDetaille];

    static constraints = {
		reponses nullable: true;
    }
}
