import {Component} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {OrderService} from "../../services/order.service";

@Component({
  selector: 'app-order',
  standalone: true,
    imports: [
        FormsModule
    ],
  templateUrl: './order.component.html',
  styleUrl: './order.component.css',
  providers: [OrderService]
})
export class OrderComponent {
  constructor(private orderService: OrderService) { }

  changeStatus(id: string, status: string) {
    this.orderService.changeStatus(id, status);
  }
}
