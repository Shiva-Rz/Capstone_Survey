import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { SurveyActiveCommentInterface } from '../../surveyComment-types/activeComment.interface';
import { ActiveCommentTypeEnum } from '../../surveyComment-types/activeCommentType.enum';
import { SurveyCommentInterface } from '../../surveyComment-types/survey-comment.interface';
import { SurveyCommentsService } from '../../surveyComment-services/survey-comments.service';
import { Survey } from 'src/app/Survey-Model/survey';
import { TemplateService } from 'src/app/survey-service/template.service';
import { Region } from 'src/app/Survey-Model/Region';
import { User } from 'src/app/Survey-Model/User';
 
@Component({
  selector: 'surveycomment',
  templateUrl: './SurveyComment.component.html',
  styleUrls:['./surveyComment.component.css'],
  
})
export class SurveyCommentComponent implements OnInit {
  @Input() surveycomment!: SurveyCommentInterface;
  @Input() activeComment!: SurveyActiveCommentInterface | null;
  @Input() surveyreplies!: SurveyCommentInterface[];
  @Input() currentUserId!: string;
  @Input() parentId!: string | null;
  @Input() surveyId! : number;
  @Output()
  setActiveComment = new EventEmitter<SurveyActiveCommentInterface | null>();
  @Output()
  deleteComment = new EventEmitter<string>();
  @Output()
  addComment = new EventEmitter<{ text: string; parentId: string | null, surveyId:any , userId:any}>();
  @Output()
  updateComment = new EventEmitter<{ text: string; commentId: string }>();
 
  survey: any;

  region:Region;
 
  surveys: Survey[] = [];
  user:User;
  userId:any=0;

  surveycomments!: SurveyCommentInterface[];
 
  createdAt: string = '';
  canReply: boolean = false;
  canEdit: boolean = false;
  canDelete: boolean = false;
  activeCommentType = ActiveCommentTypeEnum;
  replyId: string | null = null;
 
  constructor(private surveyService: TemplateService,private commentsService: SurveyCommentsService)
  {
this.region=new Region;
this.user=new User;
this.userId=sessionStorage.getItem("userId") || "";
  }
  ngOnInit(): void {    
    const fiveMinutes = 300000;
    const timePassed =
      new Date().getMilliseconds() -
        new Date(this.surveycomment.createdAt).getMilliseconds() >
      fiveMinutes;
    this.createdAt = new Date(this.surveycomment.createdAt).toLocaleDateString();
    this.canReply = !timePassed;
    // this.canEdit = this.currentUserId === this.comment.userId && !timePassed;
    // this.canDelete =
    //   this.currentUserId === this.comment.userId &&
    //   this.replies.length === 0 &&
    //   !timePassed;
    this.canEdit = Boolean(this.currentUserId) && !timePassed;
    this.canDelete = this.surveyreplies.length === 0 && !timePassed;
    this.replyId = this.parentId ? this.parentId : this.surveycomment.id;
    this.user.userId=this.userId;
    this.surveyService.getSurvey(this.user).subscribe((AllPoll) => {
      this.surveys = AllPoll;
      console.log(this.surveys);
    });
    
    this.commentsService.getComments().subscribe((comments) => {
      this.surveycomments = comments;
      console.log(comments);
    });
  }
 
  isReplying(): boolean {
    if (!this.activeComment) {
      return false;
    }
    return (
      this.activeComment.id === this.surveycomment.id &&
      this.activeComment.type === this.activeCommentType.replying
    );
  }
 
  isEditing(): boolean {
    if (!this.activeComment) {
      return false;
    }
    return (
      this.activeComment.id === this.surveycomment.id &&
      this.activeComment.type === 'editing'
    );
  }
}