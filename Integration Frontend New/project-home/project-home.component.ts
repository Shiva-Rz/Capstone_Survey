import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Project } from '../model/Project';
import { Department } from '../model/Department';
import { ProjectService } from '../service/project.service';
import { DepartmentserviceService } from '../service/departmentservice.service';
import { RegionService } from '../service/region.service';
import { Region } from '../model/Region';

@Component({
  selector: 'app-project-home',
  templateUrl: './project-home.component.html',
  styleUrls: ['./project-home.component.css']
})
export class ProjectHomeComponent {

  myForm: FormGroup;
  myForm1: FormGroup;
  projectList: Project[] = [];
  depList: Department[] = [];
  depList1: Department[] = [];
  regList: Region[] = [];
  region: Region;
  project: Project;
  result: string = "";
  startDate: any;
  department: Department;
  projectDetail: Project;

  constructor(private service: ProjectService, private router: Router, private departmentService: DepartmentserviceService, private regionservice: RegionService) {
    this.project = new Project;
    this.region = new Region;
    this.myForm = new FormGroup(
      {


        regionId: new FormControl('',[Validators.required]),
        projectId: new FormControl(''),
        projectName: new FormControl('', [Validators.required,Validators.pattern('[a-z A-Z]+')]),
        startDate: new FormControl('', [Validators.required]),
        endDate: new FormControl('', [Validators.required]),
        departmentId: new FormControl('',[Validators.required])




      }
    );
    this.myForm1 = new FormGroup(
      {


        regionId: new FormControl('', ),
        projectId: new FormControl('', [Validators.required]),
        projectName: new FormControl('', [Validators.required,Validators.pattern('[a-z A-Z]+')]),
        startDate: new FormControl('', [Validators.required]),
        endDate: new FormControl('', [Validators.required]),
        departmentId: new FormControl('')




      }
    );
    this.getAlldepartment();
    this.getAllRegion();
    this.getAllProject();
    this.department = new Department;
    this.projectDetail = new Project;


  }

  insertProject(data: any) {
    this.project.projectName = data.projectName;
    this.project.startDate = data.startDate;
    this.project.endDate = data.endDate;
    this.project.department = data.departmentId;


    this.result = this.service.insertProject(this.project);
    // console.log(this.startDate);

  }




  getdepartment(data: any) {
    this.department.region = data.regionId;
    this.departmentService.getParticularDepartment(this.department).subscribe(departments => this.depList = departments)
  }

  getAlldepartment() {
    this.service.getAlldepartments().subscribe(departments => this.depList1 = departments)
  }
  getAllRegion() {

    this.regionservice.getAlldetails().subscribe(regions => this.regList = regions)
  }

  getAllProject() {
    this.service.getAllprojects().subscribe(projects => this.projectList = projects)

  }
  delete(data: any) {

    this.project.projectId = data.projectId;

    this.result = this.service.deleteproject(this.project);
    this.getAllProject();
  }

  dataCollect(data: any) {
    this.projectDetail.projectId = data.projectId;
    this.projectDetail.projectName = data.projectName;
    this.projectDetail.startDate = data.startDate;
    this.projectDetail.endDate = data.endDate;
    this.projectDetail.department = data.department;
    this.projectDetail.departmentName = data.departmentName;


  }

  updateProject(data: any) {

    this.project.projectId = data.projectId;
    this.project.projectName = data.projectName;
    this.project.startDate = data.startDate;
    this.project.endDate = data.endDate;
    this.project.department = data.departmentId;

    //  alert(this.project.projectId+this.project.projectName+this.project.startDate+this.project.endDate+   this.project.department)

    this.result = this.service.updateProject(this.project);

  }
  onDateChange(data: any) {
    const startDate = new Date(data.startDate);
 
 
    const currentDate = new Date();
 
    if (startDate < currentDate) {
 
      this.myForm.get('startDate')?.setErrors({ 'invalidDate': true });
 
    }
    else {
      this.myForm.get('startDate')?.setErrors(null);
    }
 
 
  }
 
  onDateChange1(data: any) {
 
    const endDate = new Date(data.endDate);
    const startDate = new Date(data.startDate);
 
 
    if (endDate <= startDate) {
      this.myForm.get('endDate')?.setErrors({ 'invalidDate': true });
    }
    else {
      this.myForm.get('endDate')?.setErrors(null);
 
    }
 
 
 
 
 
  }
  }


  



