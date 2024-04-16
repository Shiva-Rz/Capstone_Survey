import { Injectable, Input } from '@angular/core';
import { Observable } from 'rxjs';

import { HttpClient } from '@angular/common/http';
import { PostCommentInterface } from '../postComment-types/PostComment.interface';

@Injectable()
export class PostCommentsService {
  userId:any;
  constructor(private httpClient: HttpClient) {
   this.userId=sessionStorage.getItem("userId") || "";
  }

  getComments(): Observable<PostCommentInterface[]> {
    return this.httpClient.get<PostCommentInterface[]>(
      'http://localhost:1090/commentsFind'
    );
  }

  createComment(
    text: string,
    parentId: string | null = null,
    postId:number,
    userId:any,
   
  ): Observable<PostCommentInterface> {

    console.log(postId)
    return this.httpClient.post<any>(
      'http://localhost:1090/comments',
      {
        body: text,
        parentId,
        userId : this.userId,
        postId : postId,
        createdAt: new Date().toISOString(),
      }
    );
  }

  updateComment(id: string, text: string): Observable<PostCommentInterface> {
    return this.httpClient.patch<PostCommentInterface>(
      `http://localhost:1090/comments/${id}`,
      {
        body: text,
      }
    );
  }

  deleteComment(id: string): Observable<{}> {
    return this.httpClient.delete(`http://localhost:1090/comments/${id}`);
  }
}
