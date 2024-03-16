import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Responses } from '../model/responses';
import { Survey } from '../model/survey';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SurveyresponseService {

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
  getAlloptions(survey:Survey):Observable<any> {
    return this.http.get(this.url + "/getOption/"+survey.surveyId);
  }
}
