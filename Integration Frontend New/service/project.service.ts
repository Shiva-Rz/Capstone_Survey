import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Project } from '../model/Project';
import { Department } from '../model/Department';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private url: string = "http://localhost:4050"



  constructor(private http: HttpClient) { }

  insertProject(project: Project) {

    this.http.post(this.url + "/insertProjects", project).subscribe();
    return "Project Added";
  }
  getAlldepartments() {
    return this.http.get<Department[]>(this.url + "/findAllDepartments");
  }
  getAllprojects() {
    return this.http.get<Project[]>(this.url + "/findAllProjects");
  }

  updateProject(project: Project) {
    this.http.put(this.url + "/updateProjects", project).subscribe();
    return "Project Updated";

  }

  deleteproject(project: any) {

    this.http.delete(this.url + "/deleteProjects/" + project.projectId).subscribe();
    return "Project Deleted";

  }
  getDetails(project:Project){
    
    return this.http.get<Project[]>(this.url+"/viewProjects/"+project.projectId);
  }
}
