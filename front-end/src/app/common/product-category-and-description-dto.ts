export class ProductCategoryAndDescriptionDto {
    public category: string;

    public description: string;

    constructor(category: string, description: string) {
        this.category = category;
        this.description = description;
    }
}
