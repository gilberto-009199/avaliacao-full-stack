import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ContaService } from 'src/app/core/services/conta.service';
import { TransferenciaService } from 'src/app/core/services/transferencia.service';
import { Account } from 'src/app/core/viewmodel/account.viewmodel';
import { AccountTransference } from 'src/app/core/viewmodel/accountTransference.viewmodel';


@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  
  account: string | null = "";

  saldo: number = 0;

  accountTransferences:AccountTransference[] = [];

  ngOnInit(): void {}

  ngAfterViewInit():void{

    this.route.params.subscribe((params) => {
      
      let account = this.route.snapshot.paramMap.get('numero');

      if(account == null){
      
        this.transferenciaService.getAll().subscribe(data=>{
          this.accountTransferences = data;
        });
  
      }else this.transferenciaService.getAllByAccount(account).subscribe(data=>{
          this.account = account;
          this.accountTransferences = data.listAccountTransferenceOrigin
          .concat(data.listAccountTransferenceDestiny);
          this.calcTax();
      });

    });
    
  }

  calcTax(){
    let total = 0;
    for(let transference of this.accountTransferences){
      
      let valueTransference = transference.valueTransference;
      let originIsAccount = transference.accountOrigin.numero == this.account;

      if( originIsAccount ){
        total -= valueTransference + AccountTransference.calcTax(transference);
      }else{
        total += valueTransference;
      }

    }
    this.saldo = total;
  }

  constructor(  private transferenciaService: TransferenciaService,
                private router: Router,
                private route: ActivatedRoute  ){
    this.account = "";
  }
  

}