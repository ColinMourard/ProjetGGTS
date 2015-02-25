package projetggts

import utilitaires.Matiere;
import utilitaires.TypeCours;

class Cours {
	String intitule;
	TypeCours type;
	Matiere matiere;
	static hasMany = [eleves: Compte];
	static hasOne = [professeur: Compte];
	static belongsTo = Compte;

    static constraints = {
		matiere blank: false;
		intitule blank: false;
		eleves nullable: true;
    }
}
