import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Page } from '../model/page';
import { Question } from '../model/question';
import { Option } from '../model/option';
import { SurveybuilderService } from '../service/surveybuilder.service';
import { SurveyQuestion } from '../model/surveyquestion';

@Component({
  selector: 'app-survey-builder',
  templateUrl: './survey-builder.component.html',
  styleUrls: ['./survey-builder.component.css']
})
export class SurveyBuilderComponent implements OnInit {

  myForm!: FormGroup;
  questions: Question[] = [];
  totalNewQuestions = 0;

  pages: Page[] = [];
  totalNewPages = 0;

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    if (!localStorage.getItem('builder')) {
      localStorage.setItem('builder', 'no reload')
      location.reload()
    } else {
      localStorage.removeItem('builder')
    }
  }

  // ngOnInit(): void {
  //   this.myForm = this.fb.group({
  //     title: ['']
  //   });
  // }

  addNewPages(): void {
    if (this.totalNewPages < 3) {
      const newPage: Page = {
        pageId: this.pages.length + 1,
        pageNo: this.pages.length + 1,
        pageTitle: '',
        question: []
      };
      this.pages.push(newPage);
      this.totalNewPages++;
    }
  }

  // addNewQuestion(): void {
  //   if (this.totalNewQuestions <= 15) {
  //     const newQuestion: Question = {
  //       questionId: this.questions.length + 1,
  //       questionNo: this.questions.length + 1,
  //       questions: '',
  //       optionType: '',
  //       option: []
  //     };
  //     this.questions.push(newQuestion);
  //     this.totalNewQuestions++;
  //   }
  // }

  addNewQuestion(page: Page): void {
    if (!page.question) {
      page.question = [];
    }
    if (page.question.length < 15) {
      page.question.push({
        questionId: page.question.length + 1, questionNo: page.question.length + 1, questions: '',
        optionType: '',
        option: [],
        pages: []
      });
    }
  }

  addOption(question: Question): void {
    if (!question.option) {
      question.option = [];
    }
    if (question.option.length <= 10) {
      question.option.push({ optionId: question.option.length + 1, options: '' });
    }
  }

  removePage(index: number): void {
    this.pages.splice(index, 1);
    this.totalNewPages--;
  }

  removeQuestion(page: Page, index: number): void {
    page.question.splice(index, 1);
  }

  removeOption(question: Question, index: number): void {
    question.option.splice(index, 1);
  }

 

}