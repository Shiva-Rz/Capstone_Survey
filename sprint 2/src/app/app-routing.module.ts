import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SummaryPageComponent } from './summary-page/summary-page.component';
import { CreationPageComponent } from './creation-page/creation-page.component';
import { SurveyDashboardComponent } from './survey-dashboard/survey-dashboard.component';
import { ResponseTemplateComponent } from './response-template/response-template.component';
import { SurveyResponseComponent } from './survey-response/survey-response.component';
import { SurveyBuilderComponent } from './survey-builder/survey-builder.component';
import { ResponseSummaryComponent } from './response-summary/response-summary.component';

const routes: Routes = [
  { path: '', component: SurveyDashboardComponent },
  { path: 'create', component: CreationPageComponent },
  { path: 'builder', component: SurveyBuilderComponent },
  { path: 'create/builder', component: SurveyBuilderComponent },
  { path: 'create/response', component: ResponseTemplateComponent },
  { path: 'create/summary', component: SummaryPageComponent },
  { path: 'summary', component: SummaryPageComponent },
  { path: 'response', component: ResponseTemplateComponent },
  { path: 'userResponse/:id', component: SurveyResponseComponent },
  { path: 'userResponse', component: SurveyResponseComponent },
  { path: 'respsummary', component: ResponseSummaryComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
