import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NewPersonComponent } from './new-person/new-person.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    NewPersonComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class PersonModule { }
