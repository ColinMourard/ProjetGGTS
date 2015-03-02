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
	
	static hasMany = [cours: Cours, matieres: Matiere, questionnaires: QuestionnaireCours, questionnairesElevesId: Integer];

	
    static constraints = {
		identifiant(blank: false, unique: true);
		mdp minSize: 6, password: true;
		prenom blank: false;
		nom blank: false;
		mail email: true;
		// Parametres reserve a l'eleve
		annee maxSize:1, matches: "[0-9]+";
		groupe maxSize:1, matches: "[0-9]+";
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
