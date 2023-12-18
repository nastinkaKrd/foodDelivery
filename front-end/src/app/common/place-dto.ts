import {PlaceCategoryDto} from "./place-category-dto";
import {AddressDto} from "./address-dto";

export class PlaceDto {
    public name: string;

    public placeCategory: PlaceCategoryDto;

    public addresses: AddressDto[];

    constructor(name: string, placeCategory: PlaceCategoryDto, addresses: AddressDto[]) {
        this.name = name;
        this.placeCategory = placeCategory;
        this.addresses = addresses;
    }
}
