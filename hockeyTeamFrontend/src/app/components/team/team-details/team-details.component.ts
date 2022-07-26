import { Component, Input, OnInit } from '@angular/core';
import { TeamService } from 'src/app/services/team.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Team } from 'src/app/models/team.model';

@Component({
  selector: 'app-team-details',
  templateUrl: './team-details.component.html',
  styleUrls: ['./team-details.component.css']
})
export class TeamDetailsComponent implements OnInit {


  @Input() team: Team = {
    id: '',
    coach: '',
    year: 0,
    players: []
  };

  message = '';

  constructor(
    private teamService: TeamService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
  }
}
