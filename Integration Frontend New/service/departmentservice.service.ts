import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Department } from '../model/Department';
import { Region } from '../model/Region';
@Injectable({
  providedIn: 'root'
})
export class DepartmentserviceService {

  private url: string = "http://localhost:4050"

  constructor(private http: HttpClient) { }

  insertDepartment(department: Department) {
    this.http.post(this.url + "/insertDepartments", department).subscribe();
    return "Department Added";
  }

  updateDepartment(department: Department) {
    this.http.put(this.url + "/updateDepartments", department).subscribe();
    return "Department Updated";

  }

  delete(department: any) {

    this.http.delete(this.url + "/deleteDepartments/" + department.departmentId).subscribe();
    return "Department Deleted";

  }

  getAlldepartments() {
    return this.http.get<Department[]>(this.url + "/findAllDepartments");
  }

  getParticularDepartment(department:Department) {
    return this.http.get<Department[]>(this.url + "/getDepartment/"+department.region);
  }
  getAlldetails() {
    return this.http.get<Region[]>(this.url + "/findAllRegions");
  }

  getDetails(department:Department){
    return this.http.get<Department[]>(this.url+"/ViewDepartments/"+department.departmentId);
  }
}
