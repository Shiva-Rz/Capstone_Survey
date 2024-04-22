import { Injectable, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { SurveyCommentInterface } from '../surveyComment-types/survey-comment.interface';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class SurveyCommentsService {
 
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

  getComments(): Observable<SurveyCommentInterface[]> {
    return this.httpClient.get<SurveyCommentInterface[]>(
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
  ): Observable<SurveyCommentInterface> {
// console.log(surveyId)
    console.log(this.commentSurveyId);
    return this.httpClient.post<SurveyCommentInterface>(
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

  updateComment(id: string, text: string): Observable<SurveyCommentInterface> {
    return this.httpClient.patch<SurveyCommentInterface>(
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
