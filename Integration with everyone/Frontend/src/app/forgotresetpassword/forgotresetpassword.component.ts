import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Forgot } from '../model/Forgot';
import { ForgotpasswordService } from '../Admin-Service/forgotpassword.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forgotresetpassword',
  templateUrl: './forgotresetpassword.component.html',
  styleUrls: ['./forgotresetpassword.component.css']
})
export class ForgotresetpasswordComponent {

  passwordresetForm: FormGroup;
  forgot: Forgot;

  result: string = '';
  message: string = '';
  email: string = '';


  constructor(private service: ForgotpasswordService, private router: Router) {
    this.passwordresetForm = new FormGroup({

      newPass: new FormControl('', [Validators.required]),
      confirmPass: new FormControl('', [Validators.required]),
    });
    this.forgot = new Forgot();

  }


  ngOnInit(): void {
    this.email = sessionStorage.getItem('forgotEmail') || '';


  }

  resetPassword(data: any) {
    this.forgot.email = this.email;
    this.forgot.newPassword = data.newPass;
    this.forgot.confirmPassword = data.confirmPass;
    // alert(this.forgot.email + this.forgot.newPassword + this.forgot.confirmPassword);
    this.service.resetPassword(this.forgot).subscribe(
      (resultdata: any) => {
        this.message = resultdata.message;

        if (this.message == "New Password set successfully") {

          alert("New Password set successfully");
          this.router.navigate(['']);
          this.result="New Password set successfully";


        }

        else if (this.message == "Confirm Password and new Password must be same") {
          // alert("Confirm Password and new Password must be same");
          this.result="Confirm Password and New Password must be same";

        }

        else if (this.message == "new Password must be new one") {
          // alert("new Password must be new one");
          this.result="Enter a new Password (Don't use the previous passwords)";
        }


      },
    )


  }





}
