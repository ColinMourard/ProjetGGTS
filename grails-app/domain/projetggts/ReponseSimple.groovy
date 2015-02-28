package projetggts

class ReponseSimple {
	int reponse;
	static belongsTo = [questionnaireCours: QuestionnaireCours];

    static constraints = {
		reponse inList:[0,1,2,3,4,5]; 
    }
}
