package com.Hoda.overflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Hoda.overflow.models.Answers;
import com.Hoda.overflow.models.Newq;
import com.Hoda.overflow.models.Questions;
import com.Hoda.overflow.services.AnswersService;
import com.Hoda.overflow.services.QuestionsService;
import com.Hoda.overflow.services.TagService;

@Controller
@RequestMapping("/questions")
public class Control {
	private final AnswersService answerservice;
	private final QuestionsService questionservice;
	private final TagService tagservice;

	public Control(AnswersService answerservice, QuestionsService questionservice, TagService tagservice) {
		this.answerservice = answerservice;
		this.questionservice = questionservice;
		this.tagservice = tagservice;
	}

	@RequestMapping("")
	public String index(Model model) {
		List<Questions> questions = questionservice.allquestions();
		model.addAttribute("questions", questions);
		return "all.jsp";
	}

	@RequestMapping("/new")
	public String newq(@ModelAttribute("newQuest") Newq newQuest,Model model) {
		return "newq.jsp";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String newqq(@Valid @ModelAttribute("newQuest") Newq newQuest, BindingResult result) {
		if (result.hasErrors())
			return "newq.jsp";
		this.questionservice.createquestion(newQuest);
		return "redirect:/questions";
	}

	@RequestMapping("/{id}")
	public String nn(@PathVariable("id") Long id, Model model, @ModelAttribute("ans") Answers ans) {
		Questions q = questionservice.findquestion(id);
		model.addAttribute("question", q);
		return "two.jsp";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String newqq(@Valid @ModelAttribute("ans") Answers ans, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors())
			return "two.jsp";
		Answers newAnswer = this.answerservice.createanswer(ans);
		return "redirect:/questions/" + id;
	}
}
