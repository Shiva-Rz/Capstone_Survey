import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { Reaction } from '../model/Reaction';

@Injectable({
  providedIn: 'root'
})
export class ReactionService {

  private url: string = 'http://localhost:4992';

  constructor(private http: HttpClient,private httpClient: HttpClient) { }
 
  reactionInsert(reactionData : Reaction)
  {
    console.log("Reaction inserted");
    console.log(reactionData)
    this.http.post(this.url+'/reactionInsert', reactionData).subscribe();
    return "Reaction Inserted!" ;
  }
 
  getAllReactionCount(id:any): Observable<any>
  {
    return this.http.get(this.url +"/getReactionCount/"+id);
  }

  getAllResponseCount(id:any):Observable <any>{
    return this.http.get(this.url+"/getOptionResponseCount/"+id)
  }
  reactionDelete(pollId: number):string
  {
    this.http.delete(this.url+'/reactionDelete', {responseType: 'text'}).subscribe();
    return "Reaction Deleted!" ;
  }
  
}
