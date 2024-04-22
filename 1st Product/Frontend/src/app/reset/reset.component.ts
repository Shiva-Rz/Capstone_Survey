import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TwoFactorService } from '../Admin-Service/two-factor.service';
import { Reset } from '../model/Rest'; 
import { ResetService } from '../Admin-Service/reset.service';

@Component({
  selector: 'app-reset',
  templateUrl: './reset.component.html',
  styleUrls: ['./reset.component.css']
})
export class ResetComponent {
  minutes: number = 2;
  seconds: number = 0;
  buttonDisabled: boolean = false;
  timer: any;

  otpForm: FormGroup;
  reset: Reset;
  resendOtp: Reset; 
  verificationResult: string = '';
  email!: string;
  userType!: string;
  message: string = '';
  result!:string;
 
  constructor(private router: Router,private service: ResetService ) {
    this.otpForm = new FormGroup({
      otp: new FormControl('', [Validators.required, Validators.pattern("[0-9]{6}")]),
    });
    this.reset = new Reset();
    this.resendOtp = new Reset();
  }
 
  ngOnInit(): void {
    this.email = sessionStorage.getItem('email') || '';
    this.userType = sessionStorage.getItem('userType') || '';
    this.resendOtp.email=this.email;
    this.startTimer();
  }
 
  getOtp(data: any) {
    this.reset.otp = data.otp;
    this.reset.email = this.email;
 
    this.service.verifyOTP(this.reset).subscribe(
      (resultdata: any) => {
        this.verificationResult = resultdata.message;
        this.message = resultdata.message;
        if(this.message=="Valid OTP")
        {
            this.router.navigate(['/PasswordReset']);
        }
      },
     
    );
  }
 
  resendOTP()
  {
    this.resendOtp.email=this.email;
    this.service.resendOtp(this.resendOtp);
   
  }

  startTimer() {
    this.buttonDisabled = true;
    clearInterval(this.timer);
    this.timer = setInterval(() => {
      if (this.seconds === 0) {
        if (this.minutes === 0) {
          clearInterval(this.timer);
          this.minutes = 2;
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
