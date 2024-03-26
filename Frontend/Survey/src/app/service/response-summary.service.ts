import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ResponseDetail } from '../model/ResponseDetail';
import { Observable } from 'rxjs';
import { Responses } from '../model/responses';

@Injectable({
  providedIn: 'root'
})
export class ResponseSummaryService {

  private url : string ="http://localhost:4050";

  constructor(private http : HttpClient) {}

    getResponseDetails(response:ResponseDetail):Observable<any> {
    return this.http.get(this.url + "/responsedetailsurvey/"+response.surveyId);
  }

  getResponses(response:Responses):Observable<any> {
    return this.http.get(this.url + "/getresponsesbyresponsedetail/"+response.responseDetailId);
  }
}
