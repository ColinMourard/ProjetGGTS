package projetggts

class ReponseDetaille {
	ArrayList<Reponse> reponses;
	static belongsTo = [questionnaireDetaille: QuestionnaireDetaille];

    static constraints = {
    }
}
