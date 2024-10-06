import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewPersonComponent } from './person/new-person/new-person.component';
import { PersonListComponent } from './person/person-list/person-list.component';

const routes: Routes = [
  {path: 'person', component: PersonListComponent},
  {path: 'person/new', component: NewPersonComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
