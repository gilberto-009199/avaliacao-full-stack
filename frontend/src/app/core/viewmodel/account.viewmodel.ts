import { AccountTransference } from "./accountTransference.viewmodel";

    
export class Account {

    titular: string = '';
    numero: string = '';
    listAccountTransferenceOrigin!: AccountTransference[];
    listAccountTransferenceDestiny!: AccountTransference[];

    constructor(values: any = {}) {
        if (Object.entries(values).length === 0 && values.constructor === Object) {
          return;
        }

        if (values.listAccountTransferenceOrigin) {
            values.listAccountTransferenceOrigin = values.listAccountTransferenceOrigin.map((a: AccountTransference) => new AccountTransference(a));
        }

        if (values.listAccountTransferenceDestiny) {
          values.listAccountTransferenceDestiny = values.listAccountTransferenceDestiny.map((a: AccountTransference) => new AccountTransference(a));
        }

        Object.assign(this, values);
    }
}