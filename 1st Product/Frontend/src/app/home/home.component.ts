import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  Hide= true;

  Show = true;

  Draft = true;

  Employee = true;

  toggleDisplayView()
  {
    this.Hide = !this.Hide;
  }

  toggleDisplayDraft()
  {
    this.Show = !this.Show;
    this.Draft = !this.Draft;
  }

  toggleDisplayEmployee()
  {
    this.Draft = !this.Draft;
    this.Employee = !this.Employee;
  }
}
