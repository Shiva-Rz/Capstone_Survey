import { Component } from '@angular/core';
import { SummaryService } from '../service/summary.service';
import { Question } from '../model/question';
import { Survey } from '../model/survey';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Responses } from '../model/responses';
import { Router } from '@angular/router';

@Component({
  selector: 'app-summary-page',
  templateUrl: './summary-page.component.html',
  styleUrls: ['./summary-page.component.css']
})
export class SummaryPageComponent {

  flagpage: boolean = false;
  flagquest: boolean = false;
  flagresp: boolean = false;

  myForm: FormGroup;

  survey: Survey;
  response: Responses;
  questions: Question;
  result: string = "";
  value!: number;
  ref!: number;
  questList: Question[] = [];
  respList: Responses[] = [];


  constructor(private service: SummaryService,private router:Router) {
    this.questions = new Question;
    this.survey = new Survey;
    this.response = new Responses;
    this.myForm = new FormGroup({
      surveyId: new FormControl('', [Validators.required, Validators.pattern('[ 0-9]+')]),
    })
  }

  // ngOnInit() {
  //   if (!localStorage.getItem('summary')) { 
  //     localStorage.setItem('summary', 'no reload') 
  //     location.reload() 
  //   } else {
  //     localStorage.removeItem('summary') 
  //   }
  // }

  getQuestionCount(data: any) {

    this.survey.surveyId = data.surveyId;
    this.service.getQuestionCount(this.survey).subscribe(values => {
      this.value = values;
      console.log(this.value);
    });
    this.service.getAllquestions(this.survey).subscribe(question => {
      this.questList = question;
      console.log(this.questList)
    });

    this.service.getPagesCount(this.survey).subscribe(values => {
      this.ref = values;
      console.log(this.ref);
    });

    // this.service.getResponseDetailCount(this.survey).subscribe(values => { 
    //   this.ref= values;
    //   console.log(this.ref);
    // });
    // this.service.getAllResponseDetails(this.survey).subscribe(responses => { 
    //   this.respList= responses;
    //   console.log(this.respList);
    // });
  }

  // getAllquestions(data: any) {
  //   this.survey.surveyId=data.surveyId
  //   this.service.getAllquestions(this.survey).subscribe(question => this.questList = question);
  // }



  page() {
    this.flagpage = true;
  }

  questionpage() {
    this.flagquest = true;
  }

  responsepage() {
    this.flagresp = true;
  }


}


