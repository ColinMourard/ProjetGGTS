package projetggts

import utilitaires.Matiere;

class Professeur {
	static hasOne = [compte: Compte];
	static hasMany = [cours: Cours, matieres: Matiere, questionnaires: QuestionnaireCours];

    static constraints = {
    }
}
