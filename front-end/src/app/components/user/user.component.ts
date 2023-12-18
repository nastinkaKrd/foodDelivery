import {Component, OnInit} from '@angular/core';
import {UserInformationDto} from "../../common/user-information-dto";
import {UserService} from "../../services/user.service";
import {HeaderService} from "../../services/header.service";

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css',
  providers: [UserService, HeaderService]
})
export class UserComponent implements OnInit{
  public user: UserInformationDto | undefined;
  constructor(private userService: UserService,
              private headerService: HeaderService) {
  }

  ngOnInit():void {
    this.getUser();
  }

  getUser():void {
    this.userService.getUser(this.headerService.getAuthHeader()).subscribe(
        (data: UserInformationDto) => {
          this.user = data;
        }
    );
  }

}
