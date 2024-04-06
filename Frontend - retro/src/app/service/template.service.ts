import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Comment } from '../model/Comment';
import { Region } from '../model/region';
import { Observable } from 'rxjs';
import { Survey } from '../model/survey';
import { Reaction } from '../model/Reaction';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class TemplateService {

  private url: string = "http://localhost:4050";

  constructor(private http: HttpClient) { }

  getSurvey(region: Region): Observable<any> {
    return this.http.get(this.url + "/getsurveyregion/" + region.regionId);
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

 

  getSurveyRegionUser(user: User): Observable<any> { 

    return this.http.get(this.url + "/getsurveyregionuser/" + user.userId); 

  } 
}
