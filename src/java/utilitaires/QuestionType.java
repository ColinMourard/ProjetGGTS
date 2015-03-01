package utilitaires;

public enum QuestionType {
	Texte("Texte"), TexteObligatoire("Texte obligatoire"), NoteSur5("Note sur 5"), OuiOuNon("Oui ou non");
	
	private String name;
	
	private QuestionType(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
