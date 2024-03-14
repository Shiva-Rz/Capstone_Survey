import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Question } from './Model/Question';
import { Survey } from './Model/Suvey';
import { Page } from './Model/Page';

@Injectable({
  providedIn: 'root'
})
export class SurveyResponseService {

  private url : string ="http://localhost:4050";

  constructor(private http : HttpClient) {}

  insertQuestion(question : Question){
    this.http.post(this.url +  "/question",question).subscribe();
  }

  getAllquestions(survey:Survey) {
    return this.http.get<Page[]>(this.url + "/"+survey.surveyId);
  }
}
