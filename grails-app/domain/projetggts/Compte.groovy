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
	int nouveauQuestionnaire;//0 si pas de nouveau Questionnaire à remplir et 1 sinon
	int nouvelleReponseSimple;//idem que nouveauQuestionnaire mais avec les profs
	
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
		nouveauQuestionnaire maxSize:1,matches: "[0-9]+";
		// Parametres reserve au professeur
		nouvelleReponseSimple maxSize:1,matches: "[0-9]+";
		
		questionnaires nullable: true, validator: {val, obj ->
			if (obj.type == TypeCompte.Administrateur) {
				return val == null;
			}
			return true;
		}
		cours nullable: true, validator: {val, obj ->
			if (obj.type == TypeCompte.Eleve || obj.type == TypeCompte.Administrateur) {
				return val == null || val.isEmpty();
			}
			return true;
		}
		matieres validator: {val, obj ->
			if (obj.type == TypeCompte.Eleve || obj.type == TypeCompte.Administrateur) {
				return val == null || val.isEmpty();
			}
			return val != null;
		}
    }
}
