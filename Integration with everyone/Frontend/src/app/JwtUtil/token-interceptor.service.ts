import { Injectable } from '@angular/core';
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    const token = sessionStorage.getItem('token');
  
    if (token) {
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`

          }
      });
  //  alert( request.headers.get('Authorization'));
    }
    return next.handle(request);
  }
}