package projetggts

import utilitaires.Matiere;

class Cours {
	String intitule;
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
