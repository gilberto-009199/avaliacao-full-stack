import {NgModule} from '@angular/core';
import { RouterModule } from '@angular/router';

import { HomeComponent } from './home.component';


export const routes = [
	{ path: '', component: HomeComponent  }
];

@NgModule({
	imports: [
		RouterModule.forChild(routes),
	],
	declarations: [
        HomeComponent
	]
})
export class HomeModule {}