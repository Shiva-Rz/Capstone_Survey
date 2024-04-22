
import { Component, Input, OnInit } from '@angular/core';  
  
import { Router } from '@angular/router';  


import { MatDialog } from '@angular/material/dialog';
import { TexteditorComponent } from '../texteditor/texteditor.component';

import { ActiveCommentInterface } from '../Post-Comments/postComment-types/activeComment.interface';
import { Content } from '../Post-Model/content';
import { Reaction } from '../Post-Model/postreaction';
import { ContentService } from '../Post_Services/content.service';
import { ReactionService } from '../Post_Services/reaction.service';
import { User } from '../Post-Model/User';
import { PostCommentInterface } from '../Post-Comments/postComment-types/PostComment.interface';
import { PostCommentsService } from '../Post-Comments/postComment-services/PostComments.service';
@Component({
  selector: 'app-postregion',
  templateUrl: './postregion.component.html',
  styleUrls: ['./postregion.component.css']
})
export class PostregionComponent  implements OnInit {  
  // res: any;  
  Content:Content[]=[];
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

 
  comment: PostCommentInterface[]=[];
 
  comments: PostCommentInterface[]=[];

  user: User;

  isShow : boolean[]=[];
 
  isLike : boolean[]=[];
  userId:any;
 
  @Input() currentUserId!: string;

  @Input() postId!: number;
 
  activeComment: ActiveCommentInterface | null = null;
 
  

 

  
 

  
  constructor(private contentservice:ContentService,private reactionService: ReactionService,private router : Router,private dialog: MatDialog,private commentsService : PostCommentsService) { 
    this.date=new Date;

    this.reactionData = new Reaction();
    this.Reaction;
    this.user=new User;
    this.userId=sessionStorage.getItem("userId") || "";

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
 
  ngOnInit() {  
    // this.Getcontent();
    
    //new code By post 
    this.getPost();
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
    this.comments=comments;
    console.log(comments);
  })
   }  

  TotalnumberofLikes:{[postId:number]:number}={};
  TotalnumberofDisLikes:number=25;
  flag:number=0;
  dislikeS :string = "dislike-button";
  likeS : string = "like-button";




  getRootComments(postId: number): PostCommentInterface[] {
    return this.comments.filter((comment) => (comment.parentId == "0" && comment.post.postId === postId));
    //return this.comments;
    console.log(this.comments);
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
 
 

  setActiveComment(activeComment: ActiveCommentInterface | null): void {
    this.activeComment = activeComment;
  }
 
  ac:PostCommentInterface = new PostCommentInterface();

  addComment({
    text,
    parentId,
    userId,
    postId: number
  }: {
    text: string;
    parentId: string | null;
    userId: any,
    postId: number
  }): void {

    //this.ac.pollId = this.ac.pollId;
    this.commentsService
      .createComment(text, parentId,this.postId,userId)
      .subscribe((createdComment) => {
        this.ac.userId="1";
        // createdComment.pollId=this.poll.pollId;
        this.comments = [...this.comments, createdComment];
        this.activeComment = null;
      });
      console.log(this.comments)
  }
 
  getReplies(commentId: string): PostCommentInterface[] {
    return this.comments
      .filter((comment) => comment.parentId === commentId)
      //.filter((comment) => comment.parentId != "0")
      .sort(
        (a, b) =>
          new Date(a.createdAt).getTime() - new Date(b.createdAt).getTime()
      );
  }


  getCommentsCount(postId:number):number {
    return this.comments.filter(comment => comment.post.postId === postId).length;
  }

    posrn:Reaction=new Reaction();
      reactionInsert(postId : number)
      {
             this.posrn.userId=1;
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
      
 
  // Getcontent()  
  // {  
  //   this.contentservice. getAllPosts().subscribe((data:any)=>{  
  //     this.post=data;  
  //     this.terms= this.Content[1].pageContentTitle;  
  //     this.cont= this.Content[1].Content;  
  //     // console.log(this.Content);  
  //   })  
  // }  


  //new code By post 
  getPost() {
    console.log(this.userId);
    this.user.userId = this.userId;
    console.log(this.user.userId);
    this.contentservice.getpost(this.user).subscribe((data:any) => {
      this.Content = data;
      // this.terms= this.Content[1].pageContentTitle;  
      // this.cont= this.Content[1].Content; 
      console.log(this.Content)
    });
  }

  // getSurvey(user: User): Observable<any> {
  //   return this.http.get(this.url + "/getsurveyregion/" + user.userId);
  // }



  receiveComment($event : any) {
    this.comments = $event;
    this.count = this.comments.length;
    console.log(this.comments.length);
  }

  recieveCount($event : any) {
    this.comments = $event;
    this.count = this.comments.length;
  }
  openPost(): void {
    const dialogRef = this.dialog.open(TexteditorComponent, {
      width: '1000px',
      // height: '400px',
      position: { top: "160px",left: "350px"},
     
    });



  }
}

