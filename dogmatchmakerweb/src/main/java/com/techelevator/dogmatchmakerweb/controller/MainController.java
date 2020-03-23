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
		
		dog = setDreamDogAttribute(dog, questionNumber, response);
		session.setAttribute("dreamDog", dog);

		if(questionNumber ==9) {
			Dog dreamDog = getDreamDog(dog);
			map.put("dreamDog", dreamDog);
			//System.out.println("dream dog" + dreamDog.toString());
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
	
	public DreamDog setDreamDogAttribute(DreamDog dog, int questionNumber, String answer) {
		DreamDog doggo = dog;
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
