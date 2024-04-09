// import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
// import { TwoFactor } from './model/Twofactor';
// import { Observable } from 'rxjs';

// @Injectable({
//   providedIn: 'root'
// })
// export class TwoFactorService {
//   private url: string = "http://localhost:4992"; // Update the URL with your backend endpoint

//   constructor(private http: HttpClient) { }

//   sendOtp(twoFactor: TwoFactor): Observable<any>  {
//     return this.http.post<any>(this.url+"/verifyOTP", twoFactor);
//   }


// }

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TwoFactor } from '../model/Twofactor';
import { Observable } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class TwoFactorService {
  private url: string = "http://localhost:4050";
 
  constructor(private http: HttpClient) { }
 
  verifyOTP(twoFactor: TwoFactor): Observable<any>  {
    return this.http.post<any>(this.url+"/verifyOTP", twoFactor);
  }
 
 
  resendOtp(twoFactor: TwoFactor)  {
  this.http.get(this.url+"/resendOTP/"+ twoFactor.email).subscribe();
  }
}