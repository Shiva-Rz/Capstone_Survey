import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { LoginService } from '../Admin-Service/login.service';

import { Login } from '../model/Login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup;
  loginModel: Login = new Login();
  message: string = '';

  constructor(private loginService: LoginService, private router: Router) {
    this.loginForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.pattern("^[0-9.a-z._%+-]+@gmail\.com$")]),
      password: new FormControl('',Validators.required)
    });
  }

  login(): void {
    if (this.loginForm.valid) {
      this.loginModel.userEmailId = this.loginForm.get('email')!.value;
      this.loginModel.password = this.loginForm.get('password')!.value;
      this.loginService.login(this.loginModel).subscribe(
        (response: any) => {
          if(response.message =="newUser"){
            sessionStorage.setItem('email', response.email);
            sessionStorage.setItem('token', response.token);
            this.router.navigate(['/forcepasswordreset']);
          }else{
            sessionStorage.setItem('token', response.token);
            sessionStorage.setItem('userType', response.userType);
            sessionStorage.setItem('email', response.email);
            sessionStorage.setItem('userId',response.userId);
            sessionStorage.setItem('forcePass',response.ForcePass);
            sessionStorage.setItem('regionId', response.regionId);
            sessionStorage.setItem('departmentId', response.departmentId);
            sessionStorage.setItem('projectId', response.projectId);
          this.router.navigate(['/TwoFactor']);
        }
          }
          ,
        (error: any) => {
          this.message = error.error.message;
        }
      );
    }
  }  
}
