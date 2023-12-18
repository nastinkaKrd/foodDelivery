import {AddressDto} from "./address-dto";

export class PlaceDataDto {
    public name: string;

    public address: AddressDto;

    public placeCategory: string;

    constructor(name: string, address: AddressDto, placeCategory: string) {
        this.name = name;
        this.address = address;
        this.placeCategory = placeCategory;
    }
}
