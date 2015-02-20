package projetggts

import utilitaires.Matiere;

class Cours {
	String intitule;
	Matiere matiere;
	static hasMany = [eleves: Eleve];
	static belongsTo = [professeur: Professeur];

    static constraints = {
		matiere blank: false;
		intitule blank: false;
		eleves nullable: true;
    }
}
