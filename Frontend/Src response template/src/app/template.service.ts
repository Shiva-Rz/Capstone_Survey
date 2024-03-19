import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Survey } from './Model/Suvey';
import { Region } from './Model/Region';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TemplateService {

  private url : string ="http://localhost:4050";

  constructor(private http : HttpClient) {}

  getSurvey(region : Region):Observable<any>{
    return this.http.get(this.url +  "/getsurveyregion/"+region.regionId);
  }
}
