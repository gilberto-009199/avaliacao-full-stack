import {NgModule} from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { TableModule } from 'primeng/table';
import { HomeComponent } from './home.component';
import { PanelModule } from 'primeng/panel';


export const routes = [
	{ path: '', component: HomeComponent  }
];

@NgModule({
	imports: [
		TableModule,
		CommonModule,
		PanelModule,
		RouterModule.forChild(routes),
	],
	declarations: [
        HomeComponent
	]
})
export class HomeModule {}