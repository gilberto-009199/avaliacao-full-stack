export class AccountTransferenceTax{
    
    maxDaysPerTax!: number;
	maxValuePeerTax!: number;
    taxPercent!: number;
	taxValue!: number;

    constructor(values: any = {}) {
        Object.assign(this, values);
    }
}