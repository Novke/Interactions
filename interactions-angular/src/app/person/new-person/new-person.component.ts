import { Component } from '@angular/core';
import { PersonService } from '../person.service';
import { Person } from 'src/app/models/person';

@Component({
  selector: 'app-new-person',
  templateUrl: './new-person.component.html',
  styleUrls: ['./new-person.component.css']
})
export class NewPersonComponent {

  newPersonName = ""
  newPersonLastname = ""
  newPersonDescription = ""

  constructor(private personService: PersonService){
  }

  savePerson(): void{
    console.log("Saving person ", this.newPersonName, this.newPersonLastname)
    
    const person = new Person();
    person.name=this.newPersonName;
    person.lastname=this.newPersonLastname;
    person.description=this.newPersonDescription;
    
    this.personService.savePerson(person).subscribe(
      response => {
      console.log("Saved succesfully! ID =", response.id)
      },
      error => {
        console.error("Error saving person", error)
      }
    )
  }

}
