import {Component} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {HeaderService} from "../../services/header.service";
import {ProductService} from "../../services/product.service";
import {AddingProductData} from "../../common/adding-product-data";

@Component({
  selector: 'app-adding-product',
  standalone: true,
    imports: [
        FormsModule
    ],
  templateUrl: './adding-product.component.html',
  styleUrl: './adding-product.component.css',
    providers: [ProductService, HeaderService]
})
export class AddingProductComponent {
    addingData:  AddingProductData ={
        "name": "",
        "category": "",
        "place": "",
        "company": "",
        "price": "",
        "weight": "",
        "availableAmount": "",
        "weightMeasurement": ""
    }
    constructor(private productService: ProductService,
                private headerService: HeaderService) {
    }

    addProduct(): void {
        const newPrice: number = +this.addingData.price;
        const newWeight: number = +this.addingData.weight;
        const newAvailableAmount: number = +this.addingData.availableAmount;
        this.productService.addProduct(this.addingData.name, this.addingData.category, this.addingData.place, this.addingData.company, newPrice, newWeight, newAvailableAmount,
            this.addingData.weightMeasurement, this.headerService.getAuthHeader());
    }
}
