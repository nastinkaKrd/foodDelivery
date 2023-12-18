import { Injectable } from '@angular/core';
import {HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class HeaderService {

  constructor() { }

  public getAuthHeader(): HttpHeaders {
    const storedToken: string | null = sessionStorage.getItem('Token');
    return storedToken ? new HttpHeaders({
      'Access-Control-Allow-Methods': '*',
      'Access-Control-Allow-Origin': '*',
      'Authorization': storedToken}) : new HttpHeaders();
  }
}
