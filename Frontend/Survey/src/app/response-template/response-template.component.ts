import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Comment } from '../model/Comment';
import { Region } from '../model/region';
import { Survey } from '../model/survey';
import { TemplateService } from '../service/template.service';
import { Reaction } from '../model/Reaction';

@Component({
  selector: 'app-response-template',
  templateUrl: './response-template.component.html',
  styleUrls: ['./response-template.component.css']
})
export class ResponseTemplateComponent {

  //  For Like
  count: number = 0;
  liked: boolean = false;
  showDiv: boolean[] = [];
  showLike: boolean[] = [];

  comment: Comment;
  myForm!: FormGroup;
  region!: Region;
  surveymodel: Survey;
  survey: Survey[] = [];
  // comment: Comment[] = [];
  cmtList: Comment[] = [];
  results:string="";
  reactCount:number=0;

  isShow = true;

  likeS: string = 'like-button';

  rn:Reaction = new Reaction();
 
  isLike = false;




  constructor(private template: TemplateService) {

    this.survey.forEach(() => this.showDiv.push(false));
    //Like
    this.survey.forEach(() => this.showLike.push(false));

    this.region = new Region;
    // this.comment = new Comment;
    this.myForm = new FormGroup({

      regionId: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
      commentId: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
      comments: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
      surveyId: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
    });
    this.surveymodel = new Survey;
    this.comment = new Comment;
    this.getSurvey();
  }

  toggleLike(index: number) {
    if (this.liked) {
      this.count--;
    }
    else {
      this.count++;
    }
    this.liked = !this.liked;
    this.showLike[index] = !this.showLike[index];
    
  }


  // openComment(survey: Survey): void {
  //   // console.log(data.surveyId);
  //   this.showDiv[survey.surveyId] = !this.showDiv[survey.surveyId];
  // }

  openComment(survey: Survey): void {
    if (this.showDiv[survey.surveyId]) {
      this.showDiv[survey.surveyId] = false;
    } else {
      for (const id in this.showDiv) {
        if (this.showDiv.hasOwnProperty(id)) {
          this.showDiv[id] = false;
        }
      }
      this.showDiv[survey.surveyId] = true;
    }
  }




  // showComment = false;
  // openComment(){
  //   this.showComment=!this.showComment;
  // }

  getSurvey() {
    this.region.regionId = 1;
    this.template.getSurvey(this.region).subscribe(page => {
      this.survey = page;
      // console.log(this.survey)
    });
  }

  TotalnumberofLikes: {[surveyId:number]:number} = {};

  reactionInsert(surveyId : number)
      {
        console.log(surveyId)
        this.rn.surveyId=surveyId;
        this.rn.userId=1;
        if(this.TotalnumberofLikes[surveyId]){
          delete this.TotalnumberofLikes[surveyId];
          // this.results = this.template.reactionDelete(surveyId);
        }else{
          this.TotalnumberofLikes[surveyId]=1;
          // this.results = this.template.reactionInsert(this.rn);
        }
        //  this.Reaction;
         console.log(this.results);      
        if (this.TotalnumberofLikes[surveyId])
        {
        this.TotalnumberofLikes[surveyId]=this.reactCount;
        }
        else{
          this.TotalnumberofLikes[surveyId]--;
        }
      }


  toggleDisplay() {
    this.isShow = !this.isShow;
    this.isLike = !this.isLike;
  }


  getAllComment(data: any) {
    console.log(data.surveyId);
    this.surveymodel.surveyId = data.surveyId;
    this.template.getComment(this.surveymodel).subscribe(comment => {
      this.cmtList = comment;
      console.log(this.cmtList);
    });
  }


  insertComment(data: any) {
    console.log(data.comments);
    this.comment.comments = data.comments;
    this.comment.surveyId=4;
    this.comment.userId=1;
    this.template.insertComment(this.comment).subscribe({

      next: (res: any) => {
        // this.router.navigate(['/create/builder']);
        alert("Successfully added");
      }, error: () => {
        alert("Survey Details Required");
      }
    });
    location.reload();
  }
}
