import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { Reaction } from '../Post-Model/postreaction';





@Injectable({
  providedIn: 'root'
})
export class ReactionService {
  private url: string = "http://localhost:1090";

  constructor(private http: HttpClient,private httpClient: HttpClient) { }
 
  // reactionInsert(reactionData : Reaction)
  // {
  //   this.http.post(url+"/reactionInsert", reactionData , {responseType: 'text'}).subscribe();
  //   return "Reaction Inserted!" ;
  // }

  reactionInsert(reactionData : Reaction)
  {
    console.log("Reaction inserted");
    console.log(reactionData)
    this.http.post(this.url+"/reactionInsert", reactionData).subscribe();
    return "Reaction Inserted!" ;
  }

  // reactionDelete(postId: number):string
  // {
  //   this.http.delete('${url}/reactionDelete/{reactionId}', {responseType: 'text'}).subscribe();
  //   return "Reaction Deleted!" ;
  // }

  reactionDelete(postId: number):string
  {
    console.log("deleted");
    this.http.delete(this.url+'/reactionDelete', {responseType: 'text'}).subscribe();
    return "Reaction Deleted!" ;
  }

  getAllReactionCount(id:any): Observable<any>
  {
    return this.http.get(this.url+"/getReactionCount/"+id);
  }
 
  // getAllReactionCount(): Observable<any>
  // {
  //   return this.http.get(`${url}/viewAllReaction`);
  // }
}
