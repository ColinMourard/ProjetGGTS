package projetggts

import utilitaires.Matiere;
import utilitaires.TypeCours;

class Cours {
	String intitule;
	TypeCours type;
	Matiere matiere;
	static hasMany = [eleves: Eleve];
	static belongsTo = [professeur: Professeur];

    static constraints = {
		matiere blank: false;
		intitule blank: false;
		eleves nullable: true;
    }
}
