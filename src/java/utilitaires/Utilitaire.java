package utilitaires;

import java.util.Calendar;

public class Utilitaire {
	public static Calendar delai(int month,int day,int hour,int minuts){
		Calendar result = Calendar.getInstance();
		//Cr�ation de l'ann�e en cours
		int year = result.YEAR;
		result.set(year,month,day,hour,minuts);
		return result;
	}
}
