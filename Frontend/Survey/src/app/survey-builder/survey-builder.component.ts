import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Page } from '../model/page';
import { Question } from '../model/question';
import { Option } from '../model/option';
import { SurveybuilderService } from '../service/surveybuilder.service';
import { SurveyQuestion } from '../model/surveyquestion';
import { PageValue } from '../model/PageValue';
import { QuestionValue } from '../model/QuestionValue';
import { OptionValue } from '../model/OptionValue';
import { Router } from '@angular/router';

@Component({
  selector: 'app-survey-builder',
  templateUrl: './survey-builder.component.html',
  styleUrls: ['./survey-builder.component.css']
})
export class SurveyBuilderComponent implements OnInit {

  myform!: FormGroup;
  // questionList: Question[] = [];
  totalNewQuestions = 0;
  pagevalue: PageValue;
  questionValue: QuestionValue;
  questionValueList: QuestionValue[] = [];
  optionValue: OptionValue;

  optionValueList: OptionValue[] = [];


  pages: Page[] = [];
  totalNewPages = 0;

  constructor(private fb: FormBuilder, private service: SurveybuilderService,private router:Router) {
    this.myform = this.fb.group({
      pageTitle: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
      questions: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
      optionType: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
      // questionArray: this.fb.array([this.addQuestionGroup()],[Validators.required]),
      optionArray: this.fb.array([this.addOptionGroup()], [Validators.required])


    });
    this.pagevalue = new PageValue;
    this.questionValue = new QuestionValue;
    this.optionValue = new OptionValue;
  }

  resetPage() {
    // this.myform=new FormGroup({
    //   this.pageTitle='',
    //   questions:'',
    //   // optionArray:[],
    // });
  }

  private addOptionGroup(): FormGroup {
    return this.fb.group({
      options: [, Validators.required]
    });
  }

  // private addQuestionGroup(): FormGroup {
  //   return this.fb.group({
  //     questions: ['', Validators.required],
  //     optionArray:this.fb.array([this.addOptionGroup()],[Validators.required])
  //   });
  // }

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
    this.resetPage();
    // this.myform.reset();
    // this.myform.setControl([pageTitle]'');
    // this.myform.setValue({pageTitle:''});
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
        questionId: page.question.length + 1, questionNo: page.question.length + 1,
        optionType: '',
        questions: '',
        option: [],
        pages: []
      });
    }
    // this.questionArray.push(this.addQuestionGroup());
  }

  // get questionArray(): FormArray {
  //   return <FormArray>this.myform.get('questionArray');
  // }

  //   get optionsList(){
  //     return (<FormArray>this.myform.get('optionArray')).controls
  // }

  addOption(question: Question): void {
    if (!question.option) {
      question.option = [];
    }
    if (question.option.length <= 10) {
      question.option.push({ optionId: question.option.length + 1, options: '' });
    }
    // const control= new FormControl([],[Validators.required]);
    // (<FormArray>this.myform.get('optionArray')).push(control);
    this.optionArray.push(this.addOptionGroup());
  }

  get optionArray(): FormArray {
    return <FormArray>this.myform.get('optionArray');
  }

  removePage(index: number): void {
    this.pages.splice(index, 1);
    this.totalNewPages--;
  }

  removeQuestion(page: Page, index: number): void {
    page.question.splice(index, 1);
  }

  // resetFields() {
  //   this.questions = '';
  //   this.questions
  //   this.answe = '';
  //   this.options = [];
  // }

  removeOption(question: Question, index: number): void {
    question.option.splice(index, 1);
  }

  insertValue(data: any) {

    // console.log(this.myform.value);
    // this.pagevalue.pageTitle=data.pageTitle;
    this.questionValue.questions = data.questions;
    // for(let i=0;i<this.optionArray.length-1;i++){
    //     console.log(this.optionArray);
    // }
    this.questionValue.optionType = data.optionType;
    console.log(data.optionArray.length);
    for (let i = 0; i < data.optionArray.length; i++) {
      if (data.optionArray[i].options == null) {
        console.log("null");
      }
      else {
        this.optionValue.options = data.optionArray[i].options;
        this.optionValueList.push(this.optionValue);
        this.optionValue = new OptionValue;
      }
    }
    console.log(this.optionValueList);
    this.questionValue.option = this.optionValueList;
    this.optionValueList = [];


    // this.myform=new FormGroup<any>();
    this.questionValueList.push(this.questionValue);
    console.log(this.questionValueList);
    this.questionValue = new QuestionValue;
    // this.optionArray=new O
    this.pagevalue.pageTitle = data.pageTitle;
    this.pagevalue.surveyId = 4;
    this.pagevalue.question = this.questionValueList;

    console.log(this.pagevalue);

  }

  insertPage() {

    this.service.insertPages(this.pagevalue).subscribe({
      next: (res: any) => {
        // this.router.navigate(['/create/builder']);
        alert("Successfully created");
        this.router.navigate(['/create/builder/summary']);
      }, error: () => {
        alert("Successfully created");
        this.router.navigate(['/create/builder/summary']);
      }
    });
    console.log(this.pagevalue);
    

  }
}



