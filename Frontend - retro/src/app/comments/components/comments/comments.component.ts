import { Component, Input, OnInit } from '@angular/core';
import { CommentsService } from '../../services/comments.service';
import { ActiveCommentInterface } from '../../types/activeComment.interface';
import { CommentInterface } from '../../types/comment.interface';
import { Survey } from 'src/app/model/survey';
import { TemplateService } from 'src/app/service/template.service';
import { Region } from 'src/app/model/region';
 
@Component({
  selector: 'comments',
  templateUrl: './comments.component.html',
})
export class CommentsComponent implements OnInit {
  @Input() currentUserId!: string;
  @Input() surveyId!: number;
  comments: CommentInterface[] = [];
  comment!: CommentInterface;
  activeComment: ActiveCommentInterface | null = null;
 
  survey!: Survey;
  region:Region;

  Survey: any;
 
  surveys: Survey[] = [];

  isHide:boolean[]=Array(this.surveys.length).fill(true);

  toggleDisplayComment(surveyId:number) {
    this.isHide[surveyId] = !this.isHide[surveyId];
  }
  // comment!: CommentInterface[];

  constructor(private commentsService: CommentsService,private surveyService: TemplateService) {
    this.region=new Region;
  }
 
  ngOnInit(): void {
    this.commentsService.getComments().subscribe((comments) => {
      this.comments = comments;
      console.log(comments);
    });

    // this.pollService.get(1).subscribe((AllPoll) => {
    //   this.polls = AllPoll;
    //   console.log(this.polls);
    // });
    this.region.regionId=1;
     this.surveyService.getSurvey(this.region).subscribe((AllPoll) => {
      this.surveys = AllPoll;
      console.log(this.surveys);
    });
  }
 
  getRootComments(surveyId: number): CommentInterface[] {
    return this.comments.filter((comment) => (comment.parentId == "0" && comment.survey.surveyId === surveyId));
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
        this.comments = this.comments.map((comment) => {
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
      this.comments = this.comments.filter(
        (comment) => comment.id !== commentId
      );
    });
  }
 
  getCommentsCount(surveyId: number):number{
    return this.comments.filter(comment => comment.survey.surveyId === surveyId).length;
  }

  setActiveComment(activeComment: ActiveCommentInterface | null): void {
    this.activeComment = activeComment;
  }
 
  ac:CommentInterface = new CommentInterface();

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
        this.comments = [...this.comments, createdComment];
        this.activeComment = null;
      });
      console.log(this.comments)
  }
 
  getReplies(commentId: string): CommentInterface[] {
    return this.comments
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