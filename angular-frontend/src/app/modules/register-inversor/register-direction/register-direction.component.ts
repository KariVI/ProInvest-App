import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register-direction',
  templateUrl: './register-direction.component.html',
  styleUrls: ['./register-direction.component.css']
})
export class RegisterDirectionComponent implements OnInit {

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
  }

  @Input() showDirection:boolean=false;
  @Output() previousPhase = new EventEmitter<void>();

  directionGroup:FormGroup= this.fb.group({
    state: new FormControl('', Validators.compose([
      Validators.required])),
    city: new FormControl('', Validators.compose([
      Validators.required,
      ]))
  ,
    postalCode: new FormControl('', Validators.compose([
        Validators.required
      ])),
    colony: new FormControl('', Validators.compose([
        Validators.required
      ])),
  street: new FormControl('', Validators.compose([
        Validators.required
      ])),
  intStreet: new FormControl('', Validators.compose([
        Validators.required
    ]))
  });

  public validationMessages = {
    postalCode: [
      { type: 'postalCode', message: 'El código postal no esta seleccionado.' }
    ],
    colony: [
      { type: 'colony', message: 'La colonia no esta seleccionada.' }
    ],
    street: [
      { type: 'street', message: 'La calle no es válida' }
    ],
    state: [
      { type: 'state', message: 'El estado no esta seleccionado.' }
    ],
    city: [
      { type: 'city', message: 'La ciudad no esta seleccionada.' }
    ],
    intStreet: [
      { type: 'postalCode', message: 'El número de calle no esta seleccionado.' }
    ]
  }

  evaluateForm():boolean{
    let result: boolean = false;
    if(this.directionGroup.valid){
      result=true;
    }
    return result;
  }

  returnInfo(): void{
    this.previousPhase.emit();
  }
}
