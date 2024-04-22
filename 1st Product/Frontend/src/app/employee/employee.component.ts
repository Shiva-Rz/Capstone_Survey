import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { Department } from '../model/Department';
import { User } from '../Admin-Model/User';
import { PollService } from '../Admin-Service/poll.service';


@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent {
  [x: string]: any;

  // private user = new User();  
  // private data;  
  

  Employee = true;
  toggleDisplayEmployee()
  {
this.Employee = !this.Employee;
  }
  user: User[] = [];
  

  department?:Department;
  users: User[] = [];
  searchName: string = '';
 
 
  

  constructor(private _fb: FormBuilder,
      private Polling: PollService) { 

      }
      form = new FormGroup({  
               userFirstName : new FormControl(),  
             });  
  ngOnInit(): void {
    this.getUser();
  
  }

  searchUsers(): void {
    if (this.searchName.trim() !== '') {
      
      this.Polling.getUsersByFirstName(this.searchName)
        .subscribe(users => {
         
          this.user = users;
          console.log(this.user);
        });
    }

  }

  isView =true;



  isViewEmployee = true;

  toggleViewEmployee()
  {
    this.isViewEmployee = !this.isViewEmployee;
    this.isView = !this.isView;
  }
  private getUser() {
    this.Polling.viewAllUserDetails().subscribe(data => {
      this.user = data;
       this.user = data;

      console.log("User List", this.user);
    });
  }

  
  searchForm(_searchInfo: any)  
{  
      this.getUser= this['userFirstName'].value;  
}  
getData()  
{  
  return this['form'].get('userFirstName');  
} 
}
