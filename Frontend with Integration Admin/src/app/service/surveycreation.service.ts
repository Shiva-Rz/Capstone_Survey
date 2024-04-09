import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Department } from '../model/Department';
import { Project } from '../model/Project';
import { Region } from '../model/Region';
import { Survey } from 'src/app/model/survey';
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

  create(survey: Survey) {
    return  this.http.post(this.url + "/survey", survey);
      // "Record Inserted"
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
