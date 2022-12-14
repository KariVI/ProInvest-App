import { Injectable } from '@angular/core';
import { HttpClient,  HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environmentURL } from '../enviroments/enviroments';
import { IUser } from '../modules/model/interfaces/IUser';
import { IResponse } from '../modules/model/interfaces/IResponse';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  private url= environmentURL.baseUrl;
  constructor(private http: HttpClient) { 
  }

  createUser(newUser: IUser): Observable<IResponse>{
    let urlUser= `${this.url}/usuarios`;
    return this.http.post<IResponse>(urlUser, newUser,{
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })});
  }

  getUserbyEmail(email : string): Observable<IUser>{
    let urlUser= `${this.url}/usuarios/show/${email}`;
    return this.http.get<IUser>(urlUser);
  }
  
  login(user:IUser):Observable<IResponse>{
    let urlUser= `${this.url}/access/login`;
    return this.http.post<IResponse>(urlUser, user,{
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })});
  }
}