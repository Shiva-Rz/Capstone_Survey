import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SurveyResponseComponent } from './survey-response/survey-response.component';
import { ResponseTemplateComponent } from './response-template/response-template.component';

const routes: Routes = [
  {path:'', component: ResponseTemplateComponent},
  {path:'response/:id',component:SurveyResponseComponent},
  {path:'response',component:SurveyResponseComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
