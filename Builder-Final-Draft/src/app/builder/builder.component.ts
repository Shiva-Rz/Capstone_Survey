import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, FormControl, Validators } from '@angular/forms';
import { Page } from '../Model/Page';
import { Question } from '../Model/Question';
import { Option } from '../Model/Option';
import { BuilderService } from '../builder.service';
import { SurveyQuestion } from '../Model/SurveyQuestion';


@Component({
  selector: 'app-builder',
  templateUrl: './builder.component.html',
  styleUrl: './builder.component.css'
})
export class BuilderComponent {
  myForm!: FormGroup;
  questions: Question[] = [];
  totalNewQuestions = 0;

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.myForm = this.fb.group({
      title: ['']
    });
  }

  addNewQuestion(): void {
    if (this.totalNewQuestions < 15) {
      const newQuestion: Question = {
        questionId: this.questions.length + 1,
        questionNo: this.questions.length + 1,
        questions: '',
        optionType: '',
        option: []
      };
      this.questions.push(newQuestion);
      this.totalNewQuestions++;
    }
  }

  addOption(question: Question): void {
    if (!question.option) {
      question.option = [];
    }
    if (question.option.length < 10) {
      question.option.push({ optionId: question.option.length + 1, options: '' });
    }
  }

  removeOption(question: Question, index: number): void {
    question.option.splice(index, 1);
  }

  removeQuestion(index: number): void {
    this.questions.splice(index, 1);
    this.totalNewQuestions--;
  }
}