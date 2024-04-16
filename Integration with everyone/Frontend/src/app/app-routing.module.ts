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
import { CreateComponent } from './create/create.component';
import { ViewComponent } from './view/view.component';
import { DraftComponent } from './draft/draft.component';
import { EmployeeComponent } from './employee/employee.component';
import { InviteEmployeeComponent } from './invite-employee/invite-employee.component';
import { ForcepasswordresetComponent } from './forcepasswordreset/forcepasswordreset.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { ForgotPasswordotpComponent } from './forgot-passwordotp/forgot-passwordotp.component';
import { ForgotresetpasswordComponent } from './forgotresetpassword/forgotresetpassword.component';
import { UsernavbarComponent } from './usernavbar/usernavbar.component';
import { AllSurveyComponent } from './all-survey/all-survey.component';
import { CreationPageComponent } from './creation-page/creation-page.component';
import { ResponseSummaryComponent } from './response-summary/response-summary.component';
import { ResponseTemplateComponent } from './response-template/response-template.component';
import { SummaryPageComponent } from './summary-page/summary-page.component';
import { SurveyBuilderComponent } from './survey-builder/survey-builder.component';
import { SurveyDashboardComponent } from './survey-dashboard/survey-dashboard.component';
import { SurveyResponseComponent } from './survey-response/survey-response.component';
import { PostnavComponent } from './postnav/postnav.component';
import { TexteditorComponent } from './texteditor/texteditor.component';
import { PagecontentComponent } from './pagecontent/pagecontent.component';
import { DrafteditComponent } from './draftedit/draftedit.component';
import { PostregionComponent } from './postregion/postregion.component';
import { AuthGuard } from './JwtUtil/auth-guard.service';


const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'Reset', component: ResetComponent,canActivate:[AuthGuard] },
  { path: 'navbar', component: NavbarComponent,canActivate:[AuthGuard] },
  { path: 'usernavbar', component: UsernavbarComponent,canActivate:[AuthGuard] },

  { path: 'Admin', component: AdminPageComponent,canActivate:[AuthGuard] },
  { path: 'RegionHome', component: RegionHomeComponent,canActivate:[AuthGuard] },
  { path: 'Admin/DepartmentHome', component: DepartmentHomeComponent,canActivate:[AuthGuard] },
  { path: 'Admin/ProjectHome', component: ProjectHomeComponent,canActivate:[AuthGuard] },
  { path: 'Admin/EmployeeHome', component: EmployeeHomeComponent,canActivate:[AuthGuard] },
  { path: 'ViewRegion', component: ViewregionComponent,canActivate:[AuthGuard] },
  { path: 'UpdateRegion/:id', component: UpdateRegionComponent,canActivate:[AuthGuard] },
  { path: 'TwoFactor', component: TwoFactorComponent,canActivate:[AuthGuard] },
  { path: 'employeePage', component: EmployeePageComponent,canActivate:[AuthGuard] },
  // {path:'post',component:PostComponent},
  { path: 'poll', component: PollComponent },
  // {path:'survey',component:SurveyComponent},
  { path: 'User', component: UserPageComponent,canActivate:[AuthGuard] },
  { path: 'PasswordReset', component: PasswordresetComponent,canActivate:[AuthGuard] },
  // {path:'projecthome/viewproject',component:ViewprojectComponent},
  { path: 'employeepage', component: EmployeePageComponent,canActivate:[AuthGuard] },
  { path: 'inviteEmployee', component: InviteEmployeeComponent,canActivate:[AuthGuard] },

  { path: 'departmenthome', component: DepartmentHomeComponent,canActivate:[AuthGuard] },
  { path: 'forcepasswordreset', component: ForcepasswordresetComponent },

  // {path:'departmenthome/viewdepartment',component:ViewdepartmentComponent},
  { path: 'projecthome', component: ProjectHomeComponent,canActivate:[AuthGuard] },
  // {path:'viewdepartment',component:ViewdepartmentComponent},
  // {path:'viewproject',component:ViewprojectComponent},


  { path: 'forgotpassword', component: ForgotpasswordComponent },

  { path: 'forgotpasswordotp', component: ForgotPasswordotpComponent },
  { path: 'forgotresetpassword', component: ForgotresetpasswordComponent },

  { path: 'create', component: CreateComponent,canActivate:[AuthGuard] },
  { path: 'view', component: ViewComponent,canActivate:[AuthGuard] },
  { path: 'viewEmployee', component: EmployeeComponent,canActivate:[AuthGuard] },
  { path: 'draft', component: DraftComponent,canActivate:[AuthGuard] },
  { path: 'survey', component: SurveyDashboardComponent,canActivate:[AuthGuard] },
  { path: 'survey/create', component: CreationPageComponent,canActivate:[AuthGuard] },
  { path: 'survey/builder', component: SurveyBuilderComponent,canActivate:[AuthGuard] },
  { path: 'survey/response', component: ResponseTemplateComponent,canActivate:[AuthGuard] },
  { path: 'survey/summary', component: SummaryPageComponent,canActivate:[AuthGuard] },
  { path: 'survey/response', component: ResponseTemplateComponent,canActivate:[AuthGuard] },
  { path: 'survey/userResponse/:id', component: SurveyResponseComponent,canActivate:[AuthGuard] },
  { path: 'survey/userResponse', component: SurveyResponseComponent,canActivate:[AuthGuard] },
  { path: 'survey/responseDetail', component: ResponseSummaryComponent,canActivate:[AuthGuard] },
  { path: 'survey/responseDetail/:id', component: ResponseSummaryComponent,canActivate:[AuthGuard] },
  { path: 'survey/allsurvey', component: AllSurveyComponent },

  { path: 'postnav', component: PostnavComponent,canActivate:[AuthGuard] },
  { path: 'text', component: TexteditorComponent,canActivate:[AuthGuard] },
  { path: 'page', component: PagecontentComponent,canActivate:[AuthGuard] },
  { path: 'draft', component: DraftComponent,canActivate:[AuthGuard] },
  { path: 'editdraft', component: DrafteditComponent,canActivate:[AuthGuard] },
  { path: 'postregion', component: PostregionComponent,canActivate:[AuthGuard] },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
