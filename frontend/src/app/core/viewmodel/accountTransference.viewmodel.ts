import { TaxMaxDaysEnum, TaxMaxValueEnum, TaxPercentEnum, TaxValueEnum } from "../enums/tax.enum";
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
            values.accountOrigin = new Account( values.accountOrigin );
        }
        if (values.accountDestiny) {
            values.accountDestiny = new Account( values.accountDestiny );
        }
        if (values.tax) {
            console.log(values.tax);
            values.tax = new AccountTransferenceTax(values.tax);
        }
        Object.assign(this, values);
    }

    public static calcTax( accountTransference: AccountTransference):number{

        let total = 0;
        let taxValue = 0;
        let taxPercent = 0;
        
        let isExistTaxThenCalc = !accountTransference.tax;

        if(isExistTaxThenCalc){

            let diffInDates = accountTransference.createdDate.getTime() - accountTransference.appointmentDate.getTime();
            let diffInDays = Math.round(diffInDates / (1000 * 3600 * 24))* (-1);

            if(diffInDays <= TaxMaxDaysEnum.A){
                taxValue = TaxValueEnum.A;
                taxPercent = TaxPercentEnum.A;
            }else if(diffInDays <= TaxMaxDaysEnum.B){
                taxValue = TaxValueEnum.B;
                taxPercent = TaxPercentEnum.B;
            }else if(diffInDays <= TaxMaxDaysEnum.C){
                taxPercent = TaxPercentEnum.C;
            }else if(diffInDays <= TaxMaxDaysEnum.C2){
                taxPercent = TaxPercentEnum.C2;
            }else if(diffInDays <= TaxMaxDaysEnum.C3){
                taxPercent = TaxPercentEnum.C3;
            }else if(diffInDays > TaxMaxDaysEnum.C4){
                taxPercent = TaxPercentEnum.C4;
            }

            // if's max value
            if(accountTransference.valueTransference > TaxMaxValueEnum.A && accountTransference.valueTransference < TaxMaxValueEnum.B){
                taxValue = TaxValueEnum.B;
                taxPercent = TaxPercentEnum.B;
            }else if( accountTransference.valueTransference > TaxMaxValueEnum.B && accountTransference.valueTransference > TaxMaxValueEnum.C){
                taxValue = 0;
                if(diffInDays <= TaxMaxDaysEnum.C){
                    taxPercent = TaxPercentEnum.C;
                }else if(diffInDays <= TaxMaxDaysEnum.C2){
                    taxPercent = TaxPercentEnum.C2;
                }else if(diffInDays <= TaxMaxDaysEnum.C3){
                    taxPercent = TaxPercentEnum.C3;
                }else if(diffInDays > TaxMaxDaysEnum.C4){
                    taxPercent = TaxPercentEnum.C4;
                }
            }
        } else {
            taxValue = accountTransference.tax.taxValue;
            taxPercent = accountTransference.tax.taxPercent;
        }

        total += taxValue;
        total += accountTransference.valueTransference * (0.01 * taxPercent);

        return total;
    }

}