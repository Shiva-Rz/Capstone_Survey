import { Component, Input } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Comment } from '../Survey-Model/Comment';
import { Region } from '../Survey-Model/Region';
import { Survey } from '../Survey-Model/survey';
import { TemplateService } from '../survey-service/template.service';
import { Reaction } from '../Survey-Model/Reaction';
import { SurveyCommentInterface } from '../surveyComments/surveyComment-types/survey-comment.interface';
import { SurveyActiveCommentInterface } from '../surveyComments/surveyComment-types/activeComment.interface';
import { SurveyCommentsService } from '../surveyComments/surveyComment-services/survey-comments.service';
import { User } from '../Survey-Model/User';

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
  
  // comment: Comment;
  reactionCount!:number;
  myForm!: FormGroup;
  region!: Region;
  surveymodel: Survey;
  survey: Survey[] = [];
  // comment: Comment[] = [];
  cmtList: Comment[] = [];
  results:string="";
  reactCount:number=0;
  value:any=0;
  user:User;
  
  isShow = true;
  
  likeS: string = 'like-button';
  
  reaction:Reaction;
  reactionList:Reaction[]=[];
  
  rn:Reaction = new Reaction();
  
  isLike = false;

  popOver: boolean = false;
  hideform: boolean = true;
  notallow: boolean = false;
  @Input() currentUserId!: string;
 @Input() surveyId!: number;
 surveycomments: SurveyCommentInterface[] = [];
 surveycomment!: SurveyCommentInterface;
 activeComment: SurveyActiveCommentInterface | null = null;
 
 surveycommentss!: Survey;
//  region:Region;
 
 Survey: any;
 userId:any=0;
 surveyIdValue!:number;
 
 surveys: Survey[] = [];
 
 isHide:boolean[]=Array(this.surveys.length).fill(true);
 
 isHideComment=true;
  
  
   constructor(private template: TemplateService, private commentsService: SurveyCommentsService) {
  
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
    //  this.comment = new Comment;
    this.user=new User;
     this.reaction=new Reaction;
     sessionStorage.setItem("flag",'false');
     this.userId=sessionStorage.getItem("userId") || "";
     this.changeStatus();
     this.getSurvey();
     this.getReactionCount();
   }
  
   toggleLike(survey: Survey): void {
     if (this.liked) {
       this.count--;
     }
     else {
       this.count++;
     }
     this.liked = !this.liked;
     this.showLike[survey.surveyId] = !this.showLike[survey.surveyId];
   }
  
   toggleDisplayComment(postId:number) {
    this.isHide[postId] = !this.isHide[postId];
    this.isHideComment=!this.isHideComment;
  }
 
  ngOnInit(): void {
    this.commentsService.getComments().subscribe((comments) => {
      this.surveycomments = comments;
      console.log(comments);
    });
    this.user.userId=this.userId;
    this.template.getSurvey(this.user).subscribe((AllPoll) => {
     this.surveys = AllPoll;
     console.log(this.surveys);
   });
  }
  
   getComment(survey: Survey): void {
     console.log(survey.surveyId);
     this.value=survey.surveyId;
     console.log(this.value);
     sessionStorage.setItem("commentSurveyId",this.value);  //setting value in session
    //  this.showDiv[survey.surveyId] = !this.showDiv[survey.surveyId];
   }
  
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
  
  
   getRootComments(surveyId: number): SurveyCommentInterface[] {
    return this.surveycomments.filter((comment) => (comment.parentId == "0" && comment.survey.surveyId === surveyId));
    //return this.comments;
  }
 
  updateComment({
    text,
    commentId,
  }: {
    text: string;
    commentId: string;
  }): void {
    this.commentsService
      .updateComment(commentId, text)
      .subscribe((updatedComment) => {
        this.surveycomments = this.surveycomments.map((comment) => {
          if (comment.id === commentId) {
            return updatedComment;
          }
          return comment;
        });
        this.activeComment = null;
      });
  }
 
  deleteComment(commentId: string): void {
    this.commentsService.deleteComment(commentId).subscribe(() => {
      this.surveycomments = this.surveycomments.filter(
        (comment) => comment.id !== commentId
      );
    });
  }
 
  // getCommentsCount(surveyId: number):number{
  //   return this.surveycomments.filter(comment => comment.survey.surveyId === surveyId).length;
  // }
 
  setActiveComment(activeComment: SurveyActiveCommentInterface | null): void {
    this.activeComment = activeComment;
  }
 
  ac:SurveyCommentInterface = new SurveyCommentInterface;
 
  addComment({
    text,
    parentId,
    userId,
    surveyId,
  }: {
    text: string;
    parentId: string | null;
    userId: any,
    surveyId: number
  }): void {
 
    //this.ac.pollId = this.ac.pollId;
    this.commentsService
      .createComment(text, parentId,this.surveyId,userId)
      .subscribe((createdComment) => {
        this.ac.userId="1";
        // createdComment.pollId=this.poll.pollId;
        this.surveycomments = [...this.surveycomments, createdComment];
        this.activeComment = null;
      });
      console.log(this.surveycomments)
  }
 
  getReplies(commentId: string): SurveyCommentInterface[] {
    return this.surveycomments
      .filter((comment) => comment.parentId === commentId)
      //.filter((comment) => comment.parentId != "0")
      .sort(
        (a, b) =>
          new Date(a.createdAt).getTime() - new Date(b.createdAt).getTime()
      );
  }
  
  
   // showComment = false;
   // openComment(){
   //   this.showComment=!this.showComment;
   // }
  
   getSurvey() {
     this.user.userId = this.userId;
     this.template.getSurvey(this.user).subscribe(page => {
       this.survey = page;
       console.log(this.survey)
     });
   }

   changeStatus(){
    this.template.changeStatus().subscribe();
   }
  
   getReactionCount(){
     this.surveymodel.surveyId=this.userId;
     console.log(this.surveymodel.surveyId);
     this.template.getAllReactionCount(this.surveymodel.surveyId).subscribe(value =>{
       this.reactionList=value;
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
  
   TotalnumberofLikes: { [surveyId: number]: number } = {};
  
   reactionInsert(surveyId: number) {
     console.log(surveyId)
     this.rn.surveyId = surveyId;
     this.rn.userId = 1;
     console.log(this.rn);
     // this.TotalnumberofLikes[surveyId]
     if (this.TotalnumberofLikes[surveyId]) {
       delete this.TotalnumberofLikes[surveyId];
       console.log("Delete");
       this.results = this.template.reactionDelete(surveyId);
       this.count=0;
     } else {
       this.TotalnumberofLikes[surveyId] = 1;
       console.log("Insert");
       this.results = this.template.reactionInsert(this.rn);
       this.count=1;
     }
     // console.log(this.reaction.reactionCount);
     //  this.Reaction;
     console.log(this.results);
     if (this.TotalnumberofLikes[surveyId]) {
       this.TotalnumberofLikes[surveyId] = 1;
     }
     else {
       this.TotalnumberofLikes[surveyId]--;
     }
   }
  
  
   toggleDisplay() {
     this.isShow = !this.isShow;
     this.isLike = !this.isLike;
   }

   viewpop(){
    this.hideform = false;
    this.popOver = true;
  }
 
  restrict() {
    this.hideform = false;
    this.notallow = true;
  }
  
  
   getAllComment(data: any) {
     console.log(data.surveyId);
     this.surveymodel.surveyId = data.surveyId;
     this.template.getComment(this.surveymodel).subscribe(comment => {
       this.cmtList = comment;
       console.log(this.cmtList);
     });
   }
  
  
  //  insertComment(data: any) {
  //    console.log(data.comments);
  //    this.comment.comments = data.comments;
  //    this.comment.surveyId = 2;
  //    this.comment.userId = 2;
  //    this.template.insertComment(this.comment).subscribe({
  
  //      next: (res: any) => {
  //        // this.router.navigate(['/create/builder']);
  //        alert("Successfully added");
  //      }, error: () => {
  //        alert("Survey Details Required");
  //      }
  //    });
  //    location.reload();
  //  }
 }