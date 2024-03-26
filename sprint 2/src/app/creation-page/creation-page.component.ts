import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
// import { SurveycreationService } from '../service/surveycreation.service';
import { Survey } from '../model/survey';
import { Region } from '../model/region';
import { Department } from '../model/department';
import { Project } from '../model/project';
import { SurveycreationService } from '../service/surveycreation.service'; 
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-creation-page',
  templateUrl: './creation-page.component.html',
  styleUrls: ['./creation-page.component.css']
})
export class CreationPageComponent {

  flagregion: boolean = false;
  flagdept: boolean = false;
  flagbtn: boolean = true;
  survey: Survey;
  region: Region;
  value: String;
  department: Department;
  project: Project;
  myform: FormGroup;
  result: string = "";
  RegionList: Region[] = [];
  DeptList: Department[] = [];
  ProjectList: Project[] = [];
  Allreg!: number;
  Alldept!: number;
  Allproj!: number;
  route: boolean = true;

  flag: boolean = true;

  constructor(private service: SurveycreationService, private router: Router) {
    this.survey = new Survey;
    this.region = new Region;
    this.department = new Department;
    this.project = new Project;
    this.value = new String;
    this.Allreg = 1;
    this.Alldept = 1;
    this.Allproj = 1;

    this.myform = new FormGroup(
      {
        surveyName: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
        endDate: new FormControl('', [Validators.required, Validators.pattern('/^(([1-9])|([0][1-9])|([1-2][0-9])|([3][0-1]))(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\d{4}$/gi')]),
        region: new FormControl('', [Validators.required, Validators.pattern('')]),
        regionId: new FormControl('', [Validators.required, Validators.pattern('')]),
        department: new FormControl('', [Validators.required]),
        departmentId: new FormControl('', [Validators.required]),
        project: new FormControl('', [Validators.required]),
        projectId: new FormControl('', [Validators.required]),
      }
    );

    this.getRegion();
  }

  createSurvey(data: any) {
    this.survey.surveyName = data.surveyName;
    this.survey.endDate = data.endDate;
    this.survey.region = data.regionId;
    this.survey.department = data.departmentId;
    this.survey.project = data.projectId;
    // this.survey.region = (this.region.regionId = data.regionId);
    // this.survey.department = (this.department.departmentId = data.departmentId);
    // this.survey.project = (this.project.projectId = data.projectId);
    // this.survey.department.departmentId = data.department.departmentId;
    // this.survey.project.projectId = data.project.projectId;
    // alert("Region" + this.survey.region);
    this.service.create(this.survey).subscribe({

      next: (res: any) => {
        this.router.navigate(['/create/builder']);
        // alert("Successfully created");
      }, error: () => {
        alert("Survey Details Required");
      }
    });
    // alert("Region "+this.survey.region);
    //   this.result=this.service.create(this.survey);
  }

  // insertRegion(data: any) {
  //   this.region.regionName = data.regionName;
  // }

  // insertDepartment(data: any) {
  //   this.department.departmentName = data.departmentName;
  // }

  // insertProject(data: any) {
  //   this.project.projectName = data.projectName;
  // }

  getRegion() {
    this.service.getAllRegions().subscribe(regions => this.RegionList = regions);
  }

  getDepartment(data: any) {
    this.region.regionId = data.regionId;
    this.service.getAllDepartments(this.region).subscribe(departments => this.DeptList = departments);
    // alert(this.region.regionId)
    this.flagregion = true;
    // if (this.region.regionId != this.Allreg) {

    // }
  }

  getProject(data: any) {
    this.department.departmentId = data.departmentId;
    this.service.getAllProjects(this.department).subscribe(projects => this.ProjectList = projects);
    // alert(this.department.departmentId);
    this.flagdept = true;
    // if (this.department.departmentId != this.Alldept) {

    // }
  }

  changeregion() {
    this.flagregion = true;
  }

  changedept() {
    this.flagdept = true;
  }

}