import {ProductCategory} from "./product-category";
import {ProductCharacteristic} from "./product-characteristic";
import {CompanyDto} from "./company-dto";
import {Place} from "./place";

export class ProductMemoryValueData {
    public name: string;
    public productCategory: ProductCategory;
    public productCharacteristic: ProductCharacteristic;
    public companies: CompanyDto[];
    public place: Place;
    public amount: number;

    constructor(name: string, productCategory: ProductCategory, productCharacteristic: ProductCharacteristic, companies: CompanyDto[], place: Place, amount: number) {
        this.name = name;
        this.productCategory = productCategory;
        this.productCharacteristic = productCharacteristic;
        this.companies = companies;
        this.place = place;
        this.amount = amount;
    }
}
