import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SurveyResponseComponent } from './survey-response/survey-response.component';
import {  ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ResponseTemplateComponent } from './response-template/response-template.component';

@NgModule({
  declarations: [
    AppComponent,
    SurveyResponseComponent,
    ResponseTemplateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,ReactiveFormsModule, FormsModule ,HttpClientModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
