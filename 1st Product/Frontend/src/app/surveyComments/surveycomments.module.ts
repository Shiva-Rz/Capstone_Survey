import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { SurveyCommentComponent } from './components/surveyComment/SurveyComment.component';
import { SurveyCommentFormComponent } from './components/surveyCommentForm/surveyCommentForm.component';
import { SurveyCommentsComponent } from './components/surveyComments/SurveyComments.component';
import { SurveyCommentsService } from './surveyComment-services/survey-comments.service';

@NgModule({
  imports: [CommonModule, ReactiveFormsModule],
  declarations: [SurveyCommentsComponent, SurveyCommentComponent, SurveyCommentFormComponent],
  providers: [SurveyCommentsService],
  exports: [SurveyCommentsComponent,SurveyCommentComponent,SurveyCommentFormComponent],
})
export class SurveyCommentsModule {}
