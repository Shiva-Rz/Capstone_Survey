import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Page } from './Model/Page';
import { Question } from './Model/Question';
import { Option } from './Model/Option';

@Injectable({
  providedIn: 'root'
})
export class BuilderService {

  private url : string ="http://localhost:4050";

  constructor(private http : HttpClient) { }

  insertPages(page : Page){
    return this.http.post(this.url + "/page",page);
  }
  insertQuestions(question : Question){
    return this.http.post(this.url + "/question",question);
  }
  insertOptions(option : Option){
    return this.http.post(this.url + "/option",option);
  }
}
