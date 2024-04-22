import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Region } from '../model/Region';
import { RegionService } from '../Admin-Service/region.service';

@Component({
  selector: 'app-region-home',
  templateUrl: './region-home.component.html',
  styleUrls: ['./region-home.component.css']
})
export class RegionHomeComponent {
  myForm: FormGroup;
  region:Region;
  result:string="";
  regList:Region[]=[];
  constructor( private service:RegionService,private router:Router){
    this.myForm = new FormGroup(
      {
        
        regionName: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z][a-zA-Z]+')]),
       
        regionLocation: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z][a-zA-Z]+')]),
        regionTimezone:new FormControl('',[Validators .required,Validators.pattern('[a-zA-Z0-9]+')]),
  
  
  
  
      }
    );
    this.region=new Region;

  }

  insert(data: any) {
    // alert(data.regionName+ data.regionTimezone+data.regionLocation);
   
    this.region.regionName = data.regionName;
    this.region.regionLocation = data.regionLocation;
    this.region.regionTimezone = data.regionTimezone;
    

    this.result = this.service.insert(this.region);
    this.getAll();

    setTimeout(function(){ window. location. reload(); }, 1000);
  }

  update(data: any) {

    this.region.regionId = data.regionId;
    this.region.regionName = data.regionName;
    this.region.regionLocation = data.regionLocation;
    this.region.regionTimezone = data.regionTimezone;
    
   
    this.result = this.service.update(this.region);
    this.getAll();

    setTimeout(function(){ window. location. reload(); }, 1000);
  }

  delete(data: any) {
    this.region.regionId = data.regionId;
    this.result = this.service.delete(this.region);
    this.getAll();
    setTimeout(function(){ window. location. reload(); }, 1000);
  }

  getAll() {
    this.service.getAlldetails().subscribe(regions => this.regList = regions)
  }

  goToDashBoard()
  {
    this.router.navigate(['/Admin']);
  }

}
