import {Component} from '@angular/core';
import {AuthenticationService} from "../../services/authentication.service";
import {FormsModule} from "@angular/forms";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-authentication',
  standalone: true,
    imports: [
        FormsModule,
        RouterLink
    ],
  templateUrl: './authentication.component.html',
  styleUrl: './authentication.component.css',
  providers: [AuthenticationService]
})
export class AuthenticationComponent {
  login:  any ={
    "username": "",
    "password": ""
}
  constructor(private authenticationService: AuthenticationService) { }

  public authenticate(): void{
    this.authenticationService.authenticate(this.login.username, this.login.password)
        .subscribe(data=>{
          this.setAuthHeader(data.jwt);
          window.location.reload();
        });
  }

  public setAuthHeader(token: string){
    this.authenticationService.setAuthHeader(token);
  }

}
