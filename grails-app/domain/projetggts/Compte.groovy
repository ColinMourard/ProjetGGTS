package projetggts

import utilitaires.Matiere;
import utilitaires.TypeCompte;

class Compte {
	String identifiant;
	String mdp;
	String nom;
	String prenom;
	String mail;
	TypeCompte type;
	boolean estConnecte;
	
	int annee;
	int groupe;
	
	static hasMany = [cours: Cours, matieres: Matiere, questionnaires: QuestionnaireCours];

	
    static constraints = {
		identifiant(blank: false, unique: true);
		mdp minSize: 6;
		nom blank: false;
		prenom blank: false;
		mail email: true;
		
		annee(maxSize:1,validator: {return it.matches("[0-9]+")});
		groupe(maxSize:1,validator: {return it.matches("[0-9]+")});
		
		questionnaires nullable: true;
		cours nullable: true;
    }
}
