import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageComponent } from './pages/page.component';


const routes: Routes = [
  {
    path: '',
    component: PageComponent, children:[
      { path: 'account', loadChildren: () => import('./pages/home/home.module').then(m => m.HomeModule) }
    ]
  },
  { path: '**', loadChildren:() => import('./pages/not-found/not-found.module').then(m => m.NotFoundModule) }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
