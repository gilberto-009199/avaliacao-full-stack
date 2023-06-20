import {NgModule} from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { TableModule } from 'primeng/table';
import { HomeComponent } from './home.component';
import { PanelModule } from 'primeng/panel';
import { PipesModule } from 'src/app/pipes/pipe.module';


export const routes = [
	{ path: '', component: HomeComponent  }
];

@NgModule({
	imports: [
		PipesModule,
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