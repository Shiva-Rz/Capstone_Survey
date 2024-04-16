import { Component } from '@angular/core';
import { ActivatedRoute, Routes ,Params} from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Region } from '../model/Region';
import { RegionService } from '../Admin-Service/region.service';
 
@Component({
  selector: 'app-update-region',
  templateUrl: './update-region.component.html',
  styleUrls: ['./update-region.component.css']
})
export class UpdateRegionComponent {
  // public RegionId!:number;
 
  // myForm: FormGroup;
  // region:Region;
  // regList:Region[]=[];
 
  // result:string="";
 
 
  // constructor(private activatedroute:ActivatedRoute,private service:RegionService)
 
  // {
   
  // this.myForm = new FormGroup(
  //   {
     
  //     regionId: new FormControl('', [Validators.required, Validators.pattern('[0-9]+')]),
  //     regionName: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z][a-zA-Z]+')]),
     
  //     regionLocation: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z][a-zA-Z]+')]),
  //     regionTimezone:new FormControl('',[Validators .required,Validators.pattern('[a-zA-Z0-9]+')]),
 
  //   }
  // );
  // this.region=new Region();
  // this.ngOnInit();
 
  // }
 
  // ngOnInit():void{
   
  //   this.activatedroute.paramMap.subscribe((param:Params)=>{
  //     this.RegionId=param['get']("id");
  //     this.fetchDetails(this.RegionId);
  //   })
  // }
 
 
  // update(data: any) {
 
  //   this.region.regionId = data.regionId;
  //   this.region.regionName = data.regionName;
  //   this.region.regionLocation = data.regionLocation;
  //   this.region.regionTimezone = data.regionTimezone;
   
   
  //    this.result=this.service.update(this.region);
   
  // }
 
  // fetchDetail( RegionId:number) {
  //   this.region.regionId = RegionId;
  //    this.service.delete(this.region);
   
  // }
 
  // fetchDetails(RegionId:number){
  //   this.region.regionId = RegionId;
   
  //   this.service.getDetails(this.region).subscribe(regions => this.regList = regions);
  //  }
 
  //  getAll() {
  //   this.service.getAlldetails().subscribe(regions => this.regList = regions)
  // }
 
 
 
 
}
 