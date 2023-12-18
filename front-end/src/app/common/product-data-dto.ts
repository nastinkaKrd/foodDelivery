import {ProductCharacteristic} from "./product-characteristic";

export class ProductDataDto {
    public name: string;

    public category: string;

    public productCharacteristic: ProductCharacteristic;

    public place: string;

    public company: string;

    constructor(name: string, category: string, productCharacteristic: ProductCharacteristic,
                place: string, company: string) {
        this.name = name;
        this.category = category;
        this.productCharacteristic = productCharacteristic;
        this.place = place;
        this.company = company;
    }
}
