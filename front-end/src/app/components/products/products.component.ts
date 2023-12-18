import {Component, OnInit} from '@angular/core';
import {Product} from "../../common/product";
import {CurrencyPipe, NgForOf, NgIf} from "@angular/common";
import {ProductService} from "../../services/product.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [
    CurrencyPipe,
    NgForOf,
    NgIf
  ],
  templateUrl: './products.component.html',
  styleUrl: './products.component.css',
  providers: [ProductService]
})
export class ProductsComponent implements OnInit{
  public products: Product[] = [];
  constructor(private productService: ProductService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.listProductsByCategory();
  }

  listProductsByCategory() {
    const hasCategory: boolean = this.route.snapshot.paramMap.has('category');
    if (hasCategory){
      this.productService.getProductsByCategory(this.route.snapshot.paramMap.get('category')).subscribe(
          (data: Product[]) => {
            this.products = data;
          }
      );
    }
  }

}


