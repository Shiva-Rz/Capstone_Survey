
import { Component } from '@angular/core';
import {
  AbstractControl,
  FormArray,
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { PollService } from '../Admin-Service/poll.service';
import { Department } from '../Admin-Model/Department';
import { PollValue } from '../model/PollValue';
import { Project } from '../Admin-Model/Project';
import { Region } from '../Admin-Model/Region';
import { Poll } from '../Admin-Model/poll';
import { DatePipe } from '@angular/common';

 
@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss'],
})
export class CreateComponent {
  title = 'PollCreate';
 
  options = FormArray;
  pollQuestion = '';
  value = [];
  result: any;
 
  Show = true;
 
  Hide = true;
 
  toggleDisplayView()
  {
    this.Show = !this.Show;
    this.Hide = !this.Hide;
  }
 
  toggle = true;
 
  label = false;
  toggleDisplayShare()
  {
this.toggle = !this.toggle;
this.label = !this.label;
  }
 
  RegionList: Region[] = [];
  DeptList: Department[] = [];
  ProjectList: Project[] = [];
  department: Department;
  project: Project;
  region: Region;
  Allreg!: number;
  Alldept!: number;
  Allproj!: number;
  poll: Poll;
  userId!: string;
  public pollForm: FormGroup;
 
  deptValue:string = '';
 
  projectId:string='';
 
  departmentId:string='';
 
  regionId: string = '';
 
  deptVal:number = 0;
 
  startDate : any;
 
  compareDate : any;
 
  msg :string ='';  
   
  ngOnInit(){
    this.projectId = sessionStorage.getItem('projectId') || "";
    // this.deptValue = parseInt(this.projectId);
  console.log(this.projectId.toString());
  this.deptValue = this.projectId.substring(2,1);
  this.deptVal = parseInt(this.deptValue);
  console.log(this.deptValue);
  console.log(this.deptVal)
}
   
 
 
  constructor(private _fb: FormBuilder, private Polling: PollService, private datePipe : DatePipe) {
    this.region = new Region();
 
    this.department = new Department();
 
    this.project = new Project();
 
    this.Allreg = 1;
 
    this.Alldept = 1;
 
    this.Allproj = 1;
    this.poll = new Poll();
 
    this.pollForm = this._fb.group({
      pollQuestion: new FormControl('', [Validators.required]),
      options: this._fb.array(
        [this.addPollGroup()],
        [Validators.required, Validators.minLength(2)]
      ),
      regionId: new FormControl('', [
       
        Validators.pattern(''),
      ]),
      departmentId: new FormControl('', []),
      projectId: new FormControl('', []),
      endDate: new FormControl('', [Validators.required]),
    });
    this.getRegion();
  }
 
  private addPollGroup(): FormGroup {
    return this._fb.group({
      value: ['', Validators.required ],
 
    });
  }
 
 
  minLengthArray(min: number) {
    return (c: AbstractControl): { [key: string]: any } => {
      if (c.value.length >= min) {
        return { minLengthArray: { valid: true } };
      }
      return { minLengthArray: { valid: false } };
    };
  }
 
  //Add Fields
  addOption(): void {
    this.optionArray.push(this.addPollGroup());
  }
 
  //Remove Fields
  removeOption(index: number): void {
    this.optionArray.removeAt(index);
  }
  //Fields Array
  get optionArray(): FormArray {
    return <FormArray>this.pollForm.get('options');
  }
 
  pl: PollValue = new PollValue();
 
  createPoll(data: any) {
    this.pl.pollQuestion = data.pollQuestion;
    this.pl.options = data.options;
    this.pl.status = true;
    this.pl.endDate = data.endDate;
    // this.pl.region = data.regionId;
    // this.pl.department = data.departmentId;
    // this.pl.project = data.projectId;
    this.pl.region = sessionStorage.getItem('regionId') || '';
    this.pl.department = sessionStorage.getItem('departmentId') || '';
    this.pl.project = this.deptValue;
    this.pl.user = sessionStorage.getItem("userId") || "";
    console.log(this.regionId)
    console.log(this.departmentId)
    console.log(this.projectId)
 
 
    console.log(this.pl);
 
    this.result = this.Polling.addPoll(this.pl);
    console.log('Result from Add Poll', this.result);
 
    console.log('Poll Form Value : ' + this.pollForm.value);
    alert('Poll Created Successfully');
  }
 
  createPollPreference(data: any) {
    this.pl.pollQuestion = data.pollQuestion;
    this.pl.options = data.options;
    this.pl.status = true;
    this.pl.endDate = data.endDate;
    // this.pl.region = data.regionId;
    // this.pl.department = data.departmentId;
    // this.pl.project = data.projectId;
    this.pl.region = data.regionId;
    this.pl.department = data.departmentId;
    this.pl.project = data.projectId;
    this.pl.user = sessionStorage.getItem("userId") || "";
 
    console.log(this.pl);
 
    this.result = this.Polling.addPoll(this.pl);
    console.log("Result from Add Poll", this.result);
 
    console.log("Poll Form Value : " + this.pollForm.value);
    alert("Poll Created Successfully");
  }
 
  draft(data: any) {
    this.pl.pollQuestion = data.pollQuestion;
    this.pl.options = data.options;
    this.pl.status = false;
    this.pl.endDate = data.endDate;
    this.pl.region = sessionStorage.getItem('regionId') || '';
    this.pl.department = sessionStorage.getItem('departmentId') || '';
    this.pl.project = this.deptValue;
    this.pl.user = sessionStorage.getItem("userId") || "";
 
    console.log(this.pl);
    this.result = this.Polling.addPoll(this.pl);
    console.log('Result from Add Poll', this.result);
 
    console.log('Poll Form Value : ' + this.pollForm.value);
    alert('Poll Drafted Successfully');
  }
 
  getRegion() {
    this.Polling.getAllRegions().subscribe(
      (regions) => (this.RegionList = regions)
    );
    console.log(this.RegionList);
  }
  getDepartment(data: any) {
    console.log('running');
    this.region.regionId = data.regionId;
 
    console.log(data);
    this.Polling.getAllDepartments(this.region).subscribe(
      (departments) => (this.DeptList = departments)
    );
  }
  getProject(data: any) {
    this.department.departmentId = data.departmentId;
 
    this.Polling.getAllProjects(this.department).subscribe(
      (projects) => (this.ProjectList = projects)
    );
  }
 
 validDate(data: any) {
    console.log(data.endDate)
    this.compareDate = data.endDate;
    this.startDate = this.datePipe.transform(new Date(), 'yyyy-MM-dd ');
    console.log(this.startDate);
    if (this.compareDate < this.startDate) {
      // alert("It is invalid")
      this.msg="Poll End date is invalid";
    } else {
      // alert("The date is Valid")
      // this.msg="The date is Valid";
    }
  }
}
 