export class AddressDto {
    public id: number;

    public city: string;

    public street: string;

    public buildingNum: string;

    constructor(id: number, city: string, street: string, buildingNum: string) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.buildingNum = buildingNum;
    }
}
