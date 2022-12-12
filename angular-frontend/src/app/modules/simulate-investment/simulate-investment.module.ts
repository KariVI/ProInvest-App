import { NgModule } from '@angular/core';
import { CommonModule} from '@angular/common';
import { SimulateInvestmentComponent } from './simulate-investment.component';
import { BargraphComponent } from '../bargraph/bargraph.component';
import { ChartsModule } from 'ng2-charts';
@NgModule({
  declarations: [
    SimulateInvestmentComponent,
  BargraphComponent ],
  imports: [
    CommonModule,
    
  ],
  providers:[ChartsModule]
})
export class SimulateInvestmentModule { }
