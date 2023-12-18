import {ProductCategoryDescriptionDto} from "./product-category-description-dto";

export class ProductCategory {
    constructor(productCategory: string, productCategoryDescription: ProductCategoryDescriptionDto) {
        this.productCategory = productCategory;
        this.productCategoryDescription = productCategoryDescription;
    }
    public productCategory: string;
    public productCategoryDescription: ProductCategoryDescriptionDto;

}
