import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Question } from '../model/question';
import { Survey } from '../model/survey';
import { Responses } from '../model/responses';

@Injectable({
  providedIn: 'root'
})
export class SummaryService {

  private url: string = "http://localhost:4050";

  constructor(private http: HttpClient) { }

  getQuestionCount(survey:Survey){
    return this.http.get<number>(this.url + "/questionCount/"+survey.surveyId);
  }

  getPagesCount(survey:Survey){
    return this.http.get<number>(this.url + "/pageCount/"+survey.surveyId);
  }

  getResponseDetailCount(survey:Survey){
    return this.http.get<number>(this.url + "/responseDetailCount/"+survey.surveyId);
  }

  getAllquestions(survey:Survey){
    return this.http.get<Question[]>(this.url+"/getquestion/"+survey.surveyId);
  }

  getAllResponseDetails(survey:Survey){
    return this.http.get<Responses[]>(this.url+"/getresponses/"+survey.surveyId);
  }
}
