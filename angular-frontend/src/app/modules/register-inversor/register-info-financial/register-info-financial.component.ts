import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register-info-financial',
  templateUrl: './register-info-financial.component.html',
  styleUrls: ['./register-info-financial.component.css']
})
export class RegisterInfoFinancialComponent implements OnInit {

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
  }
  @Input() showInfoFinance:boolean=false;
  @Output() previousPhase = new EventEmitter<void>();
  infoFinanceGroup:FormGroup= this.fb.group({
    bank: new FormControl('', Validators.compose([
      Validators.required])),
    clabe: new FormControl('', Validators.compose([
      Validators.required,
      ])),
    savings: new FormControl('', Validators.compose([
        Validators.required
      ])),
    accountBank: new FormControl('', Validators.compose([
        Validators.required
      ]))
  });

  evaluateForm():boolean{
    let result: boolean = false;
    if(this.infoFinanceGroup){
      result=true;
    }
    return result;
  }

  public validationMessages = {
    bank: [
      { type: 'required', message: 'El banco no esta seleccionado.' }
    ],
    clabe: [
      { type: 'required', message: 'La CLABE no es válida.' }
    ],
    savings: [
      { type: 'required', message: 'El origen de los fondos no esta seleccionado' }
    ],
    accountBank: [
      { type: 'required', message: 'La cuenta bancaria no es válida.' }
    ]
   
  }

  

  
  
}
