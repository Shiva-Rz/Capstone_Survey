import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { TwoFactor } from '../model/Twofactor';
import { Forgot } from '../model/Forgot';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ForgotpasswordService {

  private url:string="http://localhost:4050"

  constructor(private http:HttpClient,private router: Router) { 

   
  }
  verifyEmail(forgot:Forgot)
  {
    return this.http.get<Forgot[]>(this.url+"/forgetPassword/"+forgot.email);
  }

  verifyOTP(forgot:Forgot): Observable<any>  {
    return this.http.post<any>(this.url+"/ForgetVerifyOTP", forgot);
  }

  resetPassword(forgot:Forgot): Observable<any>  {
    // alert(forgot.email + forgot.newPassword + forgot.confirmPassword);

    return this.http.post<any>(this.url+"/updateForgetPassword", forgot);
  }

  resendForgotOtp(forgot:Forgot)  {
    
    this.http.get(this.url+"/forgetPassword/"+ forgot.email).subscribe();
    }

    






  // verifyOTP(twoFactor: TwoFactor): Observable<any>  {
  //   return this.http.post<any>(this.url+"/verifyOTP", twoFactor);
  // }


}
