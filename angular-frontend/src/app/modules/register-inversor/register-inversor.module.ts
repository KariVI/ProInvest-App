import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterDirectionComponent } from './register-direction/register-direction.component';
import { RegisterInfoFinancialComponent } from './register-info-financial/register-info-financial.component';
import { RegisterInversorComponent } from './register-inversor.component';



@NgModule({
  declarations: [
    RegisterInversorComponent,
    RegisterDirectionComponent,
    RegisterInfoFinancialComponent
  ],
  imports: [
    CommonModule
  ]
})
export class RegisterInversorModule { }
