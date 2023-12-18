import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {AuthResponseDto} from "../common/auth-response-dto";
import {AuthenticationRequest} from "../common/authentication-request";
import {RegisterRequest} from "../common/register-request";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private baseUrl: string = environment.baseUrl;
  constructor(private httpClient: HttpClient) { }

  public authenticate(username: string, password: string): Observable<AuthResponseDto> {
    const url: string = `${this.baseUrl}/auth/authenticate`;
    const authRequest: AuthenticationRequest = new AuthenticationRequest(username, password);
    return this.httpClient.post<AuthResponseDto>(url, authRequest);
  }

  public register(username: string, password: string, email: string, phoneNumber: string): Observable<AuthResponseDto> {
    const url: string = `${this.baseUrl}/auth/register`;
    const registerRequest: RegisterRequest = new RegisterRequest(username, email, password, phoneNumber);
    return this.httpClient.post<AuthResponseDto>(url, registerRequest);
  }

  public logout(headers: HttpHeaders): void {
    const url: string = `${this.baseUrl}/auth/logout`;
    this.httpClient.post<AuthResponseDto>(url, {headers: headers});
    sessionStorage.removeItem('Token')
  }

  public setAuthHeader(token: string): void {
    let jwt: string = 'Bearer ' + token;
    sessionStorage.setItem('Token', jwt)
  }

  public getUserDetails(headers: HttpHeaders): Observable<any> {
    const url: string = `${this.baseUrl}/auth/get-user-details`;
    return this.httpClient.get(url, {headers: headers, responseType: 'text'})
  }


}
