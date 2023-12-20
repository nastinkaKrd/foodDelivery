import {Component} from '@angular/core';
import {AuthenticationService} from "../../services/authentication.service";
import {FormsModule} from "@angular/forms";
import {RegisterRequest} from "../../common/register-request";

@Component({
  selector: 'app-register',
  standalone: true,
    imports: [
        FormsModule
    ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  registerData: RegisterRequest ={
    "username": "",
    "email": "",
    "phoneNumber": "",
    "password": ""
  }
  constructor(private authenticationService: AuthenticationService) { }

  public register(): void{
    this.authenticationService.register(this.registerData.username, this.registerData.password,
        this.registerData.email, this.registerData.phoneNumber).subscribe(data=>{
        this.setAuthHeader(data.jwt)
    });
  }


  public setAuthHeader(token: string){
    this.authenticationService.setAuthHeader(token);
  }
}
