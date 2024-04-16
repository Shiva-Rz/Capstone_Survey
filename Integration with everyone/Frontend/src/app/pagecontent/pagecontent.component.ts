import { Component, Input, OnInit } from '@angular/core';  


import { MatDialog } from '@angular/material/dialog';
import { TexteditorComponent } from '../texteditor/texteditor.component';

import { ActiveCommentInterface } from '../Post-Comments/postComment-types/activeComment.interface';
import { Router } from '@angular/router';
import { Content } from '../Post-Model/content';
import { Reaction } from '../Post-Model/postreaction';
import { ContentService } from '../Post_Services/content.service';
import { ReactionService } from '../Post_Services/reaction.service';
import { PostCommentInterface } from '../Post-Comments/postComment-types/PostComment.interface';
import { PostCommentsService } from '../Post-Comments/postComment-services/PostComments.service';
@Component({  
  selector: 'app-pagecontent',  
  templateUrl: './pagecontent.component.html',  
  styleUrls: ['./pagecontent.component.css']  
})  
export class PagecontentComponent implements OnInit {  

  flag1:boolean=true;
  flag2:boolean=false;
  // res: any;  
  Content:any;
  terms: any;  
  cont: any;
  date:Date;
  post: Content[]=[];
  contentList: Content[]=[];
 
  reactionData : Reaction;
 
  result : string = "";
 
  reaction!: Reaction[];
 
  lists: any;
 
  selected!: number;
 
 
  count!: number;
 
  Reaction: any;
 
  reactionFlag: number = 0;
 
 
  PostComment: PostCommentInterface[]=[];
 
  PostComments: PostCommentInterface[]=[];
 
  User: any;
 
  isShow : boolean[]=[];
 
  isLike : boolean[]=[];
 
  @Input() currentUserId!: string;
 
  @Input() postId!: number;
  @Input() disableComments:boolean = false;
 
  activeComment: ActiveCommentInterface | null = null;
 
  posts:any | undefined;

  userId:any;
 
 
  constructor(private contentservice:ContentService,private reactionService: ReactionService,private router : Router,private dialog: MatDialog,private commentsService : PostCommentsService) {
    this.date=new Date;
 
    this.reactionData = new Reaction();
    this.Reaction;
  }  
 
 
 
 
  isOptionIdHide = true;
 
  isHide:boolean[]=Array(this.post.length).fill(true);
 
  isHideComment = true;
 
  toggleDisplay(postId:number) {
   
    this.isShow[postId] = !this.isShow[postId];
    this.isLike[postId] = !this.isLike[postId];
   
  }
 
  toggleDisplayComment(postId:number) {
    this.isHide[postId] = !this.isHide[postId];
    this.isHideComment=!this.isHideComment;
  }
 
  ngOnInit():void {  

    this.userId = sessionStorage.getItem("userId") || "";
    this.Getcontent();
    const navigation=this.router.getCurrentNavigation();
    if(navigation && navigation.extras.state) {
      this.post=navigation.extras.state['posts'];
      this.disableComments=navigation.extras.state['disableComments']|| false;
    }
 
    if (!localStorage.getItem('viewpost')) {
      localStorage.setItem('viewpost', 'no reload')
      location.reload()
    } else {
      localStorage.removeItem('viewpost')
    }
  //   this.reactionService.getAllReactionCount().subscribe(ReactionCount => {
  //    this.Reaction = ReactionCount;
  //   //  console.log(this.Reaction);
  //  });
   this.count = 0;
   this.commentsService.getComments().subscribe((comments) => {
    this.PostComments=comments;
    console.log(comments);
  })
   }  
 
  TotalnumberofLikes:{[postId:number]:number}={};
  TotalnumberofDisLikes:number=25;
  flag:number=0;
  dislikeS :string = "dislike-button";
  likeS : string = "like-button";
 
 
 
 
  getRootComments(postId: number): PostCommentInterface[] {
    return this.PostComments.filter((comment) => (comment.parentId == "0" && comment.post.postId === postId));
    //return this.comments;
    console.log(this.PostComments);
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
        this.PostComments = this.PostComments.map((comment) => {
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
      this.PostComments = this.PostComments.filter(
        (comment) => comment.id !== commentId
      );
    });
  }
 
 
 
  setActiveComment(activeComment: ActiveCommentInterface | null): void {
    this.activeComment = activeComment;
  }
 
  ac:PostCommentInterface = new PostCommentInterface();
 
  
  getReplies(commentId: string): PostCommentInterface[] {
    return this.PostComments
      .filter((comment) => comment.parentId === commentId)
      //.filter((comment) => comment.parentId != "0")
      .sort(
        (a, b) =>
          new Date(a.createdAt).getTime() - new Date(b.createdAt).getTime()
      );
  }
 
 
  getCommentsCount(postId:number):number {
    return this.PostComments.filter(comment => comment.post.postId === postId).length;
  }
 
    posrn:Reaction=new Reaction();
      reactionInsert(postId : number)
      {
             this.posrn.userId=this.userId;
             this.posrn.postId=postId;
           
             if(this.TotalnumberofLikes[postId]){
               delete this.TotalnumberofLikes[postId];
               this.result = this.reactionService.reactionDelete(postId);
             }else{
               this.TotalnumberofLikes[postId]=1;
               this.result = this.reactionService.reactionInsert(this.posrn);
             }
             //  this.Reaction;
              console.log(this.result);
     
             if (this.TotalnumberofLikes[postId])
             {
             this.TotalnumberofLikes[postId]=1;
             }
             else{
               this.TotalnumberofLikes[postId]--;
             }
            }
     
 
  Getcontent()  
  {  
    this.contentservice. getAllPosts().subscribe((data:any)=>{  
      this.post=data;  
      this.terms= this.Content[1].pageContentTitle;  
      this.cont= this.Content[1].Content;  
      // console.log(this.Content);  
    })  
  }  
  receiveComment($event : any) {
    this.PostComments = $event;
    this.count = this.PostComments.length;
    console.log(this.PostComments.length);
  }
 
  recieveCount($event : any) {
    this.PostComments = $event;
    this.count = this.PostComments.length;
  }
  openPost(): void {
    // const dialogRef = this.dialog.open(TexteditorComponent, {
    //   width: '1000px',
    //   // height: '400px',
    //   position: { top: "100px",left: "290px"},
     
    // });
  // // this.flag1=!this.flag1;
  this.flag2=!this.flag2;
 
 
 
  }
 
 
  addCommentById({
    text,
    parentId,
    postId,
    userId,
     }: {
    text: any;
    parentId: any | null;
    postId: any
    userId: any,
   
  }): void {
 
    //this.ac.pollId = this.ac.pollId;
    this.commentsService
      .createComment(text, parentId,postId,userId)
      .subscribe()
       
     
      console.log(this.PostComments)
  }
 
  handleDisableCommentsChanged(disableComments:boolean){
    this.disableComments=disableComments;
  }
 
}