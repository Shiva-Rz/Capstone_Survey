import { Injectable, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { CommentInterface } from '../types/comment.interface';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class CommentsService {
 
  commentSurveyId:any=0;
  userId:any=0;
  constructor(private httpClient: HttpClient) {
    this.commentSurveyId=sessionStorage.getItem("commentSurveyId") || "";
    console.log(this.commentSurveyId);
    this.userId=sessionStorage.getItem("userId") || "";
    console.log(this.userId);
    // this.commentSurveyId=this.value;
    // console.log(this.userId);
  }

  getComments(): Observable<CommentInterface[]> {
    return this.httpClient.get<CommentInterface[]>(
      'http://localhost:4050/commentsFind'
    );
  }

  // ngOnInit(){
    
  // }

  createComment(
    text: string,
    parentId: string | null = null,
    userId:any,
    surveyId:any
  ): Observable<CommentInterface> {

    // console.log(surveyId)
    console.log(this.commentSurveyId);
    return this.httpClient.post<CommentInterface>(
      'http://localhost:4050/comments',
      {
        body: text,
        parentId,
        userId : this.userId,
        surveyId:this.commentSurveyId,
        createdAt: new Date().toISOString(),
      }
    );
  }

  updateComment(id: string, text: string): Observable<CommentInterface> {
    return this.httpClient.patch<CommentInterface>(
      `http://localhost:4050/comments/${id}`,
      {
        body: text,
      }
    );
  }

  deleteComment(id: string): Observable<{}> {
    return this.httpClient.delete(`http://localhost:4050/comments/${id}`);
  }
}
