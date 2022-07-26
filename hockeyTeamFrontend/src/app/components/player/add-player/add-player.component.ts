import { Component, OnInit } from '@angular/core';
import { Team } from 'src/app/models/team.model';
import { Player } from 'src/app/models/player.model';
import { TeamService } from 'src/app/services/team.service';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-add-player',
  templateUrl: './add-player.component.html',
  styleUrls: ['./add-player.component.css']
})
export class AddPlayerComponent implements OnInit {

  teamYear : number = 0

  player: Player = {
    number: 0,
    name: '',
    lastname: '',
    position: '',
    is_captain: false
  };
  submitted = false;

  constructor(private teamService: TeamService) { }

  ngOnInit(): void {
  }
  
  savePlayer(): void {
    const player = {
      number: this.player.number,
      name: this.player.name,
      lastname: this.player.lastname,
      position: this.player.position,
      is_captain: this.player.is_captain
    };

    this.teamService.create(player, this.teamYear)
      .subscribe({
        next: (res: any) => {
          console.log(res);
          this.submitted = true;
        },
        error: (e: any) => console.error(e)
      });
  }

  newPlayer(): void {
    this.submitted = false;
    this.player = {
      number: 0,
      name: '',
      lastname: '',
      position: '',
      is_captain: false
    };
  }

}
