import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { debounceTime } from 'rxjs';
import { Team } from 'src/app/models/team.model';
import { TeamService } from 'src/app/services/team.service';

@Component({
  selector: 'app-team-list',
  templateUrl: './team-list.component.html',
  styleUrls: ['./team-list.component.css']
})
export class TeamListComponent implements OnInit {

  teams?: Team[];
  teamsToShow?: Team[];
  currentTeam: Team = {};
  currentIndex = -1;
  coachToSearch = '';
  _yearToSearchFormControl: FormControl = new FormControl({ value: undefined, disabled: false });

  constructor(private teamService: TeamService) {
    this._yearToSearchFormControl.valueChanges.pipe(debounceTime(1000)).subscribe((value) => {
      if(!value) {
        this.getAllTeams();
      } else {
        this.getTeamByYear(value);
      }
    });
  }

  ngOnInit(): void {
    this.getAllTeams();
  }

  get yearToSearch(): number {
    return this._yearToSearchFormControl.value;
  }

  retrieveTeams(): void {
    this.teamService.getAll()
      .subscribe({
        next: (data: Team[] | undefined) => {
          this.teams = data;
          console.log(data);
        },
        error: (e: any) => console.error(e)
      });
  }

  refreshList(): void {
    this.retrieveTeams();
    this.currentTeam = {};
    this.currentIndex = -1;
  }

  setActiveTeam(team: Team, index: number): void {
    this.currentTeam = team;
    this.currentIndex = index;
  }

  getAllTeams(): any {
    this.teamService.getAll().subscribe((teams: Team[]) => {
      this.teamsToShow = [ ...teams ];
    })
  }
  getTeamByYear(year: number): any {
    this.teamService.getByYear(year).subscribe((team: Team) => {
      this.teamsToShow = [ team ];
    })
  }
}
