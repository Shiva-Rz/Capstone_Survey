import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminPageComponent } from '../admin-page/admin-page.component';
import { DepartmentHomeComponent } from '../department-home/department-home.component';
import { DraftComponent } from '../draft/draft.component';
import { EmployeeHomeComponent } from '../employee-home/employee-home.component';
import { EmployeePageComponent } from '../employee-page/employee-page.component';
import { EmployeeComponent } from '../employee/employee.component';
import { LoginComponent } from '../login/login.component';
import { NavbarComponent } from '../navbar/navbar.component';
import { PasswordresetComponent } from '../passwordreset/passwordreset.component';
import { PollComponent } from '../poll/poll.component';
import { PostComponent } from '../post/post.component';
import { ProjectHomeComponent } from '../project-home/project-home.component';
import { RegionHomeComponent } from '../region-home/region-home.component';
import { ResetComponent } from '../reset/reset.component';
import { SurveyComponent } from '../survey/survey.component';
import { TwoFactorComponent } from '../two-factor/two-factor.component';
import { UpdateRegionComponent } from '../update-region/update-region.component';
import { UserPageComponent } from '../user-page/user-page.component';
import { ViewComponent } from '../view/view.component';
import { ViewregionComponent } from '../viewregion/viewregion.component';
import { HomeComponent } from './home.component';

const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'Reset',component:ResetComponent},
  {path:'navbar',component:NavbarComponent},
  {path:'Admin',component:AdminPageComponent},
  {path:'RegionHome',component:RegionHomeComponent},
  {path:'Admin/DepartmentHome',component:DepartmentHomeComponent},
  {path:'Admin/ProjectHome',component:ProjectHomeComponent},
  {path:'Admin/EmployeeHome',component:EmployeeHomeComponent},
  {path:'ViewRegion',component:ViewregionComponent},
  {path:'UpdateRegion/:id',component:UpdateRegionComponent},
  {path:'TwoFactor',component:TwoFactorComponent},
  {path:'employeePage',component:EmployeePageComponent},
  {path:'post',component:PostComponent},
  {path:'poll',component:PollComponent},
  {path:'survey',component:SurveyComponent},
  {path:'User',component:UserPageComponent},
  {path:'PasswordReset',component:PasswordresetComponent},
  // {path:'projecthome/viewproject',component:ViewprojectComponent},
  {path:'employeepage',component:EmployeePageComponent},
  
  {path:'departmenthome',component:DepartmentHomeComponent},
  
  // {path:'departmenthome/viewdepartment',component:ViewdepartmentComponent},
  {path:'projecthome',component:ProjectHomeComponent},
  // {path:'viewdepartment',component:ViewdepartmentComponent},
  // {path:'viewproject',component:ViewprojectComponent},

  // { path: 'create', component: CreateComponent },
  { path: 'view', component: ViewComponent },
  {path:'viewEmployee',component:EmployeeComponent},
  {path:'draft', component:DraftComponent},
  {path:'home', component:HomeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
