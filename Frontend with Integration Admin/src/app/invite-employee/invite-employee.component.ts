import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { Login } from '../model/Login';
import { InvitationService } from '../invitation.service';

@Component({
  selector: 'app-invite-employee',
  templateUrl: './invite-employee.component.html',
  styleUrls: ['./invite-employee.component.css']
})
export class InviteEmployeeComponent {inviteForm: FormGroup;
  loginModel: Login = new Login();
  message: string = '';
  message1: string = '';
  message2: string = '';
  message3: string = '';
  email :string = '';
  constructor(private loginService: LoginService, private router: Router,private invitation: InvitationService) {
    this.inviteForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.pattern("^[0-9.a-z._%+-]+@gmail\.com$")]),
      
    });
  }

  sendInvite(data:any) {
    this.loginModel.userEmailId = data.email;
    // alert( this.loginModel.userEmailId);
    this.invitation.inviteUser(this.loginModel.userEmailId).subscribe(
      (response: any) => {
        this.message = response.message;
        if(this.message ==="User already exist"){
          this.message2 = '';
          this.message3= '';
          this.message1 = this.message;
        }else if(this.message ==="User is Already Invited"){
          this.message1 = '';
          this.message3= '';
          this.message2 = this.message;
        }else{
          this.message2 = '';
          this.message1= '';
          this.message3 = this.message;
        }
      }
    )
  }  
}
