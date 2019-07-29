import { Component, OnInit } from '@angular/core';
import { VehicleApplicationService } from '../vehicleapplication/vehicle-application.service';
import { Router } from '@angular/router';
import { FormGroup, Validators,FormControl } from '@angular/forms';
@Component({
  selector: 'app-generate-bill',
  templateUrl: './generate-bill.component.html',
  styleUrls: ['./generate-bill.component.css']
})
export class GenerateBillComponent implements OnInit {
cName:string;
serviceCharge: string;
Oiling:string;
spareParts:string;
result:number;
add(){
  this.result=parseInt(this.serviceCharge)+parseInt(this.Oiling)+parseInt(this.spareParts);
}
    constructor() { }

  ngOnInit() {
  }


  

/*newApplication: bill;
  billForm: FormGroup
   constructor(private vehicleApplicationService: VehicleApplicationService,private router: Router) {

this.billForm=new FormGroup(
      {
          cName:new FormControl(),
          serviceCharge: new FormControl(),
          oil:new FormControl(),
          spareCharge:new FormControl(),

    }
);
   }

  ngOnInit() {


  }


 /*generateBill() {

    this.newApplication = this.billForm.value;
    
    this.vehicleApplicationService.addPart(this.newApplication);
      alert("Part added successfully");
    this.router.navigate(['/admin-dashboard']);
  }
*/
}