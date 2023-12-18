import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PlaceCategoryDto} from "../common/place-category-dto";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class PlaceCategoriesService {
  private baseUrl: string = environment.baseUrl + '/place-categories';
  constructor(private httpClient: HttpClient) { }

  public getPlaceCategories(): Observable<PlaceCategoryDto[]>{
    return this.httpClient.get<PlaceCategoryDto[]>(this.baseUrl);
  }
}
