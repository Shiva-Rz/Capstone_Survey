import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Survey } from '../Survey-Model/survey';
import { Responses } from '../Survey-Model/responses';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { SummaryService } from '../survey-service/summary.service';
import { ResponseDetail } from '../Survey-Model/ResponseDetail';
import { ResponsesummaryService } from '../survey-service/responsesummary.service';

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
  userId!:string;

  constructor(private service: ResponsesummaryService,private activatedroute: ActivatedRoute) {
    this.responseDetail = new ResponseDetail;
    this.response = new Responses;
    
    // this.getReponseDetail();
    // this.getReponses();
    // this.getReponseDetailCount();
  }

  ngOnInit(): void {
    this.activatedroute.paramMap.subscribe((param: Params) => {
      this.surveyId = param['get']("id");
      this.getReponses();
      this.getReponseDetailCount();
      this.getReponseDetail();
    //  alert(this.surveyId);
    })
  }

  getReponseDetail() {
    this.responseDetail.surveyId = this.surveyId;
    this.service.getResponseDetails(this.responseDetail).subscribe(page => {
      this.responseDetailsList = page;
      console.log(this.responseDetailsList)
    });
  }

  getReponseDetailCount() {
    this.responseDetail.surveyId = this.surveyId;
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
    this.response.surveyId = this.surveyId;
    this.service.getResponses(this.response).subscribe(rep => {
      this.responseList = rep;
      console.log(this.responseList)
    });
  }

} 