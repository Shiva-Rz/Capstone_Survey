// builder.component.ts

import { Component } from '@angular/core';
import { SurveyQuestion } from './Model/SurveyQuestion';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { BuilderService } from '../builder.service';
import { Page } from './Model/Page';
import { Question } from './Model/Question';
import { Option } from './Model/Option';

@Component({
  selector: 'app-builder',
  templateUrl: './builder.component.html',
  styleUrls: ['./builder.component.css']
})
export class BuilderComponent {
  myForm:FormGroup;
  pages:Page;
  question:Question;
  quest=[];
  option:Option;
  pgs:Page[]=[];
  opts:Option[]=[];
  surveyPages: any[] = [{ index: 1, questions: [] }];
  currentPageIndex: number = 0;
  editorVisible: boolean = false;
  selectedFieldType: string = '';
  questionText: string = '';
  answerText: string = '';
  options: string[] = []; // Added options array
  selectedDropdownOption: string = '';
  successMessage: string = '';
  showPlaceholder: { [key: number]: boolean } = {};
  dragOverPage: number | null = null;
  

  constructor(private _fb: FormBuilder,private service:BuilderService) {
    
    this.initPlaceholderVisibility();
    this.pages=new Page;
    this.question=new Question;
    this.option=new Option;
    this.myForm=new FormGroup({
      pageTitle: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
      options: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
      questions: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')])
    });
    // this.myForm = this._fb.group({
    //   pageTitle: new FormControl('', [Validators.required, Validators.maxLength(50)]),
    //   pageArray: this._fb.array([this.addPageGroup()], [Validators.required]),
    //   // questionArray: this._fb.array([this.addQuestionGroup()], [Validators.required]),
    //   // optionArray: this._fb.array([this.addPageGroup()], [Validators.required]),
    // });
  }

  // private addPageGroup(): FormGroup {
  //   return this._fb.group({
  //     pageTitle: ['', Validators.required],
  //     quest: ['', Validators.required]
  //   });
  // }
 
  // get pageArray(): FormArray {
  //   return <FormArray>this.myForm.get('pageArray');
  // }

  // addPages() :void {
  //   this.pageArray.push(this.addPageGroup());
  // }

  // private addQuestionGroup(): FormGroup {
  //   return this._fb.group({
  //     questions: ['', Validators.required]
  //   });
  // }
 
  // get questionArray(): FormArray {
  //   return <FormArray>this.myForm.get('questionArray');
  // }

  // addquestion() :void {
  //   this.questionArray.push(this.addQuestionGroup());
  // }

  // private addOptionGroup(): FormGroup {
  //   return this._fb.group({
  //     options: ['', Validators.required]
  //   });
  // }
 
  // get optionArray(): FormArray {
  //   return <FormArray>this.myForm.get('optionArray');
  // }

  // addoptions() :void {
  //   this.optionArray.push(this.addOptionGroup());
  // }

  initPlaceholderVisibility() {
    this.surveyPages.forEach((_, index) => {
      this.showPlaceholder[index] = true;
    });
  }

  onDragStart(event: any, type: string) {
    event.dataTransfer.setData('type', type);
  }

  onDragOver(event: any, pageIndex: number) {
    event.preventDefault();
    this.dragOverPage = pageIndex;
  }

  onDragEnter(pageIndex: number) {
    this.dragOverPage = pageIndex;
  }

  onDragLeave(pageIndex: number) {
    if (this.dragOverPage === pageIndex) {
      this.dragOverPage = null;
    }
  }

  onDrop(event: any, pageIndex: number, fieldType: string) {
    event.preventDefault();
    const type = event.dataTransfer.getData('type');
    this.selectedFieldType = this.getAnswerType(type, fieldType);
    const question = new SurveyQuestion(type, '', '');

    if (type === 'checkbox' || type === 'radio' || type === 'dropdown') {
      question.options = ['Option 1', 'Option 2', 'Option 3'];
    }

    this.surveyPages[pageIndex].questions.push(question);
    this.showPlaceholder[pageIndex] = false;
    this.dragOverPage = null;
  }

  onQuestionDragStart(event: any, question: any) {
    event.dataTransfer.setData('question', JSON.stringify(question));
  }

  saveQuestion() {
    if (!this.questionText.trim() || (!this.options.length && this.selectedFieldType !== 'dropdown-one' && this.selectedFieldType !== 'multiple-choice-one')) {
      this.successMessage = '';
      return;
    }

    let answer: string | string[];
    if (this.selectedFieldType === 'dropdown-one' || this.selectedFieldType === 'multiple-choice-one') {
      answer = this.answerText;
    } else {
      answer = this.options.map(option => option);
    }

    const question = new SurveyQuestion(this.selectedFieldType, this.questionText, answer as string | string[]);
    if (this.selectedFieldType === 'dropdown' || this.selectedFieldType === 'dropdown-many') {
      question.options = this.options.map(option => option);
    } else if (this.selectedFieldType === 'checkbox' || this.selectedFieldType === 'radio') {
      question.options = this.options.map(option => option);
    }

    this.surveyPages[this.currentPageIndex].questions.push(question);
    this.successMessage = 'Question saved successfully!';
    this.resetFields();
  }

  removeField(pageIndex: number, fieldIndex: number) {
    this.surveyPages[pageIndex].questions.splice(fieldIndex, 1);
    if (this.surveyPages[pageIndex].questions.length === 0) {
      this.showPlaceholder[pageIndex] = true;
    }
  }

  addPage() {
    const pg = { index: this.surveyPages.length + 1, questions: [] };
    this.surveyPages.push(pg);
    // this.pagesArray.push(this.addPageGroup());
    // this.Op.push(this.addPollGroup());
    this.showPlaceholder[pg.index-1] = true;  
  }

  removePage(pageIndex: number) {
    this.surveyPages.splice(pageIndex, 1);
    for (let i = pageIndex; i < this.surveyPages.length; i++) {
      this.showPlaceholder[i] = true;
    }
    if (this.showPlaceholder[pageIndex - 1] === undefined) {
      this.showPlaceholder[pageIndex - 1] = true;
    }
  }

  getAnswerType(questionType: string, fieldType: string): string {
    if (questionType === 'multiple-choice-one' && fieldType === 'radio') {
      return 'radio';
    } else if (questionType === 'multiple-choice-many' && fieldType === 'checkbox') {
      return 'checkbox';
    } else if ((questionType === 'dropdown-one' || questionType === 'dropdown-many') && fieldType === 'dropdown') {
      return 'dropdown';
    } else {
      return ''; // Default to empty string if no match
    }
  }

  resetFields() {
    this.questionText = '';
    this.answerText = '';
    this.options = [];
  }

  addOption() {
    this.options.push(''); // Add an empty option
    // this.pagesArray.push(this.addPageGroup());
  }

  removeOption(index: number) {
    this.options.splice(index, 1); // Remove option at the specified index
  }

  insertPage(data:any){
    this.pages.pageTitle=data.pageTitle;
    // alert(this.responses.responseId);
    this.service.insertPages(this.pages).subscribe({
      next: (res: any) => {
        alert("Successfully created");
      }, error: () => {
        alert("Error in creating the survey");
      }
    });
    this.question.questions=data.questions;
    // alert(this.responses.responseId);
    this.service.insertQuestions(this.question).subscribe({
      next: (res: any) => {
        alert("Successfully created");
      }, error: () => {
        alert("Error in creating the survey");
      }
    });
    this.option.options=data.options;
    // alert(this.responses.responseId);
    this.service.insertOptions(this.option).subscribe({
      next: (res: any) => {
        alert("Successfully created");
      }, error: () => {
        alert("Error in creating the survey");
      }
    });
  }
}