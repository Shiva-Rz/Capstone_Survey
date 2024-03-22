import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ResponseDetail } from './Model/ResponseDetail';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ResponseDetailService {


  private url : string ="http://localhost:4050";

  constructor(private http : HttpClient) {}

    getResponseDetails(response:ResponseDetail):Observable<any> {
    return this.http.get(this.url + "/responsedetailsurvey/"+response.surveyId);
  }

}
