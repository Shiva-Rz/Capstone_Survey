import { Component } from '@angular/core';
import { SummaryService } from '../service/summary.service';
import { Question } from '../model/question';
import { Survey } from '../model/survey';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-summary-page',
  templateUrl: './summary-page.component.html',
  styleUrls: ['./summary-page.component.css']
})
export class SummaryPageComponent {

  flagpage: boolean = false;
  flagquest: boolean = false;
  flagresp: boolean = false;

  myForm:FormGroup;

  survey:Survey;

  questions: Question;
  result: string = "";
  value!:number;
  ref!:number;
  questList: Question[] = [];
  respList: Response[] = [];

  constructor(private service: SummaryService) {
    this.questions = new Question;
    this.survey=new Survey;
    this.myForm= new FormGroup ({
      surveyId: new FormControl('', [Validators.required, Validators.pattern('[ 0-9]+')]),
    })
  }

  getQuestionCount(data:any){
    this.survey.surveyId=data.surveyId;
    this.service.getQuestionCount(this.survey).subscribe(values => { 
      this.value= values;
      console.log(this.value);
    });
    this.service.getAllquestions(this.survey).subscribe(question =>{ 
      this.questList = question;
      console.log(this.questList)
    });
    this.service.getResponseDetailCount(this.survey).subscribe(values => { 
      this.ref= values;
      console.log(this.ref);
    });
  }

  // getAllquestions(data: any) {
  //   this.survey.surveyId=data.surveyId
  //   this.service.getAllquestions(this.survey).subscribe(question => this.questList = question);
  // }

  getAllresponses(data: any) {
    this.service.getAllresponses().subscribe(response => this.respList = response);
  }



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
