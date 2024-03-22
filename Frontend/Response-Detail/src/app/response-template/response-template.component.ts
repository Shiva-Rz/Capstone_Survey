import { Component } from '@angular/core';
import { TemplateService } from '../template.service';
import { Region } from '../Model/Region';
import { Survey } from '../Model/Suvey';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-response-template',
  templateUrl: './response-template.component.html',
  styleUrls: ['./response-template.component.css']
})
export class ResponseTemplateComponent {
  
  myForm!:FormGroup;
  region!:Region;
  survey:Survey[]=[];

constructor(private template:TemplateService,private router:Router,private datePipe:DatePipe){
 this.region=new Region;
 this.myForm=new FormGroup({
  regionId: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),

});
}


  getSurvey(data:any) {
    this.region.regionId=data.regionId;
    this.template.getSurvey(this.region).subscribe(page => 
      { 
        this.survey = page;
        console.log(this.survey)
  });
  }
   
  route(){
    // this.router.navigate(['response/{{sur.surveyId}}']);
    // const currentDateAndTime = this.datePipe.transform(new Date(), 'yyyy-MM-dd HH:mm:ss');
    // console.log(currentDateAndTime);
  }

}
