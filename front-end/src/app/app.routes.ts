import { Routes } from '@angular/router';
import {PlacesComponent} from "./components/places/places.component";
import {PlaceCategoriesComponent} from "./components/place-categories/place-categories.component";
import {ProductsComponent} from "./components/products/products.component";
import {AuthenticationComponent} from "./components/authentication/authentication.component";
import {RegisterComponent} from "./components/register/register.component";
import {AppComponent} from "./app.component";
import {AddingProductComponent} from "./components/adding-product/adding-product.component";
import {UserComponent} from "./components/user/user.component";
import {OrderComponent} from "./components/order/order.component";

export const routes: Routes = [
  {path: 'places/category/:category', component: PlacesComponent},
  {path: 'product/category/:category', component: ProductsComponent},
  {path: 'product/add', component: AddingProductComponent},
  {path: 'places/city/:city', component: PlacesComponent},
  {path: 'place-categories', component: PlaceCategoriesComponent},
  {path: 'auth/login', component: AuthenticationComponent},
  {path: 'auth/logout', component: AuthenticationComponent},
  {path: 'auth/register', component: RegisterComponent},
  {path: 'profile', component: UserComponent},
  {path: 'orders/changeStatus', component: OrderComponent},
  {path: '', component: AppComponent}
];
