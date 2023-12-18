export class ProductCharacteristic {
  public price: number;
  public weight: number;
  public availableAmount: number;
  public weightMeasurement: string;

  constructor(price: number, weight: number, availableAmount: number, weightMeasurement: string) {
    this.price = price;
    this.weight = weight;
    this.availableAmount = availableAmount;
    this.weightMeasurement = weightMeasurement;
  }
}
