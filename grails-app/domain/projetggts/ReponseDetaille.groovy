package projetggts

class ReponseDetaille {
	ArrayList<HashMap<String, String>> reponses;
	static belongsTo = [questionnaireDetaille: QuestionnaireDetaille];

    static constraints = {
    }
}
