import { Component } from '@angular/core';
import { SurveyResponseService } from '../survey-response.service';
import { Question } from '../Model/Question';
import { Option } from '../Model/Option';
import { Survey } from '../Model/Suvey';
import { Page } from '../Model/Page';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-survey-response',
  templateUrl: './survey-response.component.html',
  styleUrl: './survey-response.component.css'
})
export class SurveyResponseComponent {

  myform:FormGroup;
  question: Question;
  questionList: Question[] = [];
  pagesList:Page[]=[];
  option!: Option;
  survey:Survey;
  constructor(private response: SurveyResponseService) {
    this.myform=new FormGroup({
      surveyId: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')])
    });
    this.survey=new Survey;
    this.question = new Question;
    this.option = new Option;

    // questions: this.response.getAllquestions();
  }

  getquestions(data:any) {
    this.survey.surveyId=data.surveyId
    alert(this.survey.surveyId);
    this.response.getAllquestions(this.survey).subscribe(pages => this.pagesList = pages)
  }




}




