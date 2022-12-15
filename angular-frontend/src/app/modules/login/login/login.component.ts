import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { DataService } from 'src/app/services/data.service';
import { UserService } from 'src/app/services/user.service';
import { IResponse } from '../../model/interfaces/IResponse';
import { IUser } from '../../model/interfaces/IUser';
import { User } from '../../model/User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  url ="http://localhost:4200/usuario";
  $response: Observable<IResponse> = new Observable();
  @Input() showMenu!: boolean ;
  loginGroup:FormGroup = this.fb.group({
    email: new FormControl('', Validators.compose([
      Validators.required])),
    password: new FormControl('', Validators.compose([
      Validators.required]))
  });
  constructor(private fb: FormBuilder, private userService:UserService, private dataService:DataService) { }

  ngOnInit(): void {
    this.dataService.getBanks();
  }


 

  login(): void{
    let account: IUser = {
      email: this.loginGroup.get('email')?.value.toString(),
      password: this.loginGroup.get('password')?.value.toString()
    }
    this.$response= this.userService.login(account);
    this.$response.forEach(
      (value: IResponse) => this.showMenu= value.error
    );
  }

}
