package projetggts

class QuestionnaireCours {
	Calendar delai
	static hasMany = [reponses: ReponseSimple];
	static belongsTo = [professeur: Compte, cours: Cours];
	static hasOne = [detaille: QuestionnaireDetaille];

    static constraints = {
<<<<<<< HEAD
		cours;
		question blank: false;
		delai;
=======
		simple unique: true;
>>>>>>> branch 'Questionnaire' of https://github.com/ColinMourard/ProjetGGTS.git
		detaille nullable: true, unique: true;
<<<<<<< HEAD
		reponses nullable: true;
=======
>>>>>>> branch 'Questionnaire' of https://github.com/ColinMourard/ProjetGGTS.git
    }
}
