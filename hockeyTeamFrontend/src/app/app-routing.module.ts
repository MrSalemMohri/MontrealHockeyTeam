import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TeamListComponent } from './components/team/team-list/team-list.component';
import { TeamDetailsComponent } from './components/team/team-details/team-details.component';
import { AddPlayerComponent } from './components/player/add-player/add-player.component';

const routes: Routes = [
  { path: '', redirectTo: 'Teams', pathMatch: 'full' },
  { path: 'Teams', component: TeamListComponent },
  { path: 'Teams/:id', component: TeamDetailsComponent },
  { path: 'add', component: AddPlayerComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
