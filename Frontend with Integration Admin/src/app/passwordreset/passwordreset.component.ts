import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Reset } from '../model/Rest';
import { ResetService } from '../reset.service';

@Component({
  selector: 'app-passwordreset',
  templateUrl: './passwordreset.component.html',
  styleUrls: ['./passwordreset.component.css']
})
export class PasswordresetComponent {

  passwordresetForm: FormGroup;
  reset: Reset;
  result: string = "";
  email!: string;
  message: string = '';

  constructor(private service: ResetService) {
    this.passwordresetForm = new FormGroup({
      oldPass: new FormControl('', [Validators.required]),
      newPass: new FormControl('', [Validators.required]),
      confirmPass: new FormControl('', [Validators.required]),
    });
    this.reset = new Reset();
  }

  ngOnInit(): void {
    this.email = sessionStorage.getItem("email") || '';
    this.reset.email = this.email;
  }

  dataSave(data: any): void {
    const resetData: Reset = {
      otp: "",
      oldPassword: data.oldPass,
      newPassword: data.newPass,
      confirmPassword: data.confirmPass,
      email: this.email
     
    };

    this.service.updatePass(resetData).subscribe(
      (respoonse:any) => {
        this.message = "Password Updated";
        this.result=respoonse.message;
        if (this.result=="Password updated successfully."){
          alert("Password updated successfully, login again.")
          window.location.href=' ';
        }
        
      },
      (error) => {
        this.message = error.error.message;
      }
    );
  }
}