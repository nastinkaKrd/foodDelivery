import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../common/product";
import {ProductDataDto} from "../common/product-data-dto";
import {ProductCharacteristic} from "../common/product-characteristic";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
    private baseUrl: string = environment.baseUrl;
    constructor(private httpClient: HttpClient) { }

    public getProductsByCategory(category: string | null): Observable<Product[]>{
        const url: string = `${this.baseUrl}/products?category=${category}`;
        return this.httpClient.get<Product[]>(url);
    }

  public addProduct(name: string, category: string, place: string, company: string, price: number, weight: number,
                    availableAmount: number, weightMeasurement: string, headers: HttpHeaders): void{
    const url: string = `${this.baseUrl}/products`;
    const productData: ProductDataDto = new ProductDataDto(name, category,
      new ProductCharacteristic(price, weight, availableAmount, weightMeasurement), place, company);
    console.log(productData);
    this.httpClient.post(url, productData, {headers: headers});
  }
 }
