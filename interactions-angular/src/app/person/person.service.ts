import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Person } from '../models/person';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  apiUrl = environment.apiUrl + "/person";

  constructor(private http: HttpClient) { 
  }

  savePerson(person: Person): Observable<Person> {
    return this.http.post<Person>(this.apiUrl, person);
  }

  getAll(): Observable<Person[]>{
    return this.http.get<Person[]>(this.apiUrl);
  }
}
