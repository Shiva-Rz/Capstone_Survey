import { Component } from '@angular/core';
import { User } from '../model/User';
import { EmployeeService } from '../service/employee.service';
import { FormControl, FormGroup, Validators,FormArray, FormBuilder } from '@angular/forms';
import { Department } from '../model/Department';
import { Project } from '../model/Project';
import { Region } from '../model/Region';
import { Router } from '@angular/router';
import { DepartmentserviceService } from '../service/departmentservice.service';
import { ProjectService } from '../service/project.service';
import { RegionService } from '../service/region.service';
import { Login } from '../model/Login';
import { LoginService } from '../service/login.service';
import { Reset } from '../model/Rest';
import { ForcePasswordResetService } from '../service/force-password-reset.service';

@Component({
  selector: 'app-employee-page',
  templateUrl: './employee-page.component.html',
  styleUrls: ['./employee-page.component.css']
})
export class EmployeePageComponent {

login:Login;
  user:User;
  result:string="";
  reset:Reset;
  
  
  generateList: User[] = [];
  employeemappingList: User[] = [];
  existingemployeeList: User[] = [];
  myForm: FormGroup;

  projectList: Project[] = [];
  projectList1: Project[] = [];

  depList: Department[] = [];
  depList1: Department[] = [];
  regList: Region[] = [];
  region: Region;
  project: Project;
  startDate: any;
  department: Department;

  loginDetail:Login;
  employeeDetail:User;
  employeeDetail1:User;
  flag:boolean;
  flag1:boolean;
  flag2:boolean;
  

 

 
  constructor(private formBuilder: FormBuilder,private loginservice : LoginService, private employeeservice:EmployeeService,private service: ProjectService, private router: Router, private departmentService: DepartmentserviceService, private regionservice: RegionService,private forcePasswordReset : ForcePasswordResetService) {
    this.project = new Project;
    this.region = new Region;
    this.user=new User;
    this.login = new Login;
    this.loginDetail=new Login;
    this.employeeDetail=new User;
    this.employeeDetail1=new User;
    this.reset = new Reset;
    this.flag=false;
    this.flag1=true;
    this.flag2=true;
    

   

     this.getAllEmployees();
     
     this.myForm = this.formBuilder.group( 
      { regionId: new FormControl(''),
        projectId: new FormControl(''),
        projectName: new FormControl(''),
        startDate: new FormControl(''),
        endDate: new FormControl(''),
        departmentId: new FormControl(''),
        userId:new FormControl(''),
        userFirstName: new FormControl(''),
        userLastName: new FormControl(''),
        userEmailId:new FormControl(''),
        userPassword:new FormControl(''),
        userType: new FormControl(''),
        userMobileNumber: new FormControl(''),
        department: new FormControl(''),
        region: new FormControl(''),
        project: new FormArray([], [Validators.required])
      });
     
      // this.forcePasswordReset;
    this.getAlldepartment();
    this.getAllEmployees() ;
    this.getAllRegion();
    this.getAllProject();
    this.getAllExistingEmployees();
    this.getEmployeeToGeneratePassword();
    this.department = new Department;
    this.project = new Project;


  }

  get projectControl(){
    return (<FormArray>this.myForm.get('project')).controls;
   }
  getdepartment(data: any) {
    this.department.region = data.regionId;
    this.departmentService.getParticularDepartment(this.department).subscribe(departments => this.depList = departments)
  }
  getproject(data: any) {
    this.project.department = data.departmentId;
    this.employeeservice.getparticularProject(this.project).subscribe(projects => this.projectList1 = projects)
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

  generateEmployeePassword(email:string){
    this.forcePasswordReset.generatePassword(email);
  }

  getAllEmployees() {
    this.employeeservice.getAllEmployees().subscribe(users => this.employeemappingList = users);
  }
  // getAllLoginEmployees() {
  //   this.loginservice.getAllLoggedEmployees().subscribe(logins => this.loginList = logins);
  // }
  getAllExistingEmployees() {
    this.employeeservice.getAllExistingEmployees().subscribe(employees => this.existingemployeeList = employees);
  }

  getEmployeeToGeneratePassword(){
   this.employeeservice.getEmployeeToGeneratePassword().subscribe(employees => this.generateList =employees);
  }

  dataCollect(data: any) {

    this.employeeDetail.userId = data.userId;
    this.employeeDetail.userFirstName=data.userFirstName;
    this.employeeDetail.userLastName=data.userLastName;
    this.employeeDetail.userMobileNumber=data.userMobileNumber;
    this.employeeDetail.userPassword=data.userPassword;
    this.employeeDetail.userEmailId=data.userEmailId;
    this.employeeDetail.userType=data.userType;   
    this.employeeDetail.department=data.department;    
    this.employeeDetail.region=data.region;
  }

  update(data: any) {
    this.user.userId = this.employeeDetail.userId;
    this.user.userFirstName=data.userFirstName;
    this.user.userLastName=this.employeeDetail.userLastName;
    this.user.userMobileNumber=this.employeeDetail.userMobileNumber;
    this.user.userPassword=this.employeeDetail.userPassword;
    this.user.userEmailId=this.employeeDetail.userEmailId;
    this.user.userType=this.employeeDetail.userType;
    this.user.department=data.departmentId;
    this.user.region=data.regionId;
    this.user.project=data.project;
    this.result = this.employeeservice.Configure(this.user);

  }

  addProject(){
    const control =new FormControl(null,[Validators.required]);
    (<FormArray>this.myForm.get('project')).push(control);
  }

  removeProject(index:number){
    (<FormArray>this.myForm.get('project')).removeAt(index);
    // this.projectControl.removeAt(index);
    
  }

 
}


  
  // getProject(userId:number)
  // {
  //   alert(userId);
  // }

  