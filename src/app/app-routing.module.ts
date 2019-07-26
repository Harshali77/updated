import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserLoginComponent} from './user-login/user-login.component'
import {UserRegisterComponent} from './user-register/user-register.component'
import { CustomerDashboardComponent } from './customer-dashboard/customer-dashboard.component';
import { EmployeeDashboardComponent } from './employee-dashboard/employee-dashboard.component';
import {AddPartsComponent} from './add-parts/add-parts.component'
import {VehicleComponent} from './vehicle/vehicle.component'
import {AdminDashboardComponent} from './admin-dashboard/admin-dashboard.component'
import {ShowPartsComponent} from './show-parts/show-parts.component';
//import {ShowUsersComponent} from './show-users/show-users.component';

const routes: Routes = [
  { path: 'user-login', component: UserLoginComponent },
  {path: 'user-register', component: UserRegisterComponent},
  {path:'customer-dashboard',component:CustomerDashboardComponent},
 { path:'add-parts',component:AddPartsComponent},
   {path:'employee-dashboard',component:EmployeeDashboardComponent},
   {path:'vehicle',component:VehicleComponent},
   {path:'admin-dashboard',component:AdminDashboardComponent},
    { path:'show-parts',component:ShowPartsComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }





