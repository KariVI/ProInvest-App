import { Injectable } from '@angular/core';
import { HttpClient,  HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environmentURL } from '../enviroments/enviroments';
import { IUser } from '../modules/model/interfaces/IUser';
import { ICpData } from '../modules/model/interfaces/IPostalCode';
import { catchError, retry } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})

export class DataService {

  private url= environmentURL.apiURL;
  constructor(private http: HttpClient) { 
  }

  getDataByPostalCode(postalCode: string): Observable<ICpData[]>{
    let urlSepoMex= `${this.url}/datoSepomex/getByCp/${postalCode}`;
    console.log(urlSepoMex);
    return this.http.get<ICpData[]>(urlSepoMex);
  }

  getUserbyEmail(email : string): Observable<IUser>{
    let urlUser= `${this.url}/usuarios/show/${email}`;
    return this.http.get<IUser>(urlUser);
  }
  
}