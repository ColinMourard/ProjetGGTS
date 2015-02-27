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
				professeur1.save();
				if(professeur1.hasErrors()){
					println professeur1.getErrors();
				}
				
				def stats = new Cours(matiere: Matiere.Mathematiques, type: TypeCours.General, intitule: "Statistiques");
				stats.professeur = professeur1;
				stats.save();
				if(stats.hasErrors()){
					println stats.getErrors();
				}
				
				/*professeur1.cours = new HashSet<Cours>();
				professeur1.addToCompte(stats);
				professeur1.save();
				if(professeur1.hasErrors()){
					println professeur1.getErrors();
				}*/
			}
		}
    }
    def destroy = {
    }
}
