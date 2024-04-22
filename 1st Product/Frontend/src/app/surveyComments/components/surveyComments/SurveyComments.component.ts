import { Component, Input, OnInit } from '@angular/core';
import { SurveyCommentsService } from '../../surveyComment-services/survey-comments.service';
import { SurveyActiveCommentInterface } from '../../surveyComment-types/activeComment.interface';
import { SurveyCommentInterface } from '../../surveyComment-types/survey-comment.interface';
import { Survey } from 'src/app/Survey-Model/survey';
import { TemplateService } from 'src/app/survey-service/template.service';
import { Region } from 'src/app/Survey-Model/Region';
import { User } from 'src/app/Survey-Model/User';
 
@Component({
  selector: 'surveycomments',
  templateUrl: './SurveyComments.component.html',
  styleUrls: ['./SurveyComments.component.css'],
})
export class SurveyCommentsComponent implements OnInit {
  @Input() currentUserId!: string;
  @Input() surveyId!: number;
  surveycomments: SurveyCommentInterface[] = [];
  surveycomment!: SurveyCommentInterface;
  activeComment: SurveyActiveCommentInterface | null = null;
 
  survey!: Survey;
  region:Region;
  user:User;
  userId:any=0;

  Survey: any;
 
  surveys: Survey[] = [];

  isHide:boolean[]=Array(this.surveys.length).fill(true);

  toggleDisplayComment(surveyId:number) {
    this.isHide[surveyId] = !this.isHide[surveyId];
  }
  // comment!: CommentInterface[];

  constructor(private commentsService: SurveyCommentsService,private surveyService: TemplateService) {
    this.region=new Region;
    this.user=new User;
    this.userId=sessionStorage.getItem("userId") || "";
  }
 
  ngOnInit(): void {
    this.commentsService.getComments().subscribe((comments) => {
      this.surveycomments = comments;
      console.log(comments);
    });

    // this.pollService.get(1).subscribe((AllPoll) => {
    //   this.polls = AllPoll;
    //   console.log(this.polls);
    // });
    this.user.userId=this.userId;
     this.surveyService.getSurvey(this.user).subscribe((AllPoll) => {
      this.surveys = AllPoll;
      console.log(this.surveys);
    });
  }
 
  getRootComments(surveyId: number): SurveyCommentInterface[] {
    console.log(surveyId)
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
 
  getCommentsCount(surveyId: number):number{
    return this.surveycomments.filter(comment => comment.survey.surveyId === surveyId).length;
  }

  setActiveComment(activeComment: SurveyActiveCommentInterface | null): void {
    this.activeComment = activeComment;
  }
 
  ac:SurveyCommentInterface = new SurveyCommentInterface();

  addComment({
    text,
    parentId,
    userId,
    surveyId: number
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

  // getReplie(commentId: string): CommentInterface[] {
  //   return this.comments
  //     // .filter((comment) => comment.parentId === commentId)
  //     .filter((comment) => comment.parentId != "0" || comment.id === comment.parentId)
  //     .sort(
  //       (a, b) =>
  //         new Date(a.createdAt).getTime() - new Date(b.createdAt).getTime()
  //     );
  // }
  
}