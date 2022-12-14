import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ChartsModule } from 'ng2-charts';
import { RegisterUserModule } from './modules/register-user/register-user.module';
import { RegisterInversorModule } from './modules/register-inversor/register-inversor.module';
import { SimulateInvestmentModule } from './modules/simulate-investment/simulate-investment.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    RegisterUserModule,
    RegisterInversorModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,ReactiveFormsModule, SimulateInvestmentModule,
  ],
  providers: [ChartsModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
