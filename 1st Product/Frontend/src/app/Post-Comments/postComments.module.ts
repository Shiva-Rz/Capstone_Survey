import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';



import { PostCommentsComponent } from './components/postComments/PostComments.component';
import { PostCommentsService } from './postComment-services/PostComments.service';
import { PostCommentFormComment } from './components/postCommentForm/PostCommentForm.component';
import { PostCommentComponent } from './components/postComment/PostComment.component';

@NgModule({
  imports: [CommonModule, ReactiveFormsModule],
  declarations: [PostCommentsComponent,PostCommentFormComment,PostCommentComponent],
  providers: [PostCommentsService],
  exports: [PostCommentsComponent,PostCommentFormComment,PostCommentComponent],
})
export class PostCommentsModule {}
