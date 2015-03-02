package projetggts

import utilitaires.Matiere;
import utilitaires.TypeCompte;

class Compte {
	String identifiant;
	String mdp;
	String nom;
	String prenom;
	String mail;
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

		// Parametres reserve a l'eleve
		annee maxSize:1,validator: {val, obj ->
			if (obj.type == TypeCompte.Eleve) {
				return val.matches('[0-9]');
			}
			return val == 0;
		}
		groupe maxSize:1,validator: {val, obj ->
			if (obj.type == TypeCompte.Eleve) {
				return it.matches('[0-9]');
			}
			return val == 0;
		}
		// Parametres reserve au professeur
		questionnaires nullable: true, validator: {val, obj ->
			if (obj.type == TypeCompte.Administrateur) {
				return val == null;
			}
			return true;
		}
		cours nullable: true, validator: {val, obj ->
			if (obj.type == TypeCompte.Eleve || obj.type == TypeCompte.Administrateur) {
				return val == null;
			}
			return true;
		}
		matieres validator: {val, obj ->
			if (obj.type == TypeCompte.Eleve || obj.type == TypeCompte.Administrateur) {
				return val == null;
			}
			return val != null;
		}
    }
}
