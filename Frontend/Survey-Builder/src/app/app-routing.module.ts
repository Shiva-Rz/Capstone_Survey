import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SurveySummaryComponent } from './survey-summary/survey-summary.component';
import { SurveyBuilderComponent } from './survey-builder/survey-builder.component';

const routes: Routes = [
  { path: '', component: SurveySummaryComponent },
  { path: 'builder', component: SurveyBuilderComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
