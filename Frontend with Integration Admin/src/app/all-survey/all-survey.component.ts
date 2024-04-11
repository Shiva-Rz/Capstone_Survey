import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Region } from '../model/Region';
import { Survey } from '../model/survey';
import { Reaction } from '../model/Reaction';
import { TemplateService } from '../service/template.service';
import { User } from '../model/User';
import { ResponsesummaryService } from '../service/responsesummary.service';
import { ResponseDetail } from '../model/ResponseDetail';

@Component({
  selector: 'app-all-survey',
  templateUrl: './all-survey.component.html',
  styleUrls: ['./all-survey.component.css']
})
export class AllSurveyComponent {

  //  For Like
  count: number = 0;

  comment: Comment;
  reactionCount!: number;
  myForm!: FormGroup;
  region!: Region;
  surveymodel: Survey;
  survey: Survey[] = [];
  otherSurvey: Survey[] = [];
  userSurvey: Survey[] = [];
  // comment: Comment[] = [];
  cmtList: Comment[] = [];
  results: string = "";
  reactCount: number = 0;

  

  reaction: Reaction;
  reactionList: Reaction[] = [];
  responseDetail:ResponseDetail;
  responseDetailCountList: ResponseDetail[] = [];

  rn: Reaction = new Reaction();

  user: User;
  value!: number;
  userId!:any;

  constructor(private template: TemplateService, private service: ResponsesummaryService) {
    this.region = new Region;

    this.user = new User;
    // this.comment = new Comment;
    this.myForm = new FormGroup({

      regionId: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
      commentId: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
      comments: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
      surveyId: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
    });
    this.surveymodel = new Survey;
    this.comment = new Comment;
    this.reaction = new Reaction;
    this.responseDetail=new ResponseDetail;
    this.userId=sessionStorage.getItem("userId")||'';
    // this.userId=1;
    console.log("User:"+this.userId);
    this.getReactionCount();
    this.getSurveyByUser(); 
    // this.getReponseDetailCount();
    this.getSurveyRegionUser();
    this.getReponseDetailCountUser();
      
  }


  

  getReactionCount() {
    this.surveymodel.surveyId = 1;
    console.log(this.surveymodel.surveyId);
    this.template.getAllReactionCount(this.surveymodel.surveyId).subscribe(value => {
      this.reactionList = value;
      console.log(this.reactionList);
      // if(this.isLike==true){
      //   this.reaction.reactionCount=this.reaction.reactionCount+1;
      //   console.log(this.reaction.reactionCount);
      // }else if(this.isLike==false){
      //   this.reaction.reactionCount=this.reaction.reactionCount;
      //   console.log(this.reaction.reactionCount);
      // }
      // console.log(this.reaction.reactionCount);
    })
  }

  getAllComment(data: any) {
    console.log(data.surveyId);
    this.surveymodel.surveyId = data.surveyId;
    this.template.getComment(this.surveymodel).subscribe(comment => {
      this.cmtList = comment;
      console.log(this.cmtList);
    });
  }


  // insertComment(data: any) {
  //   console.log(data.comments);
  //   this.comment.comments = data.comments;
  //   this.comment.surveyId = 2;
  //   this.comment.userId = 2;
  //   this.template.insertComment(this.comment).subscribe({

  //     next: (res: any) => {
  //       // this.router.navigate(['/create/builder']);
  //       alert("Successfully added");
  //     }, error: () => {
  //       alert("Survey Details Required");
  //     }
  //   });
  //   location.reload();
  // }

  getSurveyByUser() {
   
    this.user.userId = this.userId;
    console.log(this.user.userId);
    this.template.getSurveyByUser(this.user).subscribe(page => {
      this.userSurvey = page;
      console.log(this.userSurvey) 
    });
  }


  getSurveyRegionUser() {
    this.user.userId = this.userId;
    this.template.getSurveyRegionUser(this.user).subscribe(page => {
      this.otherSurvey = page;
      console.log(this.otherSurvey) 
    });
  }

  // getReponseDetailCount() {
  //   this.responseDetail.surveyId = this.surveyId;
  //   this.service.getResponseDetailCount(this.responseDetail).subscribe(res => {
  //     this.value = res;
  //     console.log(this.value)
  //   });
  // }
  
  getReponseDetailCountUser() {
    this.user.userId = this.userId;
    this.service.getResponseDetailCountUser(this.user).subscribe(res => {
      this.responseDetailCountList = res;
      console.log(this.responseDetailCountList);
    });
 
 
  }
}  
