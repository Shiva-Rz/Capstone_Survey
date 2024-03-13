import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SurveySummaryComponent } from './survey-summary/survey-summary.component';

const routes: Routes = [
  { path: 'New', component: SurveySummaryComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
