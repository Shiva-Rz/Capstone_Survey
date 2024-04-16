import { Component } from '@angular/core';

@Component({
  selector: 'app-poll',
  templateUrl: './poll.component.html',
  styleUrls: ['./poll.component.css']
})
export class PollComponent {

  constructor () {
   
  }
 
  create: boolean = false;
  view:boolean = false;
  draft:boolean = false;
  employee: boolean = false;
 
  callCreate() {
    this.create = true;
    this.draft = false;
    this.view = false;
    this.employee = false;
  }
  callView() {
    this.create = false;
    this.draft = false;
    this.view = true;
    this.employee = false;
  }
  callDraft() {
    this.create = false;
    this.draft = true;
    this.view = false;
    this.employee = false;
  }
  callEmployee() {
    this.create = false;
    this.draft = false;
    this.view = false;
    this.employee = true;
  }
}
 


