import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Question } from '../model/question';
import { Page } from '../model/page';
import { Survey } from '../model/survey';
import { Responses } from '../model/responses';
import { SurveyresponseService } from '../service/surveyresponse.service';
import { Option } from '../model/option';

@Component({
  selector: 'app-survey-response',
  templateUrl: './survey-response.component.html',
  styleUrls: ['./survey-response.component.css']
})
export class SurveyResponseComponent {

  myForm: FormGroup;
  question: Question[] = [];
  options: Option[] = [];
  // questionList: Question[] = [];
  // pagesList:Page[]=[];
  pages: Page[] = [];
  option!: Option;
  survey: Survey;
  responses: Responses;
  constructor(private response: SurveyresponseService) {
    this.myForm = new FormGroup({
      surveyId: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
      optionId: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
      questions: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')])
    });
    this.survey = new Survey;
    // this.question = new Question;
    this.option = new Option;
    this.responses = new Responses;

    // questions: this.response.getAllquestions();
  }

  getquestions(data: any) {
    this.survey.surveyId = data.surveyId;
    this.response.getAllpages(this.survey).subscribe(page => {
      this.pages = page;
      console.log(this.pages)
    });
    this.response.getAllquestions(this.survey).subscribe(questions => {
      this.question = questions;
      console.log(this.question)
    });
    this.response.getAlloptions(this.survey).subscribe(opt => {
      this.options = opt;
      console.log(this.options)
    });
  }

  insertAnswer(data: any) {
    // this.option.options=data.options;
    // this.responses.responseQuestion=data.questions;
    this.responses.optionId = data.optionId;
    // alert(this.responses.responseId);
    this.response.insertResponses(this.responses).subscribe({
      next: (res: any) => {
        alert("Submitted successfully");
      }, error: () => {
        alert("Answer the mandatory questions");
      }
    });


  }
}
