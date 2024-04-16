import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Forgot } from '../model/Forgot';
import { ForgotpasswordService } from '../Admin-Service/forgotpassword.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forgot-passwordotp',
  templateUrl: './forgot-passwordotp.component.html',
  styleUrls: ['./forgot-passwordotp.component.css']
})
export class ForgotPasswordotpComponent {
  minutes: number = 1;
  seconds: number = 0;
  buttonDisabled: boolean = false;
  timer: any;
  count : number =0;
  updatedMessage : string ='';

  otpForm: FormGroup;
  email:string='';
  forgot:Forgot;
  verificationResult: string = '';
  result: string = '';

  message: string = '';


 
  constructor(
    private router: Router,
    private service: ForgotpasswordService
  ) {
    this.otpForm = new FormGroup({
      otp: new FormControl('', [Validators.required, Validators.pattern("[0-9]{6}")]),
    });
    this.forgot = new Forgot();

  
  }
  ngOnInit(): void {
    this.email = sessionStorage.getItem('forgotEmail') || '';
    this.startTimer();
   
  }

  
  getOtp(data: any) {
   
    this.forgot.otp = data.otp;
    this.forgot.email = this.email;
 
    this.service.verifyOTP(this.forgot).subscribe(
      (resultdata: any) => {
        this.message = resultdata.message;

        if(this.message=="Valid OTP")
        {
          
            this.router.navigate(['/forgotresetpassword']);
         
         
 
        }
 
        else if(this.message=="Invalid OTP.")
        {
          
 
            if(this.count<4){
              this.count+=1;
              this.updatedMessage = "Invalid OTP, You have "+(5-this.count)+" attempts left";
            }else{
              this.count=0;
              this.router.navigate(['']);
            }
           
          }
;          

        
        
       
      },
     
    );
  }
  resendOTP()
  {
    this.forgot.email=this.email;
    this.service.resendForgotOtp(this.forgot);
   
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