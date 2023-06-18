import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Account } from '../viewmodel/account.viewmodel';

@Injectable({ providedIn: 'root' })
export class ContaService{
    
    private url_API = `${environment.serverUrl}`;
    
    constructor(private http: HttpClient) { }

    getAll():Observable<Account>{
        return this.http.get<Account>(`${this.url_API}/account`)
    }

}