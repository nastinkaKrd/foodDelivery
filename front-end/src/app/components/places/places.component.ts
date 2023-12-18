import {Component, OnInit} from '@angular/core';
import {PlaceService} from "../../services/place.service";
import {CommonModule, NgForOf} from "@angular/common";
import {ActivatedRoute} from "@angular/router";
import {PlaceDto} from "../../common/place-dto";

@Component({
  selector: 'app-places',
  standalone: true,
  imports: [
    CommonModule,
    NgForOf
  ],
  templateUrl: './places.component.html',
  styleUrl: './places.component.css',
  providers: [PlaceService]
})
export class PlacesComponent implements OnInit{
  public places: PlaceDto[] = [];
  constructor(private placeService: PlaceService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.listPlacesByCategory();
    this.listPlacesByCity();
  }

  listPlacesByCategory() {
    const hasCategory: boolean = this.route.snapshot.paramMap.has('category');
    if (hasCategory){
      this.placeService.getPlacesByCategory(this.route.snapshot.paramMap.get('category')).subscribe(
        (data: PlaceDto[]) => {
          this.places = data;
        }
      )
    }
  }

  listPlacesByCity() {
    const hasCity: boolean = this.route.snapshot.paramMap.has('city');
    if (hasCity){
      this.placeService.getPlacesByCity(this.route.snapshot.paramMap.get('city')).subscribe(
          (data: PlaceDto[]) => {
            this.places = data;
          }
      )
    }
  }
}
