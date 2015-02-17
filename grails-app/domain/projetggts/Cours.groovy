package projetggts

import utilitaires.Matiere;

class Cours {
	String intitule;
	static hasMany = [eleves: Eleve];
	static belongsTo = [professeur: Professeur];
	static hasOne = [matiere: Matiere];

    static constraints = {
    }
}
