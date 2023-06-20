import { NgModule } from "@angular/core";
import { TaxPipe } from "./tax.pipe";


@NgModule({
  declarations: [TaxPipe],
  providers:[TaxPipe],
  exports: [TaxPipe]
})
export class PipesModule {}