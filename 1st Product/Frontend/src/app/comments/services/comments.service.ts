import { Injectable, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { CommentInterface } from '../types/comment.interface';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class CommentsService {
  constructor(private httpClient: HttpClient) {}

  getComments(): Observable<CommentInterface[]> {
    return this.httpClient.get<CommentInterface[]>(
      'http://localhost:4992/commentsFind'
    );
  }

  createComment(
    text: string,
    parentId: string | null = null,
    pollId:any,
    userId:any
  ): Observable<CommentInterface> {

    console.log(pollId)
    return this.httpClient.post<any>(
      'http://localhost:4992/comments',
      {
        body: text,
        parentId,
        userId : userId,
        pollId:pollId,
        createdAt: new Date().toISOString(),
      }
    );
  }

  updateComment(id: string, text: string): Observable<CommentInterface> {
    return this.httpClient.patch<CommentInterface>(
      `http://localhost:4992/comments/${id}`,
      {
        body: text,
      }
    );
  }

  deleteComment(id: string): Observable<{}> {
    return this.httpClient.delete(`http://localhost:4992/comments/${id}`);
  }
}
