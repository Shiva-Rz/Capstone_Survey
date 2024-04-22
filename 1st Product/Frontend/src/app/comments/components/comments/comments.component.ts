import { Component, Input, OnInit } from '@angular/core';
import { CommentsService } from '../../services/comments.service';
import { ActiveCommentInterface } from '../../types/activeComment.interface';
import { CommentInterface } from '../../types/comment.interface';
import { Poll } from 'src/app/model/poll';
import { PollService } from 'src/app/Admin-Service/poll.service';

 
@Component({
  selector: 'comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css'],
})
export class CommentsComponent implements OnInit {
  @Input() currentUserId!: string;
  @Input() pollArray: Poll[] = [];
  @Input() Allpoll!: Poll;
  @Input() pollId!: number;
  comments: CommentInterface[] = [];
  comment!: CommentInterface;
  activeComment: ActiveCommentInterface | null = null;
 
  poll!: Poll;

  Poll: any;
 
  polls: Poll[] = [];

  isHide:boolean[]=Array(this.polls.length).fill(true);

  toggleDisplayComment(pollId:number) {
    this.isHide[pollId] = !this.isHide[pollId];
  }
  // comment!: CommentInterface[];

  constructor(private commentsService: CommentsService,private pollService: PollService) {}
 
  ngOnInit(): void {
    this.commentsService.getComments().subscribe((comments) => {
      this.comments = comments;
      console.log(comments);
    });

     this.pollService.getAllPoll().subscribe((AllPoll) => {
      this.polls = AllPoll;
      console.log(this.polls);
    });
    
  }

  getRootComments(pollId: number): CommentInterface[] {
    return this.comments.filter((comment) => (comment.parentId == "0" && comment.poll.pollId === pollId));
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
 
  getCommentsCount(pollId: number):number{
    return this.comments.filter(comment => comment.poll.pollId === pollId).length;
  }

  setActiveComment(activeComment: ActiveCommentInterface | null): void {
    this.activeComment = activeComment;
  }
 
  ac:CommentInterface = new CommentInterface();

  addComment({
    text,
    parentId,
    userId,
    pollId: number
  }: {
    text: string;
    parentId: string | null;
    userId: any,
    pollId: number
  }): void {

    //this.ac.pollId = this.ac.pollId;
    this.commentsService
      .createComment(text, parentId,this.pollId,userId)
      .subscribe((createdComment) => {
      
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