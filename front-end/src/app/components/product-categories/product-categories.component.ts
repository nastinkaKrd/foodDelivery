import {Component, OnInit} from '@angular/core';
import {ProductCategory} from "../../common/product-category";
import {ProductCategoriesService} from "../../services/product-categories.service";
import {NgForOf} from "@angular/common";
import {RouterLink, RouterLinkActive} from "@angular/router";

@Component({
  selector: 'app-product-categories',
  standalone: true,
  imports: [
    NgForOf,
    RouterLinkActive,
    RouterLink
  ],
  templateUrl: './product-categories.component.html',
  styleUrl: './product-categories.component.css',
  providers: [ProductCategoriesService]
})
export class ProductCategoriesComponent implements OnInit{
  public productCategories: ProductCategory[] = [];
  constructor(private productCategoriesService: ProductCategoriesService) {
  }

  ngOnInit() {
    this.listProductCategories();
  }

  listProductCategories() {
    this.productCategoriesService.getProductCategories().subscribe(
        (data: ProductCategory[]) => {
          this.productCategories = data;
        }
    )
  }
}
