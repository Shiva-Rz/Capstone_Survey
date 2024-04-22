import { Component, OnInit } from '@angular/core';
import { Content } from '../Post-Model/content';

import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { TexteditorComponent } from '../texteditor/texteditor.component';
import { DrafteditComponent } from '../draftedit/draftedit.component';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ContentService } from '../Post_Services/content.service';
import { ReactionService } from '../Post_Services/reaction.service';


@Component({
  selector: 'app-draft',
  templateUrl: './postdraft.component.html',
  styleUrls: ['./postdraft.component.css']
})
export class PostDraftComponent implements OnInit {
  
  Content: any;
  terms: any;
  cont: any;
  date: Date;
  content: Content[] = [];
  con!: Content;
  post:Content;

  result: string = "";



  lists: any;

  selected!: number;
  
  count!: number;

  Reaction: any;

  reactionFlag: number = 0;


value:any;

  comments!: string;

  User: any;

  constructor(private contentservice: ContentService, private reactionService: ReactionService, private router: Router, private dialog: MatDialog) {
    this.date = new Date;

    this.Reaction;
    this.post=new Content;
    // this.value=localStorage.getItem("id");
    // console.log(this.value);
  }

  isShow = true;

  isLike = false;
  likedPostId: number | null = null;

  isOptionIdHide = true;

  isHide = true;


  toggleDisplay(postId: number) {
    if (this.likedPostId === postId) {
      this.isShow = !this.isShow;
      this.isLike = !this.isLike;
    }
  }

  toggleDisplayComment() {
    this.isHide = !this.isHide;
  }

  ngOnInit() {
    this.Getcontent();
    if (!localStorage.getItem('viewpost')) {
      localStorage.setItem('viewpost', 'no reload')
      location.reload()
    } else {
      localStorage.removeItem('viewpost')
    }

    this.count = 0;
  }

  TotalnumberofLikes: { [postId: number]: number } = {};
  TotalnumberofDisLikes: number = 25;
  flag: number = 0;
  dislikeS: string = "dislike-button";
  likeS: string = "like-button";


  Getcontent() {
    this.contentservice.getAllDrafts().subscribe((data: any) => {
      this.Content = data;
      this.terms = this.Content[1].pageContentTitle;
      this.cont = this.Content[1].Content;

    })
  }


  deletecontent(postId: number) {
    
     alert("Do you want to delete this Draft");
    this.contentservice.deleteDraft(postId).subscribe(
      (response: any) => {
        console.log('Post deleted successfully:', response);

        this.Content = this.Content.filter((content: Content) => content.postId !== postId);

      },
      (error: any) => {
        console.error('Error deleting post:', error);

      }
      
    );
    
  }

  // getValue(data:any){
  //   console.log(data);
  // }


  receiveComment($event: any) {
    this.comments = $event;
    this.count = this.comments.length;
    console.log(this.comments.length);
  }

  recieveCount($event: any) {
    this.comments = $event;
    this.count = this.comments.length;
  }

  openPost(data:any){
  
  this.post=data;
  this.value=this.post.postId;
  sessionStorage.setItem("editId",this.value);

  this.router.navigate(['/edit']);

  }
 
  // openPost(content?: Content) { 
  //   alert("Do you want to edit this Draft");
  //   if (content) {
  //     localStorage.setItem("id", content.postId.toString());
  //     this.contentservice.updateDraft(content).subscribe(fetchedContent => {
  //       const draftContent = fetchedContent?.postContent; 
  //       const dialogRef = this.dialog.open(DrafteditComponent, {
  //         width: '1000px',
  //         position: { top: "100px", left: "290px" },
  //         data: draftContent ? { draftContent } : null 
  //       });
  
  //       dialogRef.afterClosed().subscribe(result => {
  //         // Check if the post was shared
  //         if (result === 'shared') {
  //           this.deletecontent(content.postId);
  //         }
  //       });
  //     });
  //   } else {
  //     const dialogRef = this.dialog.open(DrafteditComponent, {
  //       width: '1000px',
  //       position: { top: "100px", left: "290px" },
  //       data: null
  //     });
  //   }
  // }
}

