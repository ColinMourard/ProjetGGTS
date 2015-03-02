package projetggts

class Compte {
	String identifiant;
	String mdp;
	String nom;
	String prenom;
	String mail;
	boolean estConnecte;
	static belongsTo = [admin: Administrateur, eleve: Eleve, professeur: Professeur];

    static constraints = {
		admin nullable: true;
		eleve nullable: true;
		professeur nullable: true;
		identifiant(blank: false, unique: true);
		mdp minSize: 6;
		nom blank: false;
		prenom blank: false;
		mail email: true;
    }
}
