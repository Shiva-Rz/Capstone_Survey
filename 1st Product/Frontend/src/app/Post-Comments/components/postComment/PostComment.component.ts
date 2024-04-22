import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core'; 

import { ActiveCommentInterface } from '../../postComment-types/activeComment.interface'; 

import { ActiveCommentTypeEnum } from '../../postComment-types/activeCommentType.enum'; 




import { Region } from 'src/app/Post-Model/Region';
import { Content } from 'src/app/Post-Model/content';
import { ContentService } from 'src/app/Post_Services/content.service';
import { PostCommentInterface } from '../../postComment-types/PostComment.interface';
import { PostCommentsService } from '../../postComment-services/PostComments.service';

// import { Survey } from 'src/app/model/survey'; 

// import { TemplateService } from 'src/app/service/template.service'; 

// import { Region } from 'src/app/model/region'; 


  

@Component({ 

  selector: 'PostComment', 

  templateUrl: './PostComment.component.html', 

}) 

export class PostCommentComponent implements OnInit { 

  @Input() PostComment!: PostCommentInterface; 

  @Input() activeComment!: ActiveCommentInterface | null; 

  @Input() postreplies!: PostCommentInterface[]; 

  @Input() currentUserId!: string; 

  @Input() parentId!: string | null; 

  @Input() postId! : number; 

  @Output() 

  setActiveComment = new EventEmitter<ActiveCommentInterface | null>(); 

  @Output() 

  deleteComment = new EventEmitter<string>(); 

  @Output() 

  addComment = new EventEmitter<{ text: string; parentId: string | null, postId:any , userId:any}>(); 

  @Output() 

  updateComment = new EventEmitter<{ text: string; commentId: string }>(); 

  

  post: any; 

  userId:string='';
  userValue:number=0;


 

  region:Region; 

  

  posts: Content[] = []; 

 

  comments!: PostCommentInterface[]; 

  

  createdAt: string = ''; 

  canReply: boolean = false; 

  canEdit: boolean = false; 

  canDelete: boolean = false; 

  activeCommentType = ActiveCommentTypeEnum; 

  replyId: string | null = null; 

  

  constructor(private contentService: ContentService,private commentsService: PostCommentsService) 

  { 

this.region=new Region; 

  } 

  ngOnInit(): void {     

    const fiveMinutes = 300000; 

    const timePassed = 

      new Date().getMilliseconds() - 

        new Date(this.PostComment.createdAt).getMilliseconds() > 

      fiveMinutes; 

    this.createdAt = new Date(this.PostComment.createdAt).toLocaleDateString(); 

    this.canReply = !timePassed; 

     this.userId=sessionStorage.getItem("userId")||"";

    this.canEdit = Boolean(this.currentUserId) && !timePassed; 

    this.canDelete = this.postreplies.length === 0 && !timePassed; 

    this.replyId = this.parentId ? this.parentId : this.PostComment.id; 

    // this.region.regionId=1; 

    this.contentService.getAllPosts().subscribe((AllPoll) => { 

      this.posts = AllPoll; 

      console.log(this.posts); 

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

      this.activeComment.id === this.PostComment.id && 

      this.activeComment.type === this.activeCommentType.replying 

    ); 

  } 

  

  isEditing(): boolean { 

    if (!this.activeComment) { 

      return false; 

    } 

    return ( 

      this.activeComment.id === this.PostComment.id && 

      this.activeComment.type === 'editing' 

    ); 

  } 

} 

 