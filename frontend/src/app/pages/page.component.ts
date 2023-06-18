import { Component, OnInit } from '@angular/core';

import { MenuItem } from 'primeng/api';

import { FormGroup, FormControl } from '@angular/forms';
import { ContaService } from '../core/services/conta.service';
import { TransferenciaService } from '../core/services/transferencia.service';
import { Account } from '../core/viewmodel/account.viewmodel';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
    selector: 'page-struture',
    templateUrl: './page.component.html',
    styleUrls: ['./page.component.css']
})
export class PageComponent implements OnInit {
    
    contas!: Account[];
    selectedConta!: Account;
    contasDestiny!: Account[];

    frmTransference: FormGroup = new FormGroup({
        accountDestiny: new FormControl(''),
        valueTransference: new FormControl(''),
        appointmentDate: new FormControl('')
    });
    constructor( private contaService:ContaService,
                 private transferenciaService:TransferenciaService,
                 private router: Router
               ){

        this.contas = [];
        contaService.getAll().subscribe((data:any)=>{
            this.contas = data;
            this.selectedConta = data[0];
            this.contasDestiny = data.slice(1);
//            this.router.navigate(['account',this.selectedConta])
        })
        this.router.navigate(['account'])
    }

    onChangeAccount(account:Account){
        this.contasDestiny = this.contas.filter(acc=>{
            return acc.numero != account.numero
        });
        this.router.navigate(['account',{numero:account.numero}])
    }

    onSubmitTransference(){

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