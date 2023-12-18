export class AuthResponseDto {
    public jwt: string;

    constructor(jwt: string) {
        this.jwt = jwt;
    }
}
