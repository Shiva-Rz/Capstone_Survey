import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Comment } from '../Survey-Model/Comment';
import { Region } from '../Survey-Model/Region';
import { Observable } from 'rxjs';
import { Survey } from '../Survey-Model/survey';
import { Reaction } from '../Survey-Model/Reaction';
import { User } from '../Survey-Model/User';

@Injectable({
  providedIn: 'root'
})
export class TemplateService {

  private url: string = "http://localhost:4050";

  constructor(private http: HttpClient) { }

  getSurvey(user: User): Observable<any> {
    return this.http.get(this.url + "/getsurveyregion/" + user.userId);
  }

  getComment(survey: Survey): Observable<any> {
    return this.http.get<Comment[]>(this.url + "/comment/" + survey.surveyId);
  }

  reactionDelete(surveyId: number): string {
    this.http.delete(this.url + '/reactionDelete', { responseType: 'text' }).subscribe();
    return "Reaction Deleted!";
  }

  reactionInsert(reactionData: Reaction) {
    console.log("Reaction inserted");
    console.log(reactionData)
    this.http.post(this.url + '/reactionInsert', reactionData).subscribe();
    return "Reaction Inserted!";
  }

  insertComment(comment: Comment) {
    return this.http.post(this.url + "/comment", comment);
  }

  getAllReactionCount(id: any): Observable<any> {
    return this.http.get(this.url + "/getReactionCountByRegion/" + id);
  }

  getSurveyByUser(user: User): Observable<any> { 
    return this.http.get(this.url + "/getsurveyuser/" + user.userId); 
  } 

  changeStatus(){
    return this.http.get(this.url + "/changeStatus");
  }

  getSurveyRegionUser(user: User): Observable<any> { 
    return this.http.get(this.url + "/getsurveyregionuser/" + user.userId); 
  } 
}
