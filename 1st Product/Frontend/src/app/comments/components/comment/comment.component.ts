import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActiveCommentInterface } from '../../types/activeComment.interface';
import { ActiveCommentTypeEnum } from '../../types/activeCommentType.enum';
import { CommentInterface } from '../../types/comment.interface';

import { CommentsService } from '../../services/comments.service';
import { Poll } from 'src/app/model/poll';
import { PollService } from 'src/app/Admin-Service/poll.service';
@Component({
  selector: 'comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css'],
})
export class CommentComponent implements OnInit {
  @Input() comment!: CommentInterface;
  @Input() activeComment!: ActiveCommentInterface | null;
  @Input() replies!: CommentInterface[];
  @Input() currentUserId!: string;
  @Input() parentId!: string | null;
  @Input() pollId! : number;
  @Output()
  setActiveComment = new EventEmitter<ActiveCommentInterface | null>();
  @Output()
  deleteComment = new EventEmitter<string>();
  @Output()
  addComment = new EventEmitter<{ text: string; parentId: string | null, pollId:any , userId:any}>();
  @Output()
  updateComment = new EventEmitter<{ text: string; commentId: string }>();
  userId: string = '';
  Poll: any;
  userValue:number=0;
  polls: Poll[] = [];

  comments!: CommentInterface[];
 
  createdAt: string = '';
  canReply: boolean = false;
  canEdit: boolean = false;
  canDelete: boolean = false;
  activeCommentType = ActiveCommentTypeEnum;
  replyId: string | null = null;
 
  constructor(private pollService: PollService,private commentsService: CommentsService)
  {

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
    
    this.pollService.getAllPoll().subscribe((AllPoll) => {
      this.polls = AllPoll;
      console.log(this.polls);
    });
    
    this.commentsService.getComments().subscribe((comments) => {
      this.comments = comments;
      console.log(comments);
    });
    this.userId =  sessionStorage.getItem("userId") || "";
    console.log(this.userId)
    //this.userValue = parseInt(this.polluserId);
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