import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { DirectionInversor } from '../model/Direction';
import { InfoFinancial } from '../model/InfoFinancial';
import { IDirectionInversor } from '../model/interfaces/IDirection';
import { IInfoFinancial } from '../model/interfaces/IInfoFinancial';
import { IInversor } from '../model/interfaces/IInversor';
import { Inversor } from '../model/Inversor';

@Component({
  selector: 'app-register-inversor',
  templateUrl: './register-inversor.component.html',
  styleUrls: ['./register-inversor.component.css']
})
export class RegisterInversorComponent implements OnInit {

  constructor(private fb: FormBuilder) { }
  inversor: Inversor = new Inversor();
  direction: DirectionInversor = new DirectionInversor();
  infoFinancial: InfoFinancial = new InfoFinancial();
  showProfile: boolean = true;
  showDirection: boolean = false;
  showInfoFinance: boolean = false;
  contSections =0;
  sections: Array<boolean> = [this.showProfile, this.showDirection, this.showInfoFinance];


  previousSection(){
  
    
      this.contSections= this.contSections- 1;
    
      
    
  }

  nextSection(){
   

      this.contSections= this.contSections + 1;

      
    
  }

  saveData():void{
   
  }

  ngOnInit(): void {
  }

}
