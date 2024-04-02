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

  constructor(private service: ResponsesummaryService) {
    this.responseDetail = new ResponseDetail;
    this.response = new Responses;
    this.getReponseDetail();
    this.getReponses();
  }


  getReponseDetail() {
    this.responseDetail.surveyId = 3;
    this.service.getResponseDetails(this.responseDetail).subscribe(page => {
      this.responseDetailsList = page;
      console.log(this.responseDetailsList)
    });


  }

  getReponses() {
    this.response.responseDetailId=1;
    // this.response.surveyId = 3;
    this.service.getResponses(this.response).subscribe(rep => {
      this.responseList = rep;
      console.log(this.responseList)
    });


  }

}

