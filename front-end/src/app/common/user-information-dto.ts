import {AddressDto} from "./address-dto";

export class UserInformationDto {
    public username: string;
    public email: string;
    public phoneNumber: number;
    public addresses: AddressDto[];

    constructor(username: string, email: string, phoneNumber: number, addresses: AddressDto[]) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addresses = addresses;
    }
}
