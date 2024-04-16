import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Forgot } from '../model/Forgot';
import { Router } from '@angular/router';
import { ForgotpasswordService } from '../Admin-Service/forgotpassword.service';

@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.css']
})
export class ForgotpasswordComponent {

  forgotForm: FormGroup;
  // result:String;
  forgot: Forgot;
  
  result: string = '';
  message: string = '';



  constructor(
    private router: Router,
    private service: ForgotpasswordService
  ) {

    this.forgotForm = new FormGroup(
      {
        email: new FormControl('', [Validators.required, Validators.pattern("[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]),
      }
    );
    this.forgot = new Forgot();
  }


  verifyEmail(data: any) {
    // alert(data.email);
    this.forgot.email = data.email;

    this.service.verifyEmail(this.forgot).subscribe(
      (resultdata: any) => {
        // this.verificationResult = resultdata.message;
        this.message = resultdata.message;

        if (this.message == "valid email") {

         sessionStorage.setItem("forgotEmail", this.forgot.email);
           this.router.navigate(["/forgotpasswordotp"]);
        }

        else if(this.message="Invalid email"){

          this.result="Invalid email";
        }

        

      },

    );




  }






}