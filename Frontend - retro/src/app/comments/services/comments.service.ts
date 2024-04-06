import { Injectable, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { CommentInterface } from '../types/comment.interface';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class CommentsService {
  constructor(private httpClient: HttpClient) {}

  getComments(): Observable<CommentInterface[]> {
    return this.httpClient.get<CommentInterface[]>(
      'http://localhost:4050/commentsFind'
    );
  }

  createComment(
    text: string,
    parentId: string | null = null,
    userId:any,
    surveyId:any
  ): Observable<CommentInterface> {

    console.log(surveyId)
    return this.httpClient.post<CommentInterface>(
      'http://localhost:4050/comments',
      {
        body: text,
        parentId,
        userId : 1,
        surveyId:2,
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
