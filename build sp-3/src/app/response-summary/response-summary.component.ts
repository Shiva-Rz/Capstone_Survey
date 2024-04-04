import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Survey } from '../model/survey';
import { Responses } from '../model/responses';
import { Router } from '@angular/router';
import { SummaryService } from '../service/summary.service';
import { ResponseDetail } from '../model/ResponseDetail';
import { ResponsesummaryService } from '../service/responsesummary.service';

@Component({
  selector: 'app-response-summary',
  templateUrl: './response-summary.component.html',
  styleUrls: ['./response-summary.component.css']
})
export class ResponseSummaryComponent {

  responseDetailsList: ResponseDetail[] = [];
  responseDetail: ResponseDetail;
  surveyId!: number;
  response: Responses;
  responseList: Responses[] = [];
  num: number = 0;
  value!: number;

  constructor(private service: ResponsesummaryService) {
    this.responseDetail = new ResponseDetail;
    this.response = new Responses;
    this.getReponseDetail();
    this.getReponses();
    this.getReponseDetailCount();
  }

  getReponseDetail() {
    this.responseDetail.surveyId = 1;
    this.service.getResponseDetails(this.responseDetail).subscribe(page => {
      this.responseDetailsList = page;
      console.log(this.responseDetailsList)
    });
  }

  getReponseDetailCount() {
    this.responseDetail.surveyId = 1;
    this.service.getResponseDetailCount(this.responseDetail).subscribe(res => {
      this.value = res;
      console.log(this.value)
    });
  }

  nextPage() {
    this.num = this.num + 1;  //Page 
  }

  getReponses() {
    // this.response.responseDetailId=2; 
    this.response.surveyId = 1;
    this.service.getResponses(this.response).subscribe(rep => {
      this.responseList = rep;
      console.log(this.responseList)
    });
  }

} 