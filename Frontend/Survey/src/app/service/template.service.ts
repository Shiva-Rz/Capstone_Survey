import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Region } from '../model/region';
import { Observable } from 'rxjs';
import { Survey } from '../model/survey';

@Injectable({
  providedIn: 'root'
})
export class TemplateService {

  private url: string = "http://localhost:4050";

  constructor(private http: HttpClient) { }

  getSurvey(region: Region): Observable<any> {
    return this.http.get(this.url + "/getsurveyregion/" + region.regionId);
  }

  getComment(survey:Survey):Observable<any> {
    return this.http.get<Comment[]>(this.url + "/comment/"+survey.surveyId);
  }
}
