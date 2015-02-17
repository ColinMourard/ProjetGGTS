package projetggts

class Eleve {
	int annee;
	int groupe;
	static hasOne = [compte: Compte];

    static constraints = {
		annee(maxSize:1,validator: {return it.matches("[0-9]+")});
		groupe(maxSize:1,validator: {return it.matches("[0-9]+")});
    }
}
