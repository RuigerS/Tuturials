import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) {  }

  loadPersonen(): Observable<any> {
    return this.http.get(environment.baseURL + '/personen');
  }

  loadPersonenForAfdeling(id: number): Observable<any> {
    return this.http.get(environment.baseURL + '/personen/afdeling/' + id);
  }

  loadAfdelingen(): Observable<any> {
    return this.http.get(environment.baseURL + '/afdelingen');
  }

  saveAfdeling(model: any): Observable<any> {
    return this.http.post(environment.baseURL + '/afdelingen', model);
  }

  deleteAfdeling(id: number): Observable<any> {
    return this.http.delete(environment.baseURL + '/afdelingen/' + id);
  }

  updateAfdeling(model: any): Observable<any> {
    console.log('update:', model)
    return this.http.put(environment.baseURL + '/afdelingen/' + model.id, model);
  }
}
