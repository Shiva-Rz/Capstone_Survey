import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// import { SurveySummaryComponent } from './survey-summary/survey-summary.component';
import { SummaryPageComponent } from './summary-page/summary-page.component';
import { CreationPageComponent } from './creation-page/creation-page.component';
import { SurveyDashboardComponent } from './survey-dashboard/survey-dashboard.component';
import { ResponseTemplateComponent } from './response-template/response-template.component';
import { SurveyResponseComponent } from './survey-response/survey-response.component';

const routes: Routes = [
  // { path: 'New', component: SurveySummaryComponent },
  { path: '', component: SurveyDashboardComponent },
  { path: 'create', component: CreationPageComponent },
  { path: 'create/response', component: ResponseTemplateComponent },
  { path: 'create/summary', component: SummaryPageComponent },
  { path: 'summary', component: SummaryPageComponent },
  { path: 'response', component: ResponseTemplateComponent},
  { path: 'userResponse', component: SurveyResponseComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
