import {Injectable} from '@angular/core';
import {AuthenticationService} from "./authentication.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, switchMap} from "rxjs";
import {UserInformationDto} from "../common/user-information-dto";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl: string = environment.baseUrl;
  private username: string = "";
  constructor(private authService: AuthenticationService,
              private httpClient: HttpClient) { }

  public getUser(headers:HttpHeaders): Observable<UserInformationDto> {
    return this.authService.getUserDetails(headers).pipe(
        switchMap((data: string): Observable<UserInformationDto> => {
          this.username = data;
          const url: string = `${this.baseUrl}/users/${this.username}`;
          console.log(headers);
          return this.httpClient.get<UserInformationDto>(url, {headers: headers, responseType: 'json'});
        })
    );
  }
}
