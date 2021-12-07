import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductComponent } from './product/product.component';
import { LoginComponent } from './login/login.component';
import { ProductpageComponent } from './productpage/productpage.component';
import { HomeComponent } from './home/home.component';
import { SizeComponent } from './size/size.component';
import { CustomerComponent } from './customer/customer.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
const routes: Routes = [
  
  {path:"login",component:CustomerComponent},
  {path:"product",component:ProductComponent},

  {path:"customer",component:CustomerComponent},
  {path:"home",component:HomeComponent},
  {path:"",component:CustomerComponent},
{path:"create",component:CreateCustomerComponent},
  {path:"productpage",component:ProductpageComponent},
  {path:"size",component:SizeComponent},
  {path:"update",component:UpdateCustomerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
