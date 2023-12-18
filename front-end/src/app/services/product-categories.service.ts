import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductCategory} from "../common/product-category";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ProductCategoriesService {
  private baseUrl: string = environment.baseUrl + '/product-categories';
  constructor(private httpClient: HttpClient) { }

  public getProductCategories(): Observable<ProductCategory[]>{
    return this.httpClient.get<ProductCategory[]>(this.baseUrl);
  }
}
