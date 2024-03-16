import { Component } from '@angular/core';

@Component({
  selector: 'app-survey-summary',
  templateUrl: './survey-summary.component.html',
  styleUrls: ['./survey-summary.component.css']
})
export class SurveySummaryComponent {

  flag: boolean = false;

  changediv() {
    this.flag = !this.flag;
  }
}
