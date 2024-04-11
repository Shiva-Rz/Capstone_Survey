import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Question } from '../model/question';
import { Page } from '../model/page';
import { Survey } from '../model/survey';
import { Responses } from '../model/responses';
import { SurveyresponseService } from '../service/surveyresponse.service';
import { Option } from '../model/option';
import { ActivatedRoute, Params } from '@angular/router';
import { Questions } from '../model/Questions';
import { Options } from '../model/Options';
import { Ref } from '../model/Ref';
import { RefOption } from '../model/RefOption';
import { RefQuestion } from '../model/RefQuestion';
import { ResponseDetail } from '../model/ResponseDetail';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-survey-response',
  templateUrl: './survey-response.component.html',
  styleUrls: ['./survey-response.component.css']
})
export class SurveyResponseComponent {

  flag: boolean = true;
  myForm: FormGroup;
  question: Questions[] = [];
  options: Options[] = [];
  // questionList: Question[] = [];
  // pagesList:Page[]=[];
  SingleChoiceOptions: Option[] = [];
  MultiChoiceOptions: Option[] = [];
  StringList: String[] = [];
 
  ReferenceList: Ref[] = []
  reference: Ref;
  referenceOption: RefOption;
  referenceQuestion: RefQuestion;
  referenceOptionList: RefOption[] = [];

  responseDetailId:any=0;
 
  num1: number = 0;
  num: number = 0;
  pages: Page[] = [];
  surveyId!: number;
  // option!: Option;
  survey: Survey;
  page: Page;
  i!: number;
  responses: Responses;
  dropdownOptions = [];
  // selectedOptions = [];
  selectedOptions: number[] = [];
 
  div1: boolean = false;
  quest: Question;
 
  startDateAndTime:any;
  responseDetail:ResponseDetail;
  endDateAndTime:any;
  responsesList:Responses[]=[];
  userId:any=0;
 
 
  constructor(private response: SurveyresponseService, private activatedroute: ActivatedRoute, private fb: FormBuilder, private datePipe: DatePipe) {
    this.myForm = new FormGroup({
      optionId: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
 
    });
    this.survey = new Survey;
    // this.question = new Question;
    // this.option = new Option;
    this.page = new Page;
    this.responseDetail = new ResponseDetail;
    this.reference = new Ref;
    this.referenceOption = new RefOption;
    this.referenceQuestion = new RefQuestion;
    this.responses = new Responses;
    this.quest = new Question;
    this.userId=sessionStorage.getItem("userId") || "";
 
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
 
 
 
  ngOnInit(): void {
    this.activatedroute.paramMap.subscribe((param: Params) => {
      this.surveyId = param['get']("id");
      console.log(this.surveyId);
      this.getquestions()
      this.startDateAndTime = this.datePipe.transform(new Date(), 'yyyy-MM-dd HH:mm:ss');
      console.log(this.startDateAndTime);
 
    })
  }
 
 
 
 
  getquestions() {
    this.survey.surveyId = this.surveyId;
    this.response.getSurvey(this.survey).subscribe(survey => {
      this.survey = survey;
      console.log(this.survey);
    });
    this.response.getAllpages(this.survey).subscribe(page => {
      this.pages = page;
      console.log(this.pages);
 
    });
 
    this.response.getAllquestions(this.survey).subscribe(questions => {
      this.question = questions;
      console.log(this.question);
 
    });
    this.response.getAlloptions(this.survey).subscribe(opt => {
      this.options = opt;
      console.log(this.options)
    });
 
  }
 
  submit() {
    this.endDateAndTime = this.datePipe.transform(new Date(), 'yyyy-MM-dd HH:mm:ss');
    console.log(this.endDateAndTime);
 
    this.responseDetail.userId = this.userId;
    this.responseDetail.surveyId = this.surveyId;
    this.responseDetail.startTime = this.startDateAndTime;
    this.responseDetail.endTime = this.endDateAndTime;
    console.log(this.responseDetail);
    console.log(this.responsesList);
    this.response.insertResponseDetails(this.responseDetail).subscribe(
          (response: any) => {
            // alert("Successfully created");
            sessionStorage.setItem("responseDetailId",response.message);
            console.log("Inserted");
            this.responseDetailId=sessionStorage.getItem("responseDetailId") || "";
        console.log(this.responseDetailId);
            for (let i = 0; i < this.responsesList.length; i++) {
              console.log(this.responsesList[i]);
              this.responsesList[i].responseDetailId=this.responseDetailId;
              this.response.insertResponses(this.responsesList[i]).subscribe({
                  next: (res: any) => {
                    // alert("Successfully created");
                    console.log("Inserted");
                  }, error: () => {
                    // alert("Error in creating the survey");
                    console.log("Not");
                  }
                });
            }
          
          }, (error:any) => {
            // alert("Error in creating the survey");
            console.log("Not");
          }
        );
        
    
    alert("Response Submitted");
 
  }
 
  insertAnswer(data: any) {
    // this.option.options=data.options;
    // this.responses.responseQuestion=data.questions;
    // this.responses.optionId = data.optionId;
    console.log(data.optionId);
    if (data.optionId == true) {
      //  for(let i=0;i<this.selectedOptions.length;i++){
      this.responses.optionType = "Checkbox";
      this.responses.optionId = 10;
      this.responses.option = this.selectedOptions;
      console.log(this.responses);
      //  }
    }
     else {
      this.responses.optionType = "Radio";
      this.responses.optionId = data.optionId;
      console.log(this.responses);
    }
    this.responsesList.push(this.responses);
    console.log(this.responsesList);
    this.responses = new Responses;
    // this.response.insertResponses(this.responses).subscribe({
    //   next: (res: any) => {
    //     // alert("Successfully created");
    //   }, error: () => {
    //     // alert("Error in creating the survey");
    //   }
    // });
 
    console.log(data.optionId);
    // alert(this.responses.responseId);
     console.log(this.responses);
    this.selectedOptions = [];
    this.myForm.reset();
 
  }
 
 
  nextPage() {
    this.num = this.num + 1;  //Page
 
  }
 
  nextQuestion() {
    // if(this.num == 0 && this.num1==null){
    //   this.num1=this.num1+1;
    // }
 
    this.num1 = this.num1 + 1;  //Question
 
  }
 
 
  decnum(i: number) {
    this.i = this.i - 1;
    this.num = this.num - 1;
  }
 
 
 
  // previousPage(pages: number){
  //   this.activePage = pages + 1;
  // }
 
 
  showPageIndex(pageIndex: Page) {
    this.page = pageIndex;
    console.log(this.page);
  }
 
  div1Function() {
    this.div1 = !this.div1;
    // this.div1=true;
  }
 
 
  onCheckboxChange(optionId: number, event: any) {
    if (event.target.checked) {
      console.log(this.selectedOptions);
      this.selectedOptions.push(optionId);
    } else {
      const index = this.selectedOptions.indexOf(optionId);
      if (index >= 0) {
        this.selectedOptions.splice(index, 1);
      }
    }
  }
}