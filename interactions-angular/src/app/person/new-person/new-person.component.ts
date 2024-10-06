import { Component } from '@angular/core';

@Component({
  selector: 'app-new-person',
  templateUrl: './new-person.component.html',
  styleUrls: ['./new-person.component.css']
})
export class NewPersonComponent {

  newPersonName = ""
  newPersonLastname = ""

  savePerson(): void{
    console.log("Saving person ", this.newPersonName, this.newPersonLastname)
  }

}
