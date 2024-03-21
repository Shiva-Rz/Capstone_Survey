import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Page } from '../model/page';
import { Question } from '../model/question';
import { Option } from '../model/option';
import { SurveybuilderService } from '../service/surveybuilder.service';
import { SurveyQuestion } from '../model/surveyquestion';

@Component({
  selector: 'app-survey-builder',
  templateUrl: './survey-builder.component.html',
  styleUrls: ['./survey-builder.component.css']
})
export class SurveyBuilderComponent {

  flag: boolean = false;

  flag1: boolean = true;

  singleflag: boolean = false;

  dropflag: boolean = false;

  checkflag: boolean = false;

  myForm: FormGroup = new FormGroup({
    optionList: new FormArray([])
  });

  getOptionFields(): FormGroup{
    return new FormGroup({
      pageTitle: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
      options: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
      questions: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')])
    });
  }

  optionListArray(){
    return this.myForm.get("optionList") as FormArray;
  }

  addOption(){
    this.optionListArray().push(this.getOptionFields());
  }
  pages: Page;
  question: Question;
  quest = [];
  option: Option;
  pgs: Page[] = [];
  opts: Option[] = [];
  options: string[] = [];

  questionText: string = '';
  answerText: string = '';


  singleQuestions: any[] = [{ index: 1, questions: [] }];

  // dropQuestions: any[] = [{ index: 1, questions: [] }];

  // checkQuestions: any[] = [{ index: 1, questions: [] }];

  // multiCard: any[] = [{ index: 1, questions: [] }]

  constructor(private _fb: FormBuilder, private service: SurveybuilderService) {

    // this.initPlaceholderVisibility();
    this.pages = new Page;
    this.question = new Question;
    this.option = new Option;
    this.myForm = new FormGroup({
      pageTitle: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
      options: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
      questions: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')])
    });
    this.myForm = this._fb.group({
      pageTitle: new FormControl('', [Validators.required, Validators.maxLength(50)]),
      pageArray: this._fb.array([this.addPageGroup()], [Validators.required]),
      questionArray: this._fb.array([this.addQuestionGroup()], [Validators.required]),
      optionArray: this._fb.array([this.addPageGroup()], [Validators.required]),
    });
  }

  addPageGroup() {

  }

  addQuestionGroup() {

  }

  get questionArray(): FormArray {
      return <FormArray>this.myForm.get('questionArray');
    }

    // addcard() {
    //   // const cd = { index: this.multiCard.length + 1, questions: [] };
    //   this.multiCard.push();
    // }

    addSingle() {
      const sin = { index: this.singleQuestions.length + 1, questions: [] };
      this.singleQuestions.push(sin);
      // this.pagesArray.push(this.addPageGroup());
      // this.Op.push(this.addPollGroup());
      // this.single[pg.index-1] = true; 
    }

    // addDropdown() {
    //   const drop = { index: this.dropQuestions.length + 1, questions: [] };
    //   this.dropQuestions.push(drop);
    //   // this.pagesArray.push(this.addPageGroup());
    //   // this.Op.push(this.addPollGroup());
    //   // this.single[pg.index-1] = true; 
    // }

    // addOption() {
    //   this.options.push('');
    // }

    // addCheck() {
    //   const check = { index: this.checkQuestions.length + 1, questions: [] };
    //   this.checkQuestions.push(check);
    // }

    // addCard() {
    //   const card = { index: this.multiCard.length + 1, questions: [] };
    //   this.multiCard.push(card);
    // }

    // addchange() {
    //   this.flag = !this.flag;
    //   // this.flag = true
    // }

    // delchange() {
    //   this.flag1 = !this.flag1;
    //   // this.flag = false
    // }


    single() {
      this.singleflag = !this.singleflag;
      this.singleflag = true;
    }

    // drop() {
    //   this.dropflag = !this.dropflag;
    //   this.dropflag = true;
    // }

    // check() {
    //   this.checkflag = !this.checkflag;
    //   this.checkflag = true;
    // }

    resetFields() {
      // this.questionText = '';
      // this.answerText = '';
      // this.tagText = '';
      // this.$refs.upload.clearFiles();
      this.options = [];
    }
  }
