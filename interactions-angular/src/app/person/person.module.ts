import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NewPersonComponent } from './new-person/new-person.component';
import { FormsModule } from '@angular/forms';
import { PersonListComponent } from './person-list/person-list.component';



@NgModule({
  declarations: [
    NewPersonComponent,
    PersonListComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class PersonModule { }
