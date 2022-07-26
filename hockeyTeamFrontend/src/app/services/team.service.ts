import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Team } from '../models/team.model';
import { Player } from '../models/player.model';

const baseUrl = 'http://localhost:8080/api/team';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Team[]> {
    return this.http.get<Team[]>(baseUrl);
  }

  get(id: any): Observable<Team> {
    return this.http.get<Team>(`${baseUrl}/${id}`);
  }

  getByYear(year: any): Observable<Team> {
    return this.http.get<Team>(`${baseUrl}/${year}`);
  }

  addPlayerForTeamByYear(player: Player, year: number): Observable<any> {
    return this.http.post(`${baseUrl}/${year}`, player);
  }

  create(player: Player, year : number): Observable<any> {
    return this.http.post(`${baseUrl}/${year}`, player);
  }
}
