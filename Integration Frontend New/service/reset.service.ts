import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Reset } from '../model/Rest';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ResetService {

  private url: string = "http://localhost:4050";
 
  constructor(private http: HttpClient) { }
 
  verifyOTP(reset: Reset): Observable<any>  {
    return this.http.post<any>(this.url+"/verifyResetOTP", reset);
  }
 
  resendOtp(reset: Reset)  {
    // alert("OTP sent to7"reset.email);
  this.http.get(this.url+"/sendResetOTP/"+ reset.email).subscribe();
  }

  updatePass(reset: Reset): Observable<any> {
    return this.http.put<any>(this.url + "/updatePassword", {
      email: reset.email,
      oldPassword: reset.oldPassword,
      newPassword: reset.newPassword,
      confirmPassword: reset.confirmPassword
    });
  }
}
