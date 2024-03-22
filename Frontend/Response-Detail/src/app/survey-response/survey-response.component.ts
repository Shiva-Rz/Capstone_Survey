import { Component } from '@angular/core';
import { SurveyResponseService } from '../survey-response.service';
import { Question } from '../Model/Question';
import { Option } from '../Model/Option';
import { Survey } from '../Model/Suvey';
import { Page } from '../Model/Page';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Responses } from '../Model/Reponses';
import { ActivatedRoute,Params } from '@angular/router';
import { DatePipe } from '@angular/common';
import { ResponseDetail } from '../Model/ResponseDetail';

@Component({
  selector: 'app-survey-response',
  templateUrl: './survey-response.component.html',
  styleUrls: ['./survey-response.component.css']
})
export class SurveyResponseComponent {

  myForm: FormGroup;
  question: Question[]=[];
  options:Option[]=[];
  // questionList: Question[] = [];
  // pagesList:Page[]=[];
  pages:Page[]=[];
  surveyId!:number;
  // startDateAndTime!:string;
  option!: Option;
  survey:Survey;
  responsedetail:ResponseDetail;
  page:Page;
  i!:number;
  responses:Responses;
  constructor(private response: SurveyResponseService,private activatedroute:ActivatedRoute,private datePipe:DatePipe) {
    this.myForm=new FormGroup({
      optionId: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
    });
    this.survey=new Survey;
    // this.question = new Question;
    this.responsedetail=new ResponseDetail;
    this.option = new Option;
    this.page=new Page;
    this.responses=new Responses;
    

    // questions: this.response.getAllquestions();
  }

//   getquestions(data:any) {
//     this.survey.surveyId=data.surveyId;
//     this.response.getAllpages(this.survey).subscribe(page => 
//       { 
//         this.pages = page;
//         console.log(this.pages)
//   });
//   // this.page.pageId=pages.pageId;
//   this.response.getAllquestions(this.survey).subscribe(questions => 
//     { 
//       this.question = questions;
//       console.log(this.question)
// });
// this.response.getAlloptions(this.survey).subscribe(opt => 
//   { 
//     this.options = opt;
//     console.log(this.options)
// });
//   }
startDateAndTime:any;
ngOnInit():void{
 this.activatedroute.paramMap.subscribe((param:Params)=>{
  this.surveyId=param['get']("id");
  this.getquestions();
 this.startDateAndTime = this.datePipe.transform(new Date(), 'yyyy-MM-dd HH:mm:ss');
  console.log(this.startDateAndTime);
 })
}


  getquestions() {
    this.survey.surveyId=this.surveyId;
    this.response.getAllpages(this.survey).subscribe(page => 
      { 
        this.pages = page;
        console.log(this.pages)
  });
  this.response.getAllquestions(this.survey).subscribe(questions => 
    { 
      this.question = questions;
      console.log(this.question)
});
this.response.getAlloptions(this.survey).subscribe(opt => 
  { 
    this.options = opt;
    console.log(this.options)
});
  }
  endDateAndTime:any;
  insertAnswer(data:any){
    // this.option.options=data.options;
    // this.responses.responseQuestion=data.questions;
    // console.log(this.myForm.value);
    
  this.endDateAndTime = this.datePipe.transform(new Date(), 'yyyy-MM-dd HH:mm:ss');
  console.log(this.endDateAndTime);
  // alert(endDateAndTime);
  this.responsedetail.startTime=this.startDateAndTime;
  this.responsedetail.endTime=this.endDateAndTime;
  console.log(this.responsedetail);
  this.response.insertResponseDetail(this.responsedetail).subscribe({
      next: (res: any) => {
        alert("Successfully created");
      }, error: () => {
        alert("Error in creating the survey");
      }
    });
  alert( this.responsedetail.startTime)

    // this.responses.optionId=data.optionId;
    // alert(this.responses.optionId);
    // this.response.insertResponses(this.responses).subscribe({
    //   next: (res: any) => {
    //     alert("Successfully created");
    //   }, error: () => {
    //     alert("Error in creating the survey");
    //   }
    // });


  }

  




}




