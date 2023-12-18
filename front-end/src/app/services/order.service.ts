import {Injectable} from '@angular/core';
import {HeaderService} from "./header.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private baseUrl: string = environment.baseUrl;
  constructor(private headerService: HeaderService,
              private httpClient: HttpClient) { }

    changeStatus(id: string, status: string): Observable<string> {
      const headers: HttpHeaders = this.headerService.getAuthHeader();
      const url: string = `${this.baseUrl}/orders/${id}?status=${status}`;
      return this.httpClient.put<string>(url, {headers: headers});
    }
}
