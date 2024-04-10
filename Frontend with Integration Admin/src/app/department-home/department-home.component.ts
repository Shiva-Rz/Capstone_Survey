import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Region } from '../model/Region';
import { DepartmentserviceService } from '../departmentservice.service';
import { RegionService } from '../region.service';
import { Department } from '../model/Department';

@Component({
  selector: 'app-department-home',
  templateUrl: './department-home.component.html',
  styleUrls: ['./department-home.component.css']
})
export class DepartmentHomeComponent {

  myForm: FormGroup;
  myForm1:FormGroup;
  regList: Region[] = [];
  department: Department;
  result:string="";
  depList:Department[]=[];
  departmentDetail:Department;
  constructor(private service: DepartmentserviceService, private router: Router, private regionService: RegionService) {
    this.department = new Department;
    this.myForm = new FormGroup(
      {
        departmentId:new FormControl(''),

        departmentName: new FormControl('', [Validators.required]),

        regionId: new FormControl('', [Validators.required]),




      }
    );
    this.myForm1 = new FormGroup(
      {
        departmentId:new FormControl('', [Validators.required]),
        departmentName: new FormControl('', [Validators.required]),

        regionId: new FormControl('', [Validators.required])




      }
    );
    this.getAllRegion();
    this.getAlldepartment();
    this.departmentDetail=new Department;
    
  
  }

  

  insertDepartment(data: any) {
    this.department.departmentName = data.departmentName;
    this.department.region = data.regionId;
    this.result=this.service.insertDepartment(this.department);
    

  }


  getAllRegion() {
    this.regionService.getAlldetails().subscribe(regions => this.regList = regions);
  }
  getAlldepartment() {
    this.service.getAlldepartments().subscribe(departments => this.depList = departments)
  }
 

  delete(data:any) {
    
    this.department.departmentId = data.departmentId;
  
    this.result = this.service.delete(this.department);
    this.getAlldepartment();
  }
  updateDepartment(data: any) {

    this.department.departmentId = data.departmentId;
    this.department.departmentName = data.departmentName;
    this.department.region=data.regionId;

    // alert(this.department.departmentId+this.department.departmentName+this.department.region);
    this.result=this.service.updateDepartment(this.department);
   
  }
  dataCollect(data: any) {
    this.departmentDetail.departmentId = data.departmentId;
    this.departmentDetail.departmentName = data.departmentName;
    this.departmentDetail.region=data.region;


  }

}
