import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActiveCommentInterface } from '../../types/activeComment.interface';
import { ActiveCommentTypeEnum } from '../../types/activeCommentType.enum';
import { CommentInterface } from '../../types/comment.interface';
import { CommentsService } from '../../services/comments.service';
import { Survey } from '../../../model/survey';
import { TemplateService } from '../../../service/template.service';
import { Region } from '../../../model/Region';
 
@Component({
  selector: 'comment',
  templateUrl: './comment.component.html',
})
export class CommentComponent implements OnInit {
  @Input() comment!: CommentInterface;
  @Input() activeComment!: ActiveCommentInterface | null;
  @Input() replies!: CommentInterface[];
  @Input() currentUserId!: string;
  @Input() parentId!: string | null;
  @Input() surveyId! : number;
  @Output()
  setActiveComment = new EventEmitter<ActiveCommentInterface | null>();
  @Output()
  deleteComment = new EventEmitter<string>();
  @Output()
  addComment = new EventEmitter<{ text: string; parentId: string | null, surveyId:any , userId:any}>();
  @Output()
  updateComment = new EventEmitter<{ text: string; commentId: string }>();
 
  survey: any;

  region:Region;
 
  surveys: Survey[] = [];

  comments!: CommentInterface[];
 
  createdAt: string = '';
  canReply: boolean = false;
  canEdit: boolean = false;
  canDelete: boolean = false;
  activeCommentType = ActiveCommentTypeEnum;
  replyId: string | null = null;
 
  constructor(private surveyService: TemplateService,private commentsService: CommentsService)
  {
this.region=new Region;
  }
  ngOnInit(): void {    
    const fiveMinutes = 300000;
    const timePassed =
      new Date().getMilliseconds() -
        new Date(this.comment.createdAt).getMilliseconds() >
      fiveMinutes;
    this.createdAt = new Date(this.comment.createdAt).toLocaleDateString();
    this.canReply = !timePassed;
    // this.canEdit = this.currentUserId === this.comment.userId && !timePassed;
    // this.canDelete =
    //   this.currentUserId === this.comment.userId &&
    //   this.replies.length === 0 &&
    //   !timePassed;
    this.canEdit = Boolean(this.currentUserId) && !timePassed;
    this.canDelete = this.replies.length === 0 && !timePassed;
    this.replyId = this.parentId ? this.parentId : this.comment.id;
    this.region.regionId=1;
    this.surveyService.getSurvey(this.region).subscribe((AllPoll) => {
      this.surveys = AllPoll;
      console.log(this.surveys);
    });
    
    this.commentsService.getComments().subscribe((comments) => {
      this.comments = comments;
      console.log(comments);
    });
  }
 
  isReplying(): boolean {
    if (!this.activeComment) {
      return false;
    }
    return (
      this.activeComment.id === this.comment.id &&
      this.activeComment.type === this.activeCommentType.replying
    );
  }
 
  isEditing(): boolean {
    if (!this.activeComment) {
      return false;
    }
    return (
      this.activeComment.id === this.comment.id &&
      this.activeComment.type === 'editing'
    );
  }
}