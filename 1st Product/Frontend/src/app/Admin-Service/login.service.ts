
// import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
// import { Observable } from 'rxjs';
// import { Login } from './model/Login';

// @Injectable({
//   providedIn: 'root'
// })
// export class LoginService {
//   private baseUrl: string = 'http://localhost:4992'; // Update with your backend URL

//   constructor(private http: HttpClient) { }

//   login(loginData: Login): Observable<string> {
    
//     return this.http.post<string>( this.baseUrl+"/login", loginData);
    
//   }
// }

// login.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Login } from '../model/Login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private baseUrl: string = 'http://localhost:4050'; // Update with your backend URL

  constructor(private http: HttpClient) { }

  login(loginData: Login): Observable<any> {
    return this.http.post<any>(this.baseUrl + "/login", loginData);
  }  
}