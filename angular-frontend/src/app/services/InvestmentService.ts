import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environmentURL } from '../enviroments/enviroments';
import { IInversor } from '../modules/model/interfaces/IInversor';
import { IResponse } from '../modules/model/interfaces/IResponse';
import { IDirectionInversor } from '../modules/model/interfaces/IDirection';
import { IInfoFinancial } from '../modules/model/interfaces/IInfoFinancial';


@Injectable({
    providedIn: 'root'
})

export class InvestmentService {

    private url = environmentURL.baseUrl;
    constructor(private http: HttpClient) {
    }

    createInversor(newInversor: IInversor): Observable<IResponse> {
        let urlInversor = `${this.url}/inversionista/registrarInversionista`;
        return this.http.post<IResponse>(urlInversor, newInversor, {
            headers: new HttpHeaders({
                'Content-Type': 'application/json'
            })
        });
    }

    createDirection(newDirection: IDirectionInversor): Observable<IResponse> {
        let urlDirection = `${this.url}/direccion/registrarDireccion`;
        return this.http.post<IResponse>(urlDirection, newDirection, {
            headers: new HttpHeaders({
                'Content-Type': 'application/json'
            })
        });
    }

    createInfoFinancial(newInfo: IInfoFinancial): Observable<IResponse> {
        let urlInfo = `${this.url}/informacionFinanciera/registrarInformacion`;
        return this.http.post<IResponse>(urlInfo, newInfo, {
            headers: new HttpHeaders({
                'Content-Type': 'application/json'
            })
        });
    }



}
