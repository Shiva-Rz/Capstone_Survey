import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Question } from '../Survey-Model/question';
import { Survey } from '../Survey-Model/survey';
import { Responses } from '../Survey-Model/responses';
import { Page } from '../Survey-Model/page';

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

  getAllpages(survey:Survey){
    return this.http.get<Page[]>(this.url+"/getPage/"+survey.surveyId);
  }

  getAllResponseDetails(survey:Survey){
    return this.http.get<Responses[]>(this.url+"/getresponses/"+survey.surveyId);
  }
}
