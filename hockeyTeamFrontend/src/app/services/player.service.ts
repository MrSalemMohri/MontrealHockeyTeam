import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Player } from '../models/player.model';

const baseUrl = 'http://localhost:8080/api/player';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Player[]> {
    return this.http.get<Player[]>(baseUrl);
  }

  get(id: any): Observable<Player> {
    return this.http.get<Player>(`${baseUrl}/${id}`);
  }

  makeCaptain(id: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}/captain`, {});
  }
}
