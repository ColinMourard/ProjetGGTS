
import projetggts.Question
import utilitaires.QuestionType;
import projetggts.Compte
import projetggts.Cours
import utilitaires.Matiere;
import utilitaires.TypeCompte;
import utilitaires.TypeCours;

class BootStrap {

    def init = { servletContext ->

		environments{
			development{
				// Premiere serie de question
				def finalQuestion = new Question(type: QuestionType.Texte, question: "Avez-vous des remarques sur ce cours ?");
				finalQuestion.save();
				if(finalQuestion.hasErrors()){
					println finalQuestion.getErrors();
				}
				def secondQuestion = new Question(type: QuestionType.OuiOuNon, question: "Souhaitez-vous une reunion bilan ?", next: finalQuestion);
				secondQuestion.save();
				if(secondQuestion.hasErrors()){
					println secondQuestion.getErrors();
				}
				def firstQuestion = new Question(type: QuestionType.NoteSur5, question: "Quelle note donneriez-vous à ce cours ?", next: secondQuestion);
				firstQuestion.save();
				if(firstQuestion.hasErrors()){
					println firstQuestion.getErrors();
				}
				// Seconde serie de question (la meme mais en anglais)
				def finalQuestionEnglish = new Question(type: QuestionType.Texte, question: "Do you have any remarks on this class?");
				finalQuestionEnglish.save();
				if(finalQuestionEnglish.hasErrors()){
					println finalQuestionEnglish.getErrors();
				}
				def secondQuestionEnglish = new Question(type: QuestionType.OuiOuNon, question: "Would you like a status meeting?", next: finalQuestionEnglish);
				secondQuestionEnglish.save();
				if(secondQuestionEnglish.hasErrors()){
					println secondQuestionEnglish.getErrors();
				}
				def firstQuestionEnglish = new Question(type: QuestionType.NoteSur5, question: "How would you mark this class?", next: secondQuestionEnglish);
				firstQuestionEnglish.save();
				if(firstQuestionEnglish.hasErrors()){
					println firstQuestionEnglish.getErrors();
				}
				
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
				def administrateur = new Compte(identifiant: "admin", mdp: "password", nom: "Istrateur", prenom: "Admin", mail: "admin.istrateur@isae.fr", type : TypeCompte.Administrateur, annee: 0, groupe: 0);
				administrateur.save();
				if(administrateur.hasErrors()){
					println administrateur.getErrors();
				}
			}
		}
    }
    def destroy = {
    }
}
