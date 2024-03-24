import { Component } from '@angular/core';
import { TemplateService } from '../service/template.service';
import { Comment } from '../model/Comment';
import { Region } from '../model/region';
import { Survey } from '../model/survey';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-response-template',
  templateUrl: './response-template.component.html',
  styleUrls: ['./response-template.component.css']
})
export class ResponseTemplateComponent {

  //  For Like
  count: number=0;
  liked:boolean=false;
  showDiv:boolean[]=[];
  showLike: boolean[]=[];


  myForm!: FormGroup;
  region!: Region;
  surveymodel:Survey;
  survey: Survey[] = [];
  // comment: Comment[] = [];
  cmtList:Comment[]=[];
  
  


  constructor(private template: TemplateService) {

    this.survey.forEach(()=>this.showDiv.push(false));
    //Like
    this.survey.forEach(()=>this.showLike.push(false));

    this.region = new Region;
    // this.comment = new Comment;
    this.myForm = new FormGroup({

      regionId: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
      commentId: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
      surveyId: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
    });
    this.surveymodel=new Survey;
  }

  toggleLike(index:number){
    if(this.liked){
      this.count--;
    }
    else{
      this.count++;
    }
    this.liked=!this.liked;
    this.showLike[index] = ! this.showLike[index];
  }


    openComment(index:number){
      this.showDiv[index]=!this.showDiv[index];
    }
  


 
  // showComment = false;
  // openComment(){
  //   this.showComment=!this.showComment;
  // }

  getSurvey(data: any) {
    this.region.regionId = data.regionId;
    this.template.getSurvey(this.region).subscribe(page => {
      this.survey = page;
      // console.log(this.survey)
    });
  }

  
  


 getAllComment(data:any){
  console.log(data.surveyId);
  this.surveymodel.surveyId= data.surveyId;
  this.template.getComment(this.surveymodel).subscribe(comment =>{
    this.cmtList=comment;
    console.log(this.cmtList);
  });
 }


}