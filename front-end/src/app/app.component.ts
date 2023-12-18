import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterLinkActive, RouterOutlet} from '@angular/router';
import {ProductsComponent} from "./components/products/products.component";
import {PlacesComponent} from "./components/places/places.component";
import {HttpClientModule} from "@angular/common/http";
import {PlaceCategoriesComponent} from "./components/place-categories/place-categories.component";
import {ProductCategoriesComponent} from "./components/product-categories/product-categories.component";
import {AuthenticationService} from "./services/authentication.service";
import {HeaderService} from "./services/header.service";
import {FormsModule} from "@angular/forms";
import {AuthenticationComponent} from "./components/authentication/authentication.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [AuthenticationComponent,
    CommonModule,
    FormsModule,
    RouterOutlet,
    ProductsComponent,
    PlacesComponent,
    HttpClientModule,
    PlaceCategoriesComponent,
    ProductCategoriesComponent,
    RouterLinkActive],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  providers: [AuthenticationService, HeaderService]
})
export class AppComponent implements OnInit{
  public isAuthenticated: boolean = false;
  constructor(private authenticationService: AuthenticationService,
              private headerService: HeaderService) {
  }

  ngOnInit() {
    this.getUsername();
  }

  getUsername(): void {
    this.authenticationService.getUserDetails(this.headerService.getAuthHeader()).subscribe(
        (data: string): void => {
          if (data !== null){
            this.isAuthenticated = true;
          }
        }
    );
  }

  public logout(): void{
    this.authenticationService.logout(this.headerService.getAuthHeader());
  }

    protected readonly AuthenticationComponent = AuthenticationComponent;
}
