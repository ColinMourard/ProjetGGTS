package projetggts

class ReponseDetaille {
//	List<HashMap<String, String>> reponses;
	static belongsTo = [questionnaireDetaille: QuestionnaireDetaille];

    static constraints = {
    }
}
