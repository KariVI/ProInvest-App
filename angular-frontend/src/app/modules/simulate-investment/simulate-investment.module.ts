import { NgModule } from '@angular/core';
import { CommonModule} from '@angular/common';
import { SimulateInvestmentComponent } from './simulate-investment.component';
import { ChartsModule } from 'ng2-charts';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
     ],
  imports: [
    CommonModule,
    FormsModule, ReactiveFormsModule
  ],
  providers:[ChartsModule]
})
export class SimulateInvestmentModule { }
