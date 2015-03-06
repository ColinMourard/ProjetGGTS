package utilitaires;

public enum TypeCours {
	General("General"), Amphi("Amphi"), BE("BE"), PC("PC"), TD("TD"), TP("TP");
	
	private String name;
	
	private TypeCours(String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		return name;
	}
}
