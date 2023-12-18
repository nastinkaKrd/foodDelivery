import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {PlaceDto} from "../common/place-dto";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class PlaceService {
  private baseUrl: string = environment.baseUrl;
  constructor(private httpClient: HttpClient) { }

  public getPlacesByCategory(category: string | null): Observable<PlaceDto[]>{
    const url: string = `${this.baseUrl}/places/category?category=${category}`
    return this.httpClient.get<PlaceDto[]>(url);
  }

  public getPlacesByCity(city: string | null): Observable<PlaceDto[]>{
    const url: string = `${this.baseUrl}/places/city?city=${city}`
    return this.httpClient.get<PlaceDto[]>(url);
  }
}
