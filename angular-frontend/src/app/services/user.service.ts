import { Injectable } from '@angular/core';
import { HttpClient,  HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../enviroments/enviroments';
import { IUser } from '../modules/model/interfaces/IUser';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  private url= environment.baseUrl;
  constructor(private http: HttpClient) { 
  }

  createUser(newUser: IUser): Observable<string>{
    let urlUser= `${this.url}/usuarios`;
    return this.http.post(urlUser, newUser,{
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    }),
      responseType: 'text'
    });
  }

  getUserbyEmail(email : string): Observable<IUser>{
    let urlUser= `${this.url}/usuarios/show/${email}`;
    return this.http.get<IUser>(urlUser);
  }
  
}