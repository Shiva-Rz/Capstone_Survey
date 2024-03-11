import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Survey } from '../model/survey';

@Injectable({
  providedIn: 'root'
})
export class SurveycreationService {
 
  private url: string = "http://localhost:4050";

  constructor(private http: HttpClient) { }

  create(survey: Survey) {
    this.http.post(this.url + '/', survey).subscribe();
    return "Survey Created Successfully";
  }
}
