import projetggts.Question
import utilitaires.QuestionType;

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
			}
		}
    }
    def destroy = {
    }
}
