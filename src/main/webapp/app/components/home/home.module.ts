import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import {HomeRoutingModule} from "./home-routing.module";
import { ButtonModule } from 'primeng/button';
import {MegaMenuModule} from "primeng/megamenu";
import {MenubarModule} from "primeng/menubar";
import {InputTextModule} from "primeng/inputtext";
import {SidebarModule} from "primeng/sidebar";
import {BrowserAnimationsModule, NoopAnimationsModule} from "@angular/platform-browser/animations";
import {BrowserModule} from "@angular/platform-browser";
import {DataViewModule, DataViewLayoutOptions} from "primeng/dataview";
import {RatingModule} from "primeng/rating";
import {FormsModule} from "@angular/forms";
import {TagModule} from "primeng/tag";

@NgModule({
  declarations: [
    HomeComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    ButtonModule,
    MegaMenuModule,
    MenubarModule,
    InputTextModule,
    SidebarModule,
    DataViewModule,
    RatingModule,
    FormsModule,
    TagModule,

  ]
})
export class HomeModule { }
