import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Survey } from '../model/survey';
import { Responses } from '../model/responses';
import { Router } from '@angular/router';
import { SummaryService } from '../service/summary.service';

@Component({
  selector: 'app-response-summary',
  templateUrl: './response-summary.component.html',
  styleUrls: ['./response-summary.component.css']
})
export class ResponseSummaryComponent {

  flagresp: boolean = false;

  myForm: FormGroup;

  survey: Survey;
  response: Responses;
  // questions: Question;
  result: string = "";
  value!: number;
  ref!: number;
  // questList: Question[] = [];
  respList: Responses[] = [];


  constructor(private service: SummaryService,private router:Router) {
    // this.questions = new Question;
    this.survey = new Survey;
    this.response = new Responses;
    this.myForm = new FormGroup({
      surveyId: new FormControl('', [Validators.required, Validators.pattern('[ 0-9]+')]),
    })
  }

  ngOnInit() {
    if (!localStorage.getItem('summary')) { 
      localStorage.setItem('summary', 'no reload') 
      location.reload() 
    } else {
      localStorage.removeItem('summary') 
    }
  }

  getResponseCount(data: any) {

    // this.survey.surveyId = data.surveyId;
    // this.service.getQuestionCount(this.survey).subscribe(values => {
    //   this.value = values;
    //   console.log(this.value);
    // });
    // this.service.getAllquestions(this.survey).subscribe(question => {
    //   this.questList = question;
    //   console.log(this.questList)
    // });

    // this.service.getPagesCount(this.survey).subscribe(values => {
    //   this.ref = values;
    //   console.log(this.ref);
    // });

    this.service.getResponseDetailCount(this.survey).subscribe(values => { 
      this.ref= values;
      console.log(this.ref);
    });
    this.service.getAllResponseDetails(this.survey).subscribe(responses => { 
      this.respList= responses;
      console.log(this.respList);
    });
  }

  // getAllquestions(data: any) {
  //   this.survey.surveyId=data.surveyId
  //   this.service.getAllquestions(this.survey).subscribe(question => this.questList = question);
  // }


  responsepage() {
    this.flagresp = true;
  }


}
