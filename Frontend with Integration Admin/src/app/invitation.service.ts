import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class InvitationService {

  private url: string = "http://localhost:4050";
 
  constructor(private http: HttpClient) { }

  inviteUser(email: string){
   return this.http.get(this.url+"/inviteUserByMail/"+ email);
  }
}
