import { Component } from '@angular/core';
import { RegionService } from '../Admin-Service/region.service';
import { Region } from '../model/Region';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-viewregion',
  templateUrl: './viewregion.component.html',
  styleUrls: ['./viewregion.component.css']
})
export class ViewregionComponent {
  public RegionId!:number;
  myForm: FormGroup;
  myForm1: FormGroup;
  region:Region;
  regList:Region[]=[];
  regList2:Region[]=[];
  result:string="";
  constructor( private service:RegionService){
    //insertform
    this.myForm = new FormGroup(
      {
        regionId: new FormControl(''),
        regionName: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z][a-zA-Z]+')]),
        regionLocation: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z][a-zA-Z]+')]),
        regionTimezone:new FormControl('',[Validators.required])
      }
    );

    //updateform


    this.myForm1 = new FormGroup(
      {
        regionId: new FormControl('', [Validators.required, Validators.pattern('[0-9]+')]),
        regionName: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z][a-zA-Z]+')]),
        regionLocation: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z][a-zA-Z]+')]),
        regionTimezone:new FormControl('',[Validators.required])
      }
    );
    this.region=new Region;
    this.getAll();
  }
  insert(data: any) {

    this.region.regionName = data.regionName;
    this.region.regionLocation = data.regionLocation;
    this.region.regionTimezone = data.regionTimezone;
    this.result = this.service.insert(this.region);
    setTimeout(function(){ window. location. reload(); }, 1000);
    // location.reload();
  }

  update(data: any) {

    this.region.regionId = data.regionId;
    this.region.regionName = data.regionName;
    this.region.regionLocation = data.regionLocation;
    this.region.regionTimezone = data.regionTimezone;
    this.result = this.service.update(this.region);
    setTimeout(function(){ window. location. reload(); }, 1000);

  }

  fetchDetails(RegionId:number){
    this.region.regionId = RegionId;
    this.service.getDetails(this.region).subscribe(regions => this.regList2 = regions);
   }

  getAll() {
    this.service.getAlldetails().subscribe(regions => this.regList = regions)
  }

  delete(data:any) {
    
    this.region.regionId = data.regionId;
    this.result = this.service.delete(this.region);
    setTimeout(function(){ window. location. reload(); }, 1000);
  }

}
