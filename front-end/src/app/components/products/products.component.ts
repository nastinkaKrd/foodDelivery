import {Component, OnInit} from '@angular/core';
import {Product} from "../../common/product";
import {CurrencyPipe, NgForOf, NgIf} from "@angular/common";
import {ProductService} from "../../services/product.service";
import {ActivatedRoute, ParamMap} from "@angular/router";

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
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.listProductsByCategory(params);
    });
  }

  listProductsByCategory(params: ParamMap) {
    if (params.has('category')){
      this.productService.getProductsByCategory(params.get('category')).subscribe(
          (data: Product[]) => {
            this.products = data;
          }
      );
    }
  }

}


