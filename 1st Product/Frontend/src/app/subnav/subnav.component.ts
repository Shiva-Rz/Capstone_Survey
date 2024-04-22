import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Reset } from '../Post-Model/Rest';
import { ResetService } from '../Admin-Service/reset.service';
@Component({
  selector: 'app-subnav',
  templateUrl: './subnav.component.html',
  styleUrls: ['./subnav.component.css']
})
export class SubnavComponent {

  
  reset: Reset;
  resendOtp: Reset;
  email!: string;
  
  constructor(private router:Router,private service: ResetService ){
    this.reset = new Reset();
    this.resendOtp = new Reset();
    
  }

  ngOnInit(): void {
    this.email = sessionStorage.getItem('email') || '';
  
  }
  myPasswordResetFunction(e: any){
    var txt;
  if (confirm("Do you want to reset your password ? Yes or No.")) {
    this.resendOTP();
    this.router.navigate(['Reset']);    
  } else {
   
    location.reload();
  }
 }

 resendOTP()
  {
    this.resendOtp.email=this.email;
    this.service.resendOtp(this.resendOtp);
   
  }


  
  inviteEmployeeFunction(e:any) {
    let text;
    let person = prompt("Please enter Inviting person email ID:");
    if (person == null || person == "") {
      text = "User cancelled the prompt.";
    }
    else if(person.match("^[0-9.a-z._%+-]+@gmail\.com$")){
        this.router.navigate(['Reset']);    
    }
    else{
      location.reload();
    }
  }

  logout(){
    sessionStorage.clear();
    this.router.navigate(['']);
  }


}
