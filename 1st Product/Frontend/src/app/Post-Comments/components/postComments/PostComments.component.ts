import { Component, Input, OnInit } from '@angular/core'; 


import { ActiveCommentInterface } from '../../postComment-types/activeComment.interface'; 


import { Content } from 'src/app/Post-Model/content';
import { Region } from 'src/app/Post-Model/Region';
import { ContentService } from 'src/app/Post_Services/content.service';
import { PostCommentInterface } from '../../postComment-types/PostComment.interface';
import { PostCommentsService } from '../../postComment-services/PostComments.service';




  

@Component({ 

  selector: 'PostComments', 

  templateUrl: './PostComments.component.html', 

}) 

export class PostCommentsComponent implements OnInit { 

  @Input() currentUserId!: string; 

  @Input() postId!: number; 

  PostComments: PostCommentInterface[] = []; 

  PostComment!: PostCommentInterface; 

  activeComment: ActiveCommentInterface | null = null; 

  

  post!: Content; 

  region:Region; 

 

  Content: any; 

  

  posts: Content[] = []; 

 

  isHide:boolean[]=Array(this.posts.length).fill(true); 

 

  toggleDisplayComment(surveyId:number) { 

    this.isHide[surveyId] = !this.isHide[surveyId]; 

  } 

  // comment!: CommentInterface[]; 

 

  constructor(private commentsService: PostCommentsService,private contentService: ContentService) { 

    this.region=new Region; 

  } 

  

  ngOnInit(): void { 

    this.commentsService.getComments().subscribe((comments) => { 

      this.PostComments = comments; 

      console.log(comments); 

    }); 

 

    // this.pollService.get(1).subscribe((AllPoll) => { 

    //   this.polls = AllPoll; 

    //   console.log(this.polls); 

    // }); 

   

     this.contentService.getAllPosts().subscribe((AllPoll) => { 

      this.posts = AllPoll; 

      console.log(this.posts); 

    }); 

  } 

  

  getRootComments(postId: number): PostCommentInterface[] { 

    return this.PostComments.filter((comment) => (comment.parentId == "0" && comment.post.postId === postId)); 

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

  

  getCommentsCount(postId: number):number{ 

    return this.PostComments.filter(comment => comment.post.postId === postId).length; 

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

        this.PostComments = [...this.PostComments, createdComment]; 

        this.activeComment = null; 

      }); 

      console.log(this.PostComments) 

  } 

  

  getReplies(commentId: string): PostCommentInterface[] { 

    return this.PostComments 

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

 