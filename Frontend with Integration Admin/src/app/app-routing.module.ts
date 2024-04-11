import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { LoginComponent } from './login/login.component';
import { RegionHomeComponent } from './region-home/region-home.component';
import { DepartmentHomeComponent } from './department-home/department-home.component';
import { ProjectHomeComponent } from './project-home/project-home.component';
import { EmployeeHomeComponent } from './employee-home/employee-home.component';
import { ViewregionComponent } from './viewregion/viewregion.component';
import { UpdateRegionComponent } from './update-region/update-region.component';
import { TwoFactorComponent } from './two-factor/two-factor.component';
import { EmployeePageComponent } from './employee-page/employee-page.component';
import { PostComponent } from './post/post.component';
import { UserPageComponent } from './user-page/user-page.component';
import { PollComponent } from './poll/poll.component';
import { SurveyComponent } from './survey/survey.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ResetComponent } from './reset/reset.component';
import { PasswordresetComponent } from './passwordreset/passwordreset.component';
import { InviteEmployeeComponent } from './invite-employee/invite-employee.component';
import { ForcepasswordresetComponent } from './forcepasswordreset/forcepasswordreset.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { ForgotPasswordotpComponent } from './forgot-passwordotp/forgot-passwordotp.component';
import { ForgotresetpasswordComponent } from './forgotresetpassword/forgotresetpassword.component';
import { UsernavbarComponent } from './usernavbar/usernavbar.component';
import { SurveyDashboardComponent } from './survey-dashboard/survey-dashboard.component';
import { CreationPageComponent } from './creation-page/creation-page.component';
import { SurveyBuilderComponent } from './survey-builder/survey-builder.component';
import { ResponseTemplateComponent } from './response-template/response-template.component';
import { SummaryPageComponent } from './summary-page/summary-page.component';
import { SurveyResponseComponent } from './survey-response/survey-response.component';
import { ResponseSummaryComponent } from './response-summary/response-summary.component';
import { AllSurveyComponent } from './all-survey/all-survey.component';


const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'Reset',component:ResetComponent},
  {path:'navbar',component:NavbarComponent},
  {path:'usernavbar',component:UsernavbarComponent},

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
  {path:'surveycom',component:SurveyComponent},
  {path:'User',component:UserPageComponent},
  {path:'PasswordReset',component:PasswordresetComponent},
  // {path:'projecthome/viewproject',component:ViewprojectComponent},
  {path:'employeepage',component:EmployeePageComponent},
  {path:'inviteEmployee',component:InviteEmployeeComponent},
  
  {path:'departmenthome',component:DepartmentHomeComponent},
  {path :'forcepasswordreset',component:ForcepasswordresetComponent},

  // {path:'departmenthome/viewdepartment',component:ViewdepartmentComponent},
  {path:'projecthome',component:ProjectHomeComponent},
  // {path:'viewdepartment',component:ViewdepartmentComponent},
  // {path:'viewproject',component:ViewprojectComponent},


  {path:'forgotpassword',component:ForgotpasswordComponent},
 
  {path:'forgotpasswordotp',component:ForgotPasswordotpComponent},
  {path:'forgotresetpassword',component:ForgotresetpasswordComponent},
  { path: 'survey', component: SurveyDashboardComponent },
  { path: 'survey/create', component: CreationPageComponent },
  { path: 'survey/builder', component: SurveyBuilderComponent },
  { path: 'survey/response', component: ResponseTemplateComponent },
  { path: 'survey/summary', component: SummaryPageComponent },
  { path: 'survey/response', component: ResponseTemplateComponent },
  { path: 'survey/userResponse/:id', component: SurveyResponseComponent },
  { path: 'survey/userResponse', component: SurveyResponseComponent },
  { path: 'survey/responseDetail', component: ResponseSummaryComponent },
  { path: 'survey/responseDetail/:id', component: ResponseSummaryComponent },
  { path: 'survey/allsurvey', component: AllSurveyComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
