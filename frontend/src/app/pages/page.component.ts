import { Component, OnInit } from '@angular/core';

import { MenuItem } from 'primeng/api';

import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { ContaService } from '../core/services/conta.service';
import { TransferenciaService } from '../core/services/transferencia.service';
import { Account } from '../core/viewmodel/account.viewmodel';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { AccountTransference } from '../core/viewmodel/accountTransference.viewmodel';

@Component({
    selector: 'page-struture',
    templateUrl: './page.component.html',
    styleUrls: ['./page.component.css']
})
export class PageComponent implements OnInit {
    
    contas!: Account[];
    selectedConta!: Account;
    contasDestiny!: Account[];
    minDateVal = new Date();
    tax: number = 0;

    frmTransference!: FormGroup;

    constructor( private contaService:ContaService,
                 private transferenciaService:TransferenciaService,
                 private router: Router,
                 private fb: FormBuilder
               ){

        this.contas = [];
        contaService.getAll().subscribe((data:any)=>{
            this.contas = data;
            this.selectedConta = data[0];
            this.contasDestiny = data.slice(1);
//            this.router.navigate(['account',this.selectedConta])
        })
        this.router.navigate(['account'])
        this.frmTransference = this.fb.group({
            accountDestiny: new FormControl('',Validators.required),
            valueTransference: new FormControl('',Validators.compose([Validators.required, Validators.min(3.3)])),
            appointmentDate: new FormControl('',Validators.required),
            tax_pressume: new FormControl('')
        });
    }

    onChangeAccount(account:Account){
        this.selectedConta = account;
        this.contasDestiny = this.contas.filter(acc=>{
            return acc.numero != account.numero
        });
        this.router.navigate(['account',{numero:account.numero}])
    }

    onSubmitTransference(data:any){

        let hasValidFormThenSubmit = this.frmTransference.dirty && this.frmTransference.valid;

        if (!hasValidFormThenSubmit) return;

        let req = new AccountTransference({
            valueTransference: data.valueTransference,
            appointmentDate: data.appointmentDate,
            accountOrigin: this.selectedConta,
            accountDestiny: data.accountDestiny
        });

        this.transferenciaService.create(req).subscribe(res=>{
            this.router.navigate(['account',{numero:res.accountDestiny.numero}])
        });
    }

    onChangeAccountTransference(){

        let isValidFormThenCalcTax = this.frmTransference.controls['appointmentDate'].valid && this.frmTransference.controls['appointmentDate'].dirty && this.frmTransference.controls['valueTransference'].valid && this.frmTransference.controls['valueTransference'].dirty;

        if(isValidFormThenCalcTax){
            let values = this.frmTransference.getRawValue();
            let req = new AccountTransference({
                valueTransference: values.valueTransference,
                appointmentDate: values.appointmentDate,
                createdDate: new Date()
            });

            this.tax = (AccountTransference.calcTax(req));
            this.frmTransference.controls['tax_pressume'].setValue((values.valueTransference / this.tax));
        }
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