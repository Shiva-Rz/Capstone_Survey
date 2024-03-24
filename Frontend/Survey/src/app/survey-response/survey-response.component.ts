import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Question } from '../model/question';
import { Page } from '../model/page';
import { Survey } from '../model/survey';
import { Responses } from '../model/responses';
import { SurveyresponseService } from '../service/surveyresponse.service';
import { Option } from '../model/option';
import { ActivatedRoute, Params } from '@angular/router';
import { Ref } from '../model/Ref';
import { RefOption } from '../model/RefOption';
import { RefQuestion } from '../model/RefQuestion';
import { Options } from '../model/Options';
import { Questions } from '../model/Questions';

@Component({
  selector: 'app-survey-response',
  templateUrl: './survey-response.component.html',
  styleUrls: ['./survey-response.component.css']
})
export class SurveyResponseComponent {

  flag:boolean=true;
  myForm: FormGroup;
  question: Questions[]=[];
  options:Options[]=[];
  // questionList: Question[] = [];
  // pagesList:Page[]=[];
  SingleChoiceOptions:Option[]=[];
  MultiChoiceOptions:Option[]=[];
  StringList:String[]=[];

  ReferenceList:Ref[]=[]
  reference:Ref;
  referenceOption:RefOption;
  referenceQuestion:RefQuestion;
  referenceOptionList:RefOption[]=[];

  num1:number=0;
  num:number = 0;
  pages:Page[]=[];
  surveyId!:number;
  // option!: Option;
  survey:Survey;
  page:Page;
  i!:number;
  responses:Responses;
  dropdownOptions = [];
  selectedOptions = [];

  div1:boolean=false;
  quest:Question;



  constructor(private response: SurveyresponseService,private activatedroute:ActivatedRoute,private fb: FormBuilder) {
    this.myForm=new FormGroup({
      optionId: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),

    });
    this.survey=new Survey;
    // this.question = new Question;
    // this.option = new Option;
    this.page=new Page;
    this.reference=new Ref;
    this.referenceOption=new RefOption;
    this.referenceQuestion=new RefQuestion;
    this.responses=new Responses;
    this.quest=new Question;


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



ngOnInit():void{
 this.activatedroute.paramMap.subscribe((param:Params)=>{
  this.surveyId=param['get']("id");
  this.getquestions()

  
 })
}




  getquestions() {
    this.survey.surveyId=this.surveyId;
    this.response.getAllpages(this.survey).subscribe(page => 
      { 
        this.pages = page;
        console.log(this.pages);
        
  });

  this.response.getAllquestions(this.survey).subscribe(questions => 
    { 
      this.question = questions;
      console.log(this.question);
      
});
this.response.getAlloptions(this.survey).subscribe(opt => 
  { 
    this.options = opt;
    console.log(this.options)
});
// console.log(this.question);
// for(let i=0;i<this.question.length;i++){
//         // console.log(this.question);
//         if(this.question[i].optionType=="Dropdown"){
//           // console.log(this.question[i].questionId);
//           this.quest.questionId=this.question[i].questionId;
//           //  console.log(this.quest);
//           // console.log(this.question[i]["option"]);
//           //       this.options ;
          
//                 this.reference.questionId=this.question[i].questionId; 
//                 this.reference.questions=this.question[i].questions;
//                 this.reference.optionType=this.question[i].optionType;
//                 this.reference.questionNo=this.question[i].questionNo;
//                 this.reference.pageId=this.question[i].pageId;
//                 // this.reference.option=this.question[i].option;
//                 console.log(this.reference);
//                 this.ReferenceList.push(this.reference);
//                 this.reference=new Ref;
//                 console.log(this.ReferenceList);
                
//                this.options;
//                 for(let j=0;j<this.options.length;j++){
//                  if(this.question[i].questionId==this.options[j].questionId){
//                   // this.
//                   this.referenceOption.optionId=this.options[j].optionId;
//                   this.referenceOption.options=this.options[j].options;
//                   this.referenceOption.questionId=this.options[j].questionId;
//                   // console.log(this.referenceOption);
//                   // this.StringList.push(this.referenceOption);
//                   // this.reference.option=this.referenceOption;
//                   this.referenceOptionList.push(this.referenceOption);
//                   console.log(this.referenceOptionList);
//                 //   console.log( this.reference.option.push(this.referenceOption));
//                 //  console.log( this.reference.option.push(this.referenceOption));
                  
//                  this.referenceOption=new RefOption;
//                 }
               
//               }
                
//                 // this.reference.option.push(this.referenceOption);
//                 // console.log(this.reference);
              
                
//                   // this.reference.option.push(this.referenceOption);
    
               
                

//         }
// }

  }

  // getValue(){
  //     this.question
  //     console.log(this.question);
  //     for(let i=0;i<this.question.length;i++){
  //       console.log("A");
  //     }
  // }


  insertAnswer(data:any){
    // this.option.options=data.options;
    // this.responses.responseQuestion=data.questions;
    this.responses.optionId=data.optionId;
    
    console.log(data.optionId);
    // alert(this.responses.responseId);
   console.log(this.responses);
   this.myForm.reset();
    // this.response.insertResponses(this.responses).subscribe({
    //   next: (res: any) => {
    //     alert("Successfully created");
    //   }, error: () => {
    //     alert("Error in creating the survey");
    //   }
    // });


  }

 

  
  nextPage(){
    this.num=this.num+1;  //Page
    
  }

  nextQuestion(){
    // if(this.num == 0 && this.num1==null){
    //   this.num1=this.num1+1;
    // }

      this.num1=this.num1+1;  //Question
  
  }


  decnum(i:number){
    this.i=this.i-1;
    this.num=this.num-1;
  }



  // previousPage(pages: number){
  //   this.activePage = pages + 1;
  // }


  showPageIndex(pageIndex: Page){
    this.page = pageIndex;
    console.log(this.page);
  }

  div1Function(){
    this.div1=!this.div1;
    // this.div1=true;
}


}
