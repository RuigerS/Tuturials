import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AfdelingComponent } from './components/afdeling/afdeling.component';
import { PersonenComponent } from './components/personen/personen.component';

const routes: Routes = [ 
  {
   path: '',
   redirectTo: 'home',
   pathMatch: 'full'
  },
  {
   path: 'home',
   component: HomeComponent
  },
  {
    path: 'afdeling',
    component: AfdelingComponent
  },
  {
    path: 'personen',
    component: PersonenComponent
  },
  {
   path: '**',
   redirectTo: 'home'
  }
 ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
