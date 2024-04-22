import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Department } from '../Survey-Model/Department';
import { Project } from '../Survey-Model/Project';
import { Region } from '../Survey-Model/Region';
import { Survey } from 'src/app/Survey-Model/survey';
import { Observable } from 'rxjs';
import { Response } from '../Survey-Model/Response';
// import { Survey } from '../model/survey';
// import { Region } from '../model/region';
// import { Department } from '../model/department';
// import { Project } from '../model/project';

@Injectable({
  providedIn: 'root'
})
export class SurveycreationService {

  private url: string = "http://localhost:4050";

  constructor(private http: HttpClient) { }

  create(survey: Survey):Observable<any> {
    return  this.http.post(this.url + "/survey", survey);
  }

  getAllRegions() {
    return this.http.get<Region[]>(this.url + "/findAllRegions");
  }

  getAllDepartments(region: Region) {
    return this.http.get<Department[]>(this.url + "/getdepartment/" + region.regionId);

  }

  getAllProjects(department: Department) {
    return this.http.get<Project[]>(this.url + "/getProject/" + department.departmentId);
  }
}
