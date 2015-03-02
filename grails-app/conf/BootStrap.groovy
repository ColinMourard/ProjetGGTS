import projetggts.Compte
import projetggts.Cours
import utilitaires.Matiere;
import utilitaires.TypeCompte;
import utilitaires.TypeCours;

class BootStrap {

    def init = { servletContext ->
		environments{
			development{
				def professeur1 = new Compte(identifiant: "prof", mdp: "password", nom: "Professeur", prenom: "Professeur", mail: "prof@isae.fr", type: TypeCompte.Professeur, annee: 0, groupe: 0);
				professeur1.matieres = new HashSet<Matiere>();
				professeur1.matieres.add(Matiere.Mathematiques);
				professeur1.addToCours(new Cours(matiere: Matiere.Mathematiques, type: TypeCours.General, intitule: "Statistiques"));
				professeur1.addToCours(new Cours(matiere: Matiere.Mathematiques, type: TypeCours.General, intitule: "Probabilites"));
				professeur1.save();
				if(professeur1.hasErrors()){
					println professeur1.getErrors();
				}
				def professeur2 = new Compte(identifiant: "prof2", mdp: "password", nom: "Professeur", prenom: "Professeur", mail: "prof@isae.fr", type: TypeCompte.Professeur, annee: 0, groupe: 0);
				professeur2.matieres = new HashSet<Matiere>();
				professeur2.matieres.add(Matiere.Mathematiques);
				professeur2.addToCours(new Cours(matiere: Matiere.Mathematiques, type: TypeCours.General, intitule: "Distributions"));
				professeur2.save();
				if(professeur2.hasErrors()){
					println professeur2.getErrors();
				}
			}
		}
    }
    def destroy = {
    }
}
