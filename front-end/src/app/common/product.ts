import {ProductCharacteristic} from "./product-characteristic";
import {ProductCategory} from "./product-category";
import {CompanyDto} from "./company-dto";
import {PlaceDto} from "./place-dto";

export class Product {
  public name : string;
  public productCategory: ProductCategory;
  public productCharacteristic: ProductCharacteristic;
  public companies: CompanyDto[];
  public place: PlaceDto;

  constructor(name: string, productCategory: ProductCategory, productCharacteristic: ProductCharacteristic, companies: CompanyDto[], place: PlaceDto) {
    this.name = name;
    this.productCategory = productCategory;
    this.productCharacteristic = productCharacteristic;
    this.companies = companies;
    this.place = place;
  }
}
