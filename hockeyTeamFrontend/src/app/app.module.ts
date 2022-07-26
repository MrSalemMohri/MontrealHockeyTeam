import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddPlayerComponent } from './components/player/add-player/add-player.component';
import { TeamDetailsComponent } from './components/team/team-details/team-details.component';
import { TeamListComponent } from './components/team/team-list/team-list.component';

@NgModule({
  declarations: [
    AppComponent,
    AddPlayerComponent,
    TeamDetailsComponent,
    TeamListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
