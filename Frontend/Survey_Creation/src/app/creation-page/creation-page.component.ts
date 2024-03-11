import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SurveycreationService } from '../service/surveycreation.service';
import { Survey } from '../model/survey';
import { Region } from '../model/region';
import { Department } from '../model/department';
import { Project } from '../model/project';

@Component({
  selector: 'app-creation-page',
  templateUrl: './creation-page.component.html',
  styleUrls: ['./creation-page.component.css']
})
export class CreationPageComponent {

  survey: Survey;
  region: Region;
  department: Department;
  project: Project;
  myform: FormGroup;
  result: string = "";
  RegionList: Region[] = [];
  DeptList: Department[] = [];
  ProjectList: Project[] = [];

  constructor(private service: SurveycreationService) {
    this.survey = new Survey;
    this.region = new Region;
    this.department = new Department;
    this.project = new Project;

    this.myform = new FormGroup(
      {
        surveyName: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z + 0-9]+')]),
        endDate: new FormControl('', [Validators.required, Validators.pattern('/^(([1-9])|([0][1-9])|([1-2][0-9])|([3][0-1]))(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\d{4}$/gi')]),
        region: new FormControl('', [Validators.required, Validators.pattern('')]),
        department: new FormControl('', [Validators.required]),
        project: new FormControl('', [Validators.required]),
      }
    );

  }

  createSurvey(data: any) {
    this.survey.surveyName = data.surveyName;
    this.survey.endDate = data.endDate;
    this.survey.region = data.region;
    this.survey.department = data.department;
    this.survey.project = data.project;
    this.result = this.service.create(this.survey);
    alert(this.survey.surveyName + "" + this.survey.endDate);
  }

  insertRegion(data: any) {
    this.region.regionName = data.regionName;

    
  }

  insertDepartment(data: any) {
    this.department.departmentName = data.departmentName;
  }

  insertProject(data: any) {
    this.project.projectName = data.projectName;
  }

}