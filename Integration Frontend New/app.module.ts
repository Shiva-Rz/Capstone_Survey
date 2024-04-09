import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatButtonModule } from '@angular/material/button';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { LoginComponent } from './login/login.component';
import { RegionHomeComponent } from './region-home/region-home.component';

import { EmployeeHomeComponent } from './employee-home/employee-home.component';
import { ViewregionComponent } from './viewregion/viewregion.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateRegionComponent } from './update-region/update-region.component';
import { TwoFactorComponent } from './two-factor/two-factor.component';
import { EmployeePageComponent } from './employee-page/employee-page.component';
import { PostComponent } from './post/post.component';
import { UserPageComponent } from './user-page/user-page.component';
import { PollComponent } from './poll/poll.component';
import { SurveyComponent } from './survey/survey.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ResetComponent } from './reset/reset.component';
import { PasswordResetComponent } from './password-reset/password-reset.component';
import { PasswordresetComponent } from './passwordreset/passwordreset.component';
import { DepartmentHomeComponent } from './department-home/department-home.component';
import { ProjectHomeComponent } from './project-home/project-home.component';
import { CommentComponent } from './comments/components/comment/comment.component';
import { CommonModule, DatePipe } from '@angular/common';
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
import { CommentsModule } from './comments/comments.module';




@NgModule({
  declarations: [
    AppComponent,
    AdminPageComponent,
    LoginComponent,
    RegionHomeComponent,
    DepartmentHomeComponent,
    ProjectHomeComponent,
    EmployeeHomeComponent,
    ViewregionComponent,
    UpdateRegionComponent,
    TwoFactorComponent,
    EmployeePageComponent,
    PostComponent,
    UserPageComponent,
    PollComponent,
    SurveyComponent,
    NavbarComponent,
    ResetComponent,
    PasswordResetComponent,
    PasswordresetComponent,
    InviteEmployeeComponent,
    ForcepasswordresetComponent,
    ForgotpasswordComponent,
    ForgotPasswordotpComponent,
    ForgotresetpasswordComponent,
    UsernavbarComponent,
    SurveyDashboardComponent,
    CreationPageComponent,
    SurveyBuilderComponent,
    ResponseTemplateComponent,
    SummaryPageComponent,
    SurveyResponseComponent,
    ResponseSummaryComponent,
    AllSurveyComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule, FormsModule, ReactiveFormsModule, BrowserAnimationsModule, MatButtonModule, MatTooltipModule, HttpClientModule,
    CommonModule, CommentsModule
  ],
  providers: [provideClientHydration(),
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
