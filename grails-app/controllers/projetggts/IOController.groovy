package projetggts

import java.io.File;
import jxl.*;
import jxl.write.*;

class IOController 
{
    def write(QuestionnaireCours questionnaireCours)
	{
		//Nouveau fichier Excel en sortie
		WritableWorkbook file = Workbook.createWorkbook(new File("${questionnaireCours.cours.intitule}${questionnaireCours.cours.type}.xls"));
		
		//Nouvelle feuille pour les reponses
		WritableSheet sheet = file.createSheet("Reponses",0);
		
		//Ecriture questionnaire simple dans la feuille
		Label questionSimple = new Label(0,0, "${questionnaireCours.question}");							//Cellule A1
		sheet.addCell(questionSimple);
		Label nbrRep = new Label(0,1, "Nombre de reponses : ${questionnaireCours.nombreDeReponses}");		//Cellule A2
		sheet.addCell(nbrRep);
		Label moyenne = new Label(1,1, "Moyenne : ${questionnaireCours.moyenne}/5");						//Cellule B2
		sheet.addCell(moyenne);
		
		//Ecriture questionnaire detaille dans la feuille
		Question temp = questionnaireCours.detaille.firstQuestion;
		Question next = temp.next;
		
		int i = 0;
		while (temp != null)
		{
			//Question
			Label question = new Label(i,3, "${temp.question}");
			sheet.addCell(question);
			
			//Reponses
			for(rep in temp.reponses)
			{
				Label reponse = new Label(i,j,rep);
				sheet.addCell(reponse);
				j++;
			}
			temp = next;
			next = temp.next;
			i++;
		}
		
		//Ecriture du fichier XLS et fermeture
		file.write();
		file.close()
	}
}
