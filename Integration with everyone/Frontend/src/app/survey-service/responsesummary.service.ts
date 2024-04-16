import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ResponseDetail } from '../Survey-Model/ResponseDetail';
import { Observable } from 'rxjs';
import { Responses } from '../Survey-Model/responses';
import { User } from '../Survey-Model/User';

@Injectable({
  providedIn: 'root'
})
export class ResponsesummaryService {

  private url: string = "http://localhost:4050";

  constructor(private http: HttpClient) { }

  getResponseDetails(response: ResponseDetail): Observable<any> {
    return this.http.get(this.url + "/responsedetailsurvey/" + response.surveyId);
  }

  getResponseDetailCount(response: ResponseDetail): Observable<any> {
    return this.http.get(this.url + "/responseDetailCount/" + response.surveyId);
  }

  getResponseDetailCountUser(user: User): Observable<any> {
    return this.http.get(this.url + "/responsedetailsurveycount/" + user.userId);
  }

  // getResponses(response: Responses): Observable<any> { 
  //   return this.http.get(this.url + "/getresponsesbyresponsedetail/" + response.responseDetailId); 
  // } 

  getResponses(response: Responses): Observable<any> {
    return this.http.get(this.url + "/getresponses/" + response.surveyId);
  }

  insertResponses(responses: Responses) {
    return this.http.post(this.url + "/response", responses);
  }
}
