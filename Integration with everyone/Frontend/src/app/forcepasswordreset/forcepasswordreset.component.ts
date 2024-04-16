import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Reset } from 'src/app/model/Rest';

import { ForcePasswordResetService } from '../Admin-Service/force-password-reset.service';

@Component({
  selector: 'app-forcepasswordreset',
  templateUrl: './forcepasswordreset.component.html',
  styleUrls: ['./forcepasswordreset.component.css']
})
export class ForcepasswordresetComponent {

  forcepasswordresetForm: FormGroup;
  reset: Reset;
  result: string = "";
  email!: string;
  message: string = '';

  constructor(private service: ForcePasswordResetService) {
    this.forcepasswordresetForm = new FormGroup({
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

    this.service.insertPass(resetData).subscribe(
      (respoonse:any) => {
        this.message = "Password Updated";
        this.result=respoonse.message;
        if (this.result=="Password updated successfully."){
          alert("Password updated successfully, login again.")
          window.location.href=' ';
        }
        
      },
      (error) => {
        alert(this.email);
        this.message = error.error.message;
      }
    );
  }
}
