import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ChartsModule } from 'ng2-charts';
import { RegisterUserModule } from './modules/register-user/register-user.module';
import { RegisterInversorModule } from './modules/register-inversor/register-inversor.module';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './modules/login/login/login.component';
import { SimulateInvestmentComponent } from './modules/simulate-investment/simulate-investment.component';
@NgModule({
  declarations: [
    AppComponent, LoginComponent, SimulateInvestmentComponent
  ],
  imports: [
    RegisterUserModule,
    RegisterInversorModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,ReactiveFormsModule,
     HttpClientModule
  ],
  providers: [ChartsModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
