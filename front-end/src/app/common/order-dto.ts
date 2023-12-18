import {Product} from "./product";

export class OrderDto {
    public dateAndTime: Date;
    public price : number;
    public payment : string;
    public status : string;
    public productMetadata : Product[];

    constructor(dateAndTime: Date, price: number, payment: string, status: string, productMetadata: Product[]) {
        this.dateAndTime = dateAndTime;
        this.price = price;
        this.payment = payment;
        this.status = status;
        this.productMetadata = productMetadata;
    }
}
