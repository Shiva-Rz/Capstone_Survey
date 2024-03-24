import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Question } from './Model/Question';
import { Survey } from './Model/Suvey';
import { Page } from './Model/Page';
import { Observable } from 'rxjs';
import { Responses } from './Model/Reponses';

@Injectable({
  providedIn: 'root'
})
export class SurveyResponseService {

  private url : string ="http://localhost:4050";

  constructor(private http : HttpClient) {}

  insertResponses(responses : Responses){
    return this.http.post(this.url +  "/response",responses);
  }

  getAllpages(survey:Survey):Observable<any> {
    return this.http.get(this.url + "/getPage/"+survey.surveyId);
  }
  getAllquestions(survey:Survey):Observable<any> {
    return this.http.get(this.url + "/getquestion/"+survey.surveyId);
  }
  // getAllquestions(page:Page):Observable<any> {
  //   return this.http.get(this.url + "/getquestionpage/"+1);
  // }
  getAlloptions(survey:Survey):Observable<any> {
    return this.http.get(this.url + "/getOption/"+survey.surveyId);
  }
  
}
