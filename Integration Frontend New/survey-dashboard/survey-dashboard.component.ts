import { style } from '@angular/animations';
import { Component } from '@angular/core';

@Component({
  selector: 'app-survey-dashboard',
  templateUrl: './survey-dashboard.component.html',
  styleUrls: ['./survey-dashboard.component.css']
})
export class SurveyDashboardComponent {

  flag: boolean= true;
  // flag1: boolean =true;

  activeButton: string = 'survey';

  setActive(mybtn: string): void {
    this.activeButton = mybtn;
  }

  isActive(mybtn: string): boolean {
    return this.activeButton === mybtn;
  }

  route() {
    
    this.flag = !this.flag;
    // this.flag1 = ! this.flag1;
  
  }
}
