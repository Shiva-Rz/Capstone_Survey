import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Page } from '../Survey-Model/page';
import { Question } from '../Survey-Model/question';
import { Option } from '../Survey-Model/option';
import { PageValue } from '../Survey-Model/PageValue';

@Injectable({
  providedIn: 'root'
})
export class SurveybuilderService {

  private url : string ="http://localhost:4050";

  constructor(private http : HttpClient) { }

  insertPages(page : PageValue){
    return this.http.post(this.url + "/page",page);
  }
  // insertQuestions(question : Question){
  //   return this.http.post(this.url + "/question",question);
  // }
  // insertOptions(option : Option){
  //   return this.http.post(this.url + "/option",option);
  // }
}
