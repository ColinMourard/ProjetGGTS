package projetggts

class QuestionnaireCours {
	String question
	Date delai
	int nombreDeReponses;//Compte le nombre de reponses simples re�ues
	double moyenne; //moyenne des notes donn�es au cours (attention la moyenne calcul�e dans reponseSimpleController n'est pas normalisee
	static hasMany = [reponses: ReponseSimple];
	static belongsTo = [professeur: Professeur, cours: Cours];
	static hasOne = [detaille: QuestionnaireDetaille];

    static constraints = {
		cours();
		question blank: false;
		delai();
		nombreDeReponses maxSize:1,matches: "[0-9]+";
		moyenne maxSize:1,matches:"[0-9]+";
		detaille nullable: true, unique: true;
		reponses nullable: true;
    }
}
