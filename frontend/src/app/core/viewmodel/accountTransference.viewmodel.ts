import { TaxMaxDaysEnum, TaxMaxValueEnum } from "../enums/tax.enum";
import { Account } from "./account.viewmodel";
import { AccountTransferenceTax } from "./accountTransferenceTax.viewmodel";

export class AccountTransference {
    
    accountOrigin!: Account;
    accountDestiny!: Account;
    valueTransference!: number;
    tax!:AccountTransferenceTax;
    appointmentDate!: Date;
    createdDate!: Date;

    constructor(values: any = {}) {
        if (Object.entries(values).length === 0 && values.constructor === Object) {
          return;
        }
        if (values.accountOrigin) {
            values.accountOrigin = values.accountOrigin.map((a: Account) => new Account(a));
        }
        if (values.accountDestiny) {
            values.accountDestiny = values.accountDestiny.map((a: Account) => new Account(a));
        }
        if (values.tax) {
            values.tax = values.tax.map((a: AccountTransferenceTax) => new AccountTransferenceTax(a));
        }
        Object.assign(this, values);
    }

    public static calcTax( accountTransference: AccountTransference):number{

/*
        maxDaysPerTax!: number;
        maxValuePeerTax!: number;
        taxPercent!: number;
        taxValue!: number;
*/
        let total = 0;
        let isExistTaxThenCalc = !accountTransference.tax;
        if(isExistTaxThenCalc){
            let diffInDates = accountTransference.createdDate.getTime() - accountTransference.appointmentDate.getTime();
            let diffInDays = diffInDates / (1000 * 3600 * 24);

            let taxPercent = 0;
            
            if(diffInDays <= TaxMaxDaysEnum.A){

            }else if(diffInDays <= TaxMaxDaysEnum.B){

            }else if(diffInDays <= TaxMaxDaysEnum.C){

            }else if(diffInDays <= TaxMaxDaysEnum.C2){
                
            }else if(diffInDays <= TaxMaxDaysEnum.C3){
                
            }else if(diffInDays > TaxMaxDaysEnum.C4){
                
            }

            let taxValue = 0;
            // if's max value
            if(accountTransference.valueTransference < TaxMaxValueEnum.A){

            }else if(accountTransference.valueTransference < TaxMaxValueEnum.B){
                
            }else if(accountTransference.valueTransference < TaxMaxValueEnum.C){
                

            }
        }

        let tax = accountTransference.tax;
        total += accountTransference.tax.taxValue;
        total += accountTransference.valueTransference * (0.1 * accountTransference.tax.taxPercent);

        return total;
    }

}