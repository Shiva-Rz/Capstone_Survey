import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Department } from "../Admin-Model/Department";
import { OptionResponseNew } from "../Admin-Model/OptionResponseNew";
import { Project } from "../Admin-Model/Project";
import { Region } from "../Admin-Model/Region";
import { User } from "../Admin-Model/User";
 
@Injectable({
  providedIn: "root",
})
export class PollService {
  private url: string = "http://localhost:4992";
 
  constructor(private http: HttpClient) {}
 
  get(id: any): Observable<any> {
    console.log(id);
    return this.http.get(this.url + "/poll/" + id);
  }
 
  getAllPolls(): Observable<any> {
    return this.http.get<User[]>(this.url + "/published");
  }
 
  getDraftById(pollId:number):Observable<any>
{
  console.log(pollId);
  return this.http.get(this.url+"/draft/"+pollId);
}
 
 
 
  getDraft(): Observable<any> {
    return this.http.get<User[]>(this.url + "/drafts");
  }
 
  getOption(): Observable<any> {
    return this.http.get(this.url + "/options");
  }
  getOptionResponse(): Observable<any> {
    return this.http.get(this.url + "/optionResponse");
  }
 
  getAllPoll(): Observable<any> {
    return this.http.get(this.url + "/poll");
  }
 
  getOptionResponseInsert(optresponse: OptionResponseNew) {
    console.log(optresponse);
    this.http.post(this.url + "/optionResponse", optresponse).subscribe();
    return "Record Response Inserted";
  }
 
  addPoll(poll: any) {
    console.log(poll);
    this.http.post<any>(this.url + "/poll", poll).subscribe();
  }
 
  getOptionCount(id: any): Observable<any> {
    console.log(id);
    return this.http.get(this.url + "/getOptionCount/" + id);
  }
 
  getAllRegions() {
    return this.http.get<Region[]>("http://localhost:4050" + "/findAllRegions");
  }
  getAllDepartments(region: Region) {
    return this.http.get<Department[]>(
      "http://localhost:4050" + "/getDepartment/" + region.regionId
    );
  }
  getAllProjects(department: Department) {
    return this.http.get<Project[]>(
      "http://localhost:4050" + "/getProject/" + department.departmentId
    );
  }
 
  viewAllUserDetails() {
    return this.http.get<User[]>("http://localhost:4050" + "/findAllEmployees");
  }
 
  getData(user: User) {
    this.url = "http://localhost:4050" + "filterData";
    return this.get(this.url + "/userFirstName/" + user);
  }
 
  getUsersByFirstName(firstName: string): Observable<User[]> {
    return this.http.get<User[]>(`${"http://localhost:4050"}/userFirstName?user=${firstName}`);
  }
 
  // vote(optionIndex: any) {
  //   console.log(optionIndex)
  //   return this.http.post<any>(this.url+'/vote/'+optionIndex, {});
  // }
 
  getVoteCounts(id:any) {
    return this.http.get<any>(this.url+'/counts/'+id);
  }
 
  // vote(votes: any) {
  //   console.log(votes)
  //   return this.http.post<any>(this.url+'/votes', {});
  // }
 
  // getVoteCounts(optionId:any) {
  //   return this.http.get<any>(this.url+'/counts/'+optionId);
  // }
 
  vote(pollId: number, optionId: number, userId: any): Observable<any> {
    console.log(userId)
    return this.http.post<any>(`${this.url}/${pollId}/${optionId}/${userId}`, {});
  }
 
  updateVote(optionId: any, userId:any):Observable<any>{
    console.log(optionId,userId)
return this.http.put<any>(`${this.url}/${optionId}/${userId}`, {});
  }
 
  // getVoteCounts(voteId: number): Observable<any> {
  //   return this.http.get<any>(`${this.url}/${voteId}`);
  // }
  //Delete Draft
  deleteDraft(pollId: number) {
    alert("Draft Service");
    console.log(pollId);
    console.log(this.url + "/poll/" + pollId);
    return this.http.delete<number>(this.url + "/poll/" + pollId).subscribe(
      (response: any) => {
        // Assuming the response is not a specific model type
        console.log("Poll deleted successfully:", response);
      },
      (error: any) => {
        // Assuming the error object doesn't have a specific type
        console.error("Error deleting poll:", error);
        // Handle the error appropriately, e.g., display an error message
      }
    );
  }
 
  updateDraft(data:any)
  {
    return this.http.put(this.url +'/updateDraft', data);
  }
  getDraftOptionsById(pollId:number):Observable<any>
  {
    console.log(pollId);
    return this.http.get(this.url+"/draftOption/"+pollId);
  }
 
  changeStatus(): Observable<any>{
    return this.http.get(this.url + "/changeStatus");
  }
 
  getUserRegionPoll(userId : number){
    return this.http.get(this.url + "/getpollregionuser/"+userId);
  }
 
  getAllUsers(): Observable<any> {
    return this.http.get("http://localhost:4050"+"/findAllEmployees")
  }
}
 