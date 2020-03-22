package com.techelevator.dogmatchmakerweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.dogmatchmakerweb.model.DreamDog;
import com.techelevator.dogmatchmakerweb.model.Questions;
import com.techelevator.dogmatchmakerweb.model.QuestionsDao;

@Controller
public class MainController {

	
	@Autowired 
	QuestionsDao questionsDao;
	
	@RequestMapping("/")
	public String displayHomePage() {
		return "homePage";
	}
	
	@RequestMapping("/quiz")
	public String displayQuiz(HttpSession session, ModelMap map) {
		
		List <Questions> questionList = questionsDao.getAllQuestions();
		DreamDog dog;
		
		if(session.getAttribute("dreamDog") == null) {
			dog = new DreamDog();
			session.setAttribute("dreamDog", dog);
		} else {
			dog = (DreamDog)session.getAttribute("dreamDog");
		}
		int questionNumber = 0;
		if(session.getAttribute("questionNumber") == null) {
		session.setAttribute("questionNumber", questionNumber);
		} else {
			questionNumber = (int)session.getAttribute("questionNumber") + 1;
			session.setAttribute("questionNumber", questionNumber);
		}
		
		Questions currentQuestion = questionList.get(questionNumber);
		map.put("question", currentQuestion);
		
		if(questionNumber == 9) {
			return "finalQuestion";
		} else {
		
		return "quiz";
		}
	}
	
	@RequestMapping(path="/processQuestion", method=RequestMethod.POST)
	public String processQuestion(@RequestParam String response, HttpSession session){
		int questionNumber = (int)session.getAttribute("questionNumber");
		DreamDog dog = (DreamDog)session.getAttribute("dreamDog");
		
		dog = setDreamDogAttribute(dog, questionNumber, response);
		session.setAttribute("dreamDog", dog);
		
		if(questionNumber ==9) {
			return "results";
		} else {
		return "redirect:/quiz";
		}
	}
	
	
	
	public DreamDog setDreamDogAttribute(DreamDog dog, int questionNumber, String answer) {
		DreamDog doggo = dog;
		List <Questions> questions = questionsDao.getAllQuestions();
		Boolean responseBool = true;
		if(answer == "true") {
			responseBool = true;
		} else if (answer == "false") {
			responseBool = false;
		}
		
		if(questionNumber == 0) {
			dog.setHairType(answer);
		} else if (questionNumber == 1) {
			dog.setSheddingLevel(answer);
		} else if (questionNumber == 2) {
			dog.setSize(answer);
		} else if (questionNumber == 3) {
			dog.setActivityLevel(answer);
		} else if (questionNumber == 4) {
			dog.setHypoallergenic(responseBool);
		} else if (questionNumber == 5) {
			dog.setGoodWithAllPeople(responseBool);
		} else if (questionNumber == 6) {
			dog.setGoodWithCats(responseBool);
		} else if (questionNumber == 7) {
			dog.setGoodWithDogs(responseBool);
		} else if (questionNumber == 8) {
			dog.setEasilyTrainable(responseBool);
		} else if (questionNumber == 9) {
			dog.setWatchDog(responseBool);
		}
		return doggo;
	}
}
