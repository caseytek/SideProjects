package com.techelevator.dogmatchmakerweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.dogmatchmakerweb.model.Dog;
import com.techelevator.dogmatchmakerweb.model.DogDao;
import com.techelevator.dogmatchmakerweb.model.DreamDog;
import com.techelevator.dogmatchmakerweb.model.Questions;
import com.techelevator.dogmatchmakerweb.model.QuestionsDao;

@Controller
public class MainController {

	
	@Autowired 
	QuestionsDao questionsDao;
	
	@Autowired
	DogDao dogDao;
	
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
			questionNumber = (int)session.getAttribute("questionNumber");
			session.setAttribute("questionNumber", questionNumber);
		}
		
		Questions currentQuestion = questionList.get(questionNumber);
		map.put("question", currentQuestion);
		map.put("questionNumber",  questionNumber);

		return "quiz";
	}
	
	@RequestMapping(path="/processQuestion", method=RequestMethod.POST)
	public String processQuestion(@RequestParam String response, HttpSession session,
									ModelMap map, RedirectAttributes flashValues){
		int questionNumber = (int)session.getAttribute("questionNumber");
		DreamDog dog = (DreamDog)session.getAttribute("dreamDog");
		List <Questions> questions = questionsDao.getAllQuestions();
		Questions question = questions.get(questionNumber);
		
		dog = setDreamDogAttribute(dog, question, response);
		session.setAttribute("dreamDog", dog);

		if(questionNumber ==9) {
			Dog dreamDog = getDreamDog(dog);
			map.put("dreamDog", dreamDog);
			session.invalidate();
			return "results";
		} else {
			questionNumber = (int)session.getAttribute("questionNumber") + 1;
			session.setAttribute("questionNumber", questionNumber);
		return "redirect:/quiz";
		}
	}
	
	@RequestMapping("/results")
	public String getResults() {
		return "results";
	}
	
	public DreamDog setDreamDogAttribute(DreamDog dog, Questions question, String answer) {
		DreamDog doggo = dog;
		Boolean responseBool = true;
		if(answer == "true") {
			responseBool = true;
		} else if (answer == "false") {
			responseBool = false;
		}
		
		if(question.getQuestionKey().equals("hair")) {
			dog.setHairType(answer);
		} else if (question.getQuestionKey().equals("shedding")) {
			dog.setSheddingLevel(answer);
		} else if (question.getQuestionKey().equals("size")) {
			dog.setSize(answer);
		} else if (question.getQuestionKey().equals("actlvl")) {
			dog.setActivityLevel(answer);
		} else if (question.getQuestionKey().equals("allergenic")) {
			dog.setHypoallergenic(responseBool);
		} else if (question.getQuestionKey().equals("people")) {
			dog.setGoodWithAllPeople(responseBool);
		} else if (question.getQuestionKey().equals("cats")) {
			dog.setGoodWithCats(responseBool);
		} else if (question.getQuestionKey().equals("dogs")) {
			dog.setGoodWithDogs(responseBool);
		} else if (question.getQuestionKey().equals("train")) {
			dog.setEasilyTrainable(responseBool);
		} else if (question.getQuestionKey().equals("watchdog")) {
			dog.setWatchDog(responseBool);
		}
		return doggo;
	}
	
	public Dog getDreamDog(DreamDog dreamDog) {
		List<Dog> dogList = dogDao.getAllDogs();
		Dog winner = null;
		int winnerScore = 0;
		String winnerName = null;
		for (Dog dog: dogList) {
			int score = 0;
			if(dog.getHairType().equals(dreamDog.getHairType())) {
				score++;
			} if(dog.getSheddingLevel().equals(dreamDog.getSheddingLevel())) {
				score++;
			} if(dog.getSize().equals(dreamDog.getSize())) {
				score++;
			} if(dog.getActivityLevel().equals(dreamDog.getActivityLevel())) {
				score++;
			} if(dog.isHypoallergenic() == dreamDog.isHypoallergenic()) {
				score = score+2;
			}  if(dog.isGoodWithAllPeople() == dreamDog.isGoodWithAllPeople()) {
				score++;
			}  if(dog.isGoodWithCats() == dreamDog.isGoodWithCats()) {
				score++;
			}  if(dog.isGoodWithDogs() == dreamDog.isGoodWithDogs()) {
				score++;
			}  if(dog.isEasilyTrainable() == dreamDog.isEasilyTrainable()) {
				score++;
			}  if(dog.isWatchDog() == dreamDog.isWatchDog()) {
				score++;
			} if(score > winnerScore) {
				winnerScore = score;
				winnerName = dog.getDogType();
			}
		} for (Dog dog: dogList) {
			if(winnerName.equals(dog.getDogType())) {
				winner = dog;
			}
		} return winner;
	}
}
