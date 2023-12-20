import {Component, OnInit} from '@angular/core';
import {PlaceService} from "../../services/place.service";
import {CommonModule, NgForOf} from "@angular/common";
import {ActivatedRoute, ParamMap} from "@angular/router";
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
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.listPlacesByCategory(params);
      this.listPlacesByCity(params);
    });
  }

  listPlacesByCategory(params: ParamMap) {
    if (params.has('category')){
      this.placeService.getPlacesByCategory(params.get('category')).subscribe(
        (data: PlaceDto[]) => {
          this.places = data;
        }
      )
    }
  }

  listPlacesByCity(params: ParamMap) {
    if (params.has('city')){
      this.placeService.getPlacesByCity(params.get('city')).subscribe(
          (data: PlaceDto[]) => {
            this.places = data;
          }
      )
    }
  }
}
