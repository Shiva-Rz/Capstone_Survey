import { Component } from '@angular/core';
import { ContentService } from '../Post_Services/content.service';


@Component({
  selector: 'app-postnav',
  templateUrl: './postnav.component.html',
  styleUrls: ['./postnav.component.css']
})
export class PostnavComponent {
  
  draftCount:number=0;
  constructor(private contentservice: ContentService){
 
  }
  ngOnInit() {
   
    this.contentservice.getAllDrafts() // Include drafts
    .subscribe(posts => {
      this.draftCount = posts.filter(post => post).length;
    });
  }
  Hide= true;
 
  toggleDisplayPost()
  {
    this.Hide = !this.Hide;
  }
}
