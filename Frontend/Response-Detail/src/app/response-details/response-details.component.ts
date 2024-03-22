import { Component } from '@angular/core';
import { ResponseDetail } from '../Model/ResponseDetail';
import { ResponseDetailService } from '../response-detail.service';

@Component({
  selector: 'app-response-details',
  templateUrl: './response-details.component.html',
  styleUrls: ['./response-details.component.css']
})
export class ResponseDetailsComponent {

  responseDetailsList:ResponseDetail[]=[];
  responseDetail:ResponseDetail;
  surveyId!:number;

  constructor(private service:ResponseDetailService){
       this.responseDetail=new ResponseDetail;
       this.getReponseDetail();
  }
  
  
  getReponseDetail() {
    this.responseDetail.surveyId=2;
    this.service.getResponseDetails(this.responseDetail).subscribe(page => 
      { 
        this.responseDetailsList = page;
        console.log(this.responseDetailsList)
  });

}
}
