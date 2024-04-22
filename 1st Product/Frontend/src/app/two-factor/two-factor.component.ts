import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TwoFactorService } from '../Admin-Service/two-factor.service';
import { TwoFactor } from '../model/Twofactor';
 
@Component({
  selector: 'app-two-factor',
  templateUrl: './two-factor.component.html',
  styleUrls: ['./two-factor.component.css']
})
export class TwoFactorComponent implements OnInit {
 
 
  minutes: number = 1;
  seconds: number = 0;
  buttonDisabled: boolean = false;
  timer: any;
  count : number =0;
 
  otpForm: FormGroup;
  twofactor: TwoFactor;
  resend: TwoFactor;
  verificationResult: string = '';
  email!: string;
  userType!: string;
  message: string = '';
  updatedMessage : string ='';
  result!:string;
  forcepass!:string;
 
  constructor(
    private router: Router,
    private service: TwoFactorService
  ) {
    this.otpForm = new FormGroup({
      otp: new FormControl('', [Validators.required, Validators.pattern("[0-9]{6}")]),
    });
    this.twofactor = new TwoFactor();
    this.resend = new TwoFactor();
   
  }
 
  ngOnInit(): void {
    this.email = sessionStorage.getItem('email') || '';
    this.userType = sessionStorage.getItem('userType') || '';
    this.forcepass = sessionStorage.getItem('forcePass')|| '';
    this.resend.email=this.email;
    this.startTimer();
 
  }
 
 
  getOtp(data: any) {
    this.twofactor.otp = data.otp;
    this.twofactor.email = this.email;
 
    this.service.verifyOTP(this.twofactor).subscribe(
      (resultdata: any) => {
        this.verificationResult = resultdata.message;
        this.message = resultdata.message;
        if(this.message=="Valid OTP")
        {
          this.count=0;
          if (this.userType === "employee") {
            this.router.navigate(['/User']);
          } else if (this.userType === "admin") {
            this.router.navigate(['/Admin']);
          }
 
        }
 
        else if(this.message=="Invalid OTP")
        {
 
          if(this.count<4){
            this.count+=1;
            this.updatedMessage = "Invalid OTP, You have "+(5-this.count)+" attempts left";
          }else{
            this.count=0;
            this.router.navigate(['']);
          }
         
        }
       
      },
     
    );
  }
 
  resendOTP()
  {
    this.resend.email=this.email;
    this.service.resendOtp(this.resend);
   
  }
 
  startTimer() {
    this.buttonDisabled = true;
    clearInterval(this.timer);
    this.timer = setInterval(() => {
      if (this.seconds === 0) {
        if (this.minutes === 0) {
          clearInterval(this.timer);
          this.minutes = 1;
          this.seconds = 0;
          this.buttonDisabled = false;
          return;
        } else {
          this.minutes--;
          this.seconds = 59;
        }
      } else {
        this.seconds--;
      }
    }, 1000);
  }
 
}