import { Component, OnInit } from '@angular/core';

import { MenuItem } from 'primeng/api';

export interface Account {
    titular: string;
    numero: string;
}

@Component({
    selector: 'page-struture',
    templateUrl: './page.component.html',
    styleUrls: ['./page.component.css']
  })
export class PageComponent implements OnInit {
    
    contas: Account[];
    selectedConta: Account;

    constructor(){
        this.contas = [
            {numero:"258779", titular:"Gilberto R."},
            {numero:"158779", titular:"Rafael S."}];
        this.selectedConta = this.contas[0];
    }
    ngOnInit() {
        /*this.items = [
            {
                label: 'Selecionar Conta',
                icon: 'pi pi-fw pi-user',
                style: {'margin-left': '0'},
                items: []
            },
        ];*/

    }
}