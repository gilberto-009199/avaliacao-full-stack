import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { AccountTransference } from '../viewmodel/accountTransference.viewmodel';
import { Account } from '../viewmodel/account.viewmodel';

@Injectable({ providedIn: 'root' })
export class TransferenciaService{

    private url_API = `${environment.serverUrl}`;

    constructor(private http: HttpClient) { }

    create(req : AccountTransference):Observable<any>{
        return this.http.post<any>(`${this.url_API}/account/transference`,req);
    }
    getAll():Observable<AccountTransference[]>{
        return this.http.get<AccountTransference[]>(`${this.url_API}/account/transference`)
    }

    getAllByAccount(numero:string):Observable<Account>{
        return this.http.get<Account>(`${this.url_API}/account/${numero}`)
    }

}