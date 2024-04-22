import { Component, OnInit, ViewChild } from '@angular/core';
import { Content } from '../Post-Model/content';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Department } from '../Post-Model/Department';
import { Project } from '../Post-Model/Project';
import { Region } from '../Post-Model/Region';
import { User } from '../Post-Model/User';

import { Router } from '@angular/router';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { ContentService } from '../Post_Services/content.service';
import { ContentValue } from '../Post-Model/contentValue';

@Component({
  selector: 'app-draftedit',
  templateUrl: './draftedit.component.html',
  styleUrls: ['./draftedit.component.css']
})
export class DrafteditComponent implements OnInit {
  title = 'Prime';
  ckeConfig: any;
  mycontent: string | undefined;
  log: string | undefined
  @ViewChild('PageContent') PageContent: any;

  res: any;
  content: Content;
  contentForm: FormGroup;
  department: Department;
  project: Project;
  region: Region;
  contentvalue:ContentValue;
  // user:User;
  result: string = "";
  contentList:Content[] = [];
  RegionList: Region[] = [];
  DeptList: Department[] = [];
  ProjectList: Project[] = [];
  UserList: User[] = [];
  Allreg!: number;
  Alldept!: number;
  Allproj!: number;
  date: Date;
  editId:any;

  id!:any;

 constructor(private contentservice: ContentService, private router: Router,private dialog: MatDialog) {

    this.date = new Date();
    this.region = new Region;

    this.department = new Department;

    this.project = new Project;

    this.content = new Content;
    this.contentvalue = new ContentValue;

    // this.user=new User;
    this.Allreg = 1;

    this.Alldept = 1;

    this.Allproj = 1;
    this.content = new Content;
    this.contentForm = new FormGroup({
      //  title: new FormControl('', [Validators.required]),
      postContent: new FormControl('', [Validators.required]),
      // dateTime: new FormControl('', [Validators.required]),
      // region: new FormControl('', [Validators.required, Validators.pattern('')]),

      regionId: new FormControl('', [Validators.required, Validators.pattern('')]),

      // department: new FormControl('', [Validators.required]),

      departmentId: new FormControl('', [Validators.required]),

      // project: new FormControl('', [Validators.required]),

      projectId: new FormControl('', [Validators.required]),

      // userId:new FormControl('', [Validators.required])

    }); 
    this.getRegion();
    this.editId=sessionStorage.getItem("editId") ||"";
    console.log(this.editId);
    this.getDraftContent();

  }


  ngOnInit() {
    this.Getpost();
    // this.getDraftContent();
    this.ckeConfig = {
      allowedContent: false,
      extraPlugins: 'divarea',
      forcePasteAsPlainText: true,
      
    };
  }




  updateDraft(data:any){
     
  }


  insertPost(data: any) {
    this.contentvalue.postContent = data.postContent;
    this.contentvalue.region = data.regionId;
    this.contentvalue.department = data.departmentId;
    this.contentvalue.project = data.projectId;
    this.contentvalue.user=sessionStorage.getItem("userId")||"";
    this.contentvalue.status=true;
    
    this.contentservice.AddUpdateContent(this.contentvalue).subscribe((data: any) => {
      alert("Data saved Successfully");
      this.router.navigate(['/pageContent']);
    },
      error => {
        console.error("Error Saving Draft: ", error);
      }
    );
  }
  insertDraft(data: any) {
    this.contentvalue.postContent = data.postContent;
    this.contentvalue.region = data.regionId;
    this.contentvalue.department = data.departmentId;
    this.contentvalue.project = data.projectId;
    this.contentvalue.user=sessionStorage.getItem("userId")||"";
    this.contentvalue.status = false;
    // this.content.user=data.userId;
    alert("Draft saved Successfully");
    this.contentservice.AddDraft(this.contentvalue).subscribe((data: any) => {
      alert("Data saved Successfully");
      this.router.navigate(['/pageContent']);
    },
      error => {
        console.error("Error Saving Draft: ", error);
      }
    );
  }
  Getpost() {
    this.contentservice.getAllPosts().subscribe((data: any) => {
    this.res = data;
      console.log(this.res);
    })
  }
  getRegion() {
    this.contentservice.getAllRegions().subscribe(regions => this.RegionList = regions);
  }
  getDepartment(data: any) {

    this.region.regionId = data.regionId;

    this.contentservice.getAllDepartments(this.region).subscribe(departments => this.DeptList = departments);

    // alert(this.region.regionId) 

    // if (this.region.regionId != this.Allreg) { 



    // } 
  }
  getProject(data: any) {

    this.department.departmentId = data.departmentId;

    this.contentservice.getAllProjects(this.department).subscribe(projects => this.ProjectList = projects);
    // alert(this.department.departmentId); 
    // if (this.department.departmentId != this.Alldept) { 
    // } 
  }

  // getUser() { 
  //   this.contentservice.getAllUsers().subscribe(User => this.UserList = User); 
  // } 







// new code By jeyavel 
// getDraftContent() {
//   const draftId = localStorage.getItem("id");
//   const draftIdAsNumber = Number(draftId);
//   if (!isNaN(draftIdAsNumber)) {
//     this.contentservice.updateDraft({
//       postId: draftIdAsNumber,
//       dateTime: '',
//       postContent: '',
//       region: new Region,
//       department: 0n,
//       project: 0n,
//       nativeElement: undefined,
//       status: false
//     })
//       .subscribe(draft => {
//         if (draft) {
//           this.contentForm.controls['postContent'].setValue(draft.postContent);
//         }
//       });
//   } else {
//     // Handle invalid draftId case (e.g., alert user)
//   }
// }

// getDraftContent() {
//   const draftId = localStorage.getItem("id");

//   // Convert to number directly (assuming postId is stored as a string in localStorage)
//   const draftIdAsNumber = Number(draftId);

  // if (!isNaN(draftIdAsNumber)) {
  //   this.contentservice.updateDraft({
  //     postId: draftIdAsNumber,
  //     dateTime: '',
  //     postContent: '',
  //     region: new Region,
  //     department: 0n,
  //     project: 0n,
  //     user: new User,
  //     nativeElement: undefined,
  //     status: false,
  //     // pageContentTitle: undefined,
    
  //   })

  //     .subscribe(draft => {
  //       if (draft) {
  //         this.contentForm.controls['postContent'].setValue(draft.postContent);
  //         console.log(this.contentForm);
  //       }
  //     });
  // } else {
  //   // Handle invalid draftId case (e.g., alert user)
  // }
// }


getDraftContent(){
  this.contentservice.updateDraft({
    postId: this.editId,
    dateTime: '',
    postContent: '',
    region: new Region,
    department: 0n,
    project: 0n,
    user: new User,
    nativeElement: undefined,
    status: false,
    // pageContentTitle: undefined,
  
  })

    .subscribe(draft => {
      if (draft) {
        this.contentForm.controls['postContent'].setValue(draft.postContent);
        console.log(this.contentForm);
      }
    });
}
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



}


