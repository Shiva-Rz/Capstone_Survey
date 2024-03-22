import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SurveyResponseComponent } from './survey-response/survey-response.component';
import {  ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ResponseTemplateComponent } from './response-template/response-template.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatRadioModule} from '@angular/material/radio';
import { DatePipe } from '@angular/common';
import { ResponseDetailsComponent } from './response-details/response-details.component';

@NgModule({
  declarations: [
    AppComponent,
    SurveyResponseComponent,
    ResponseTemplateComponent,
    ResponseDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,ReactiveFormsModule, FormsModule ,HttpClientModule, BrowserAnimationsModule,MatRadioModule
  ],
  providers: [
    provideClientHydration(),
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
