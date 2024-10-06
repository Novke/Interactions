import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/models/person';
import { PersonService } from '../person.service';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit{

  persons: Person[] = [];

  constructor(private personService: PersonService){}

  ngOnInit(): void {
    this.personService.getAll().subscribe(
      response => this.persons = response 
    )
  }



}
