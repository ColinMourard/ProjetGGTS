package projetggts

import utilitaires.Matiere;
import utilitaires.TypeCours;

class Cours {
	String intitule;
	TypeCours type;
	Matiere matiere;
	static hasMany = [eleves: String];
	static belongsTo = [professeur: Compte];

    static constraints = {
		intitule blank: false;
		matiere blank: false;
		type();
		eleves nullable: true;
    }
}
