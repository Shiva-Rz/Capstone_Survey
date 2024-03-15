import { Component } from '@angular/core';

@Component({
  selector: 'app-survey-builder',
  templateUrl: './survey-builder.component.html',
  styleUrl: './survey-builder.component.css'
})
export class SurveyBuilderComponent {

  surveyPages: any[] = [
    { index: 1, questions: [] } // Default page (Page 1)
  ];
  currentPageIndex: number = 1;
  newQuestion: string = '';
  newAnswer: string = '';
  editorVisible: boolean = false;

  constructor() { }

  onDragStart(event: any, type: string) {
    event.dataTransfer.setData('type', type);
  }

  onDragOver(event: any) {
    event.preventDefault();
  }

  onDrop(event: any, pageIndex: number) {
    event.preventDefault();
    const type = event.dataTransfer.getData('type');
    const question = { type };
    this.surveyPages[pageIndex].questions.push(question);
  }

  onQuestionDragStart(event: any, question: any) {
    event.dataTransfer.setData('question', JSON.stringify(question));
  }

  addPage() {
    const page = {
      index: this.currentPageIndex++,
      questions: []
    };
    this.surveyPages.push(page);
  }

  removePage(pageIndex: number) {
    this.surveyPages.splice(pageIndex, 1);
  }

  removeField(pageIndex: number, fieldIndex: number) {
    this.surveyPages[pageIndex].questions.splice(fieldIndex, 1);
  }

  openQuestionEditor() {
    this.editorVisible = true;
  }

  saveQuestionAndAnswer() {
    if (this.newQuestion.trim() && this.newAnswer.trim()) {
      const pageIndex = this.currentPageIndex - 1;
      this.surveyPages[pageIndex].questions.push({ question: this.newQuestion, answer: this.newAnswer });
      this.closeQuestionEditor();
    } else {
      console.log("Please enter both question and answer.");
    }
  }

  closeQuestionEditor() {
    this.editorVisible = false;
    this.newQuestion = '';
    this.newAnswer = '';
  }

}