import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private API_URL = 'http:localhost:8080/tasks'
  constructor(private http: HttpClient) { }

  // Método para realizar uma requisição GET
  findAll(): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/tasks/api/task`);
  }
}
