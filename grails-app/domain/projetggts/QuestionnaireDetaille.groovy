package projetggts

class QuestionnaireDetaille {
	ArrayList<HashMap<String, String>> questions;
	String delai; //Le passage int->String et String->int sera fait dans le controlleur.
	static belongsTo = [questionnaire: QuestionnaireCours];
	static hasMany = [reponses: ReponseDetaille];

    static constraints = {
		reponses nullable: true;
    }
}
