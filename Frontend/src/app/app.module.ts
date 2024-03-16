import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { CreationPageComponent } from './creation-page/creation-page.component';
import { SurveySummaryComponent } from './survey-summary/survey-summary.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';

import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SummaryPageComponent } from './summary-page/summary-page.component';
import { SurveyDashboardComponent } from './survey-dashboard/survey-dashboard.component';
import { ResponseTemplateComponent } from './response-template/response-template.component';
import { SurveyResponseComponent } from './survey-response/survey-response.component';

@NgModule({
  declarations: [
    AppComponent,
    CreationPageComponent,
    SurveySummaryComponent,
    SummaryPageComponent,
    SurveyDashboardComponent,
    ResponseTemplateComponent,
    SurveyResponseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatGridListModule,
    MatCardModule,
    MatMenuModule,
    MatIconModule,
    MatButtonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
