import {NgModule} from '@angular/core';
import { NotFoundComponent } from './not-found.component';
import {CardModule} from 'primeng/card';
import { RouterModule } from '@angular/router';
import {ButtonModule} from 'primeng/button';

export const routes = [
	{ path: '', component: NotFoundComponent  }
  ];

@NgModule({
	imports: [
        ButtonModule,
		CardModule,
		RouterModule.forChild(routes),
	],
	declarations: [
		NotFoundComponent
	]
})
export class NotFoundModule {}