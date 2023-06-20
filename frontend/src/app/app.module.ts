import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { CardModule } from 'primeng/card';
import { PageComponent } from './pages/page.component';
import { MenubarModule } from 'primeng/menubar';
import {MessageModule} from 'primeng/message';
import { DropdownModule } from 'primeng/dropdown';
import { PanelModule } from 'primeng/panel';
import { InputNumberModule } from 'primeng/inputnumber';
import { CalendarModule } from 'primeng/calendar';
import { KnobModule } from 'primeng/knob';
import { TransferenciaService } from './core/services/transferencia.service';
import { ContaService } from './core/services/conta.service';
import { HttpClientModule } from '@angular/common/http';
import { TaxPipe } from './pipes/tax.pipe';
import { PipesModule } from './pipes/pipe.module';


@NgModule({
  declarations: [
    AppComponent,
    PageComponent
  ],
  imports: [
    MessageModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    KnobModule,
    HttpClientModule,
    CalendarModule,
    FlexLayoutModule,
    InputNumberModule,
    CardModule,
    PanelModule,
    BrowserAnimationsModule,
    DropdownModule,
    MenubarModule,
    AppRoutingModule
  ],
  providers: [ContaService, TransferenciaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
