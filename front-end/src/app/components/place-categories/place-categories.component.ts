import {Component, OnInit} from '@angular/core';
import {NgForOf} from "@angular/common";
import {PlaceCategoryDto} from "../../common/place-category-dto";
import {PlaceCategoriesService} from "../../services/place-categories.service";
import {RouterLink, RouterLinkActive} from "@angular/router";

@Component({
  selector: 'app-place-categories',
  standalone: true,
  imports: [
    NgForOf,
    RouterLink,
    RouterLinkActive
  ],
  templateUrl: './place-categories.component.html',
  styleUrl: './place-categories.component.css',
  providers: [PlaceCategoriesService]
})
export class PlaceCategoriesComponent implements OnInit{
  public placeCategories: PlaceCategoryDto[] = [];
  constructor(private placeCategoryService: PlaceCategoriesService) {
  }


  ngOnInit() {
    this.listPlaceCategories();
  }

  listPlaceCategories() {
    this.placeCategoryService.getPlaceCategories().subscribe(
      (data: PlaceCategoryDto[]) => {
        this.placeCategories = data;
      }
    )
  }
}
