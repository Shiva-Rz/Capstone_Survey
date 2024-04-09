import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './model/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url:string="http://localhost:4050"

  constructor(private http:HttpClient,private router: Router) {

   }

   Configure(user:User)
  {
    this.http.put(this.url+"/updateUsers",user).subscribe();
    return "User Configured";

  }

  getAllUsers()
  {
    return this.http.get<User[]>(this.url+"/findAllUsers");
  }

  getAllEmployee(user:User){
    return this.http.get<User[]>(this.url+"/findAllEmployees/"+user.userId);
  }

}
