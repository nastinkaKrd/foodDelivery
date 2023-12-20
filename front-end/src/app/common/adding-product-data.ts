export class AddingProductData {
  public name: string;
  public category: string;
  public place: string;
  public company: string;
  public price: string;
  public weight: string;
  public availableAmount: string;
  public weightMeasurement: string;

  constructor(name: string, category: string, place: string, company: string, price: string, weight: string, availableAmount: string, weightMeasurement: string) {
    this.name = name;
    this.category = category;
    this.place = place;
    this.company = company;
    this.price = price;
    this.weight = weight;
    this.availableAmount = availableAmount;
    this.weightMeasurement = weightMeasurement;
  }
}
