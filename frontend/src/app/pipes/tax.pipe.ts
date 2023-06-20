import { Pipe, PipeTransform } from '@angular/core';
import { AccountTransference } from '../core/viewmodel/accountTransference.viewmodel';

@Pipe({
  name: 'taxa'
})
export class TaxPipe implements PipeTransform{
  transform(transference: AccountTransference):any {
      return AccountTransference.calcTax(transference);
  }
}