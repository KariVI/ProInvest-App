import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register-profile',
  templateUrl: './register-profile.component.html',
  styleUrls: ['./register-profile.component.css']
})
export class RegisterProfileComponent implements OnInit {

  constructor(private fb: FormBuilder) { }

  @Input() showProfile:boolean=false;
  @Output() previousPhase = new EventEmitter<void>();
  inversorGroup: FormGroup = this.fb.group({
    names: new FormControl('', Validators.compose(
      [Validators.required,
    Validators.pattern('a-zA-ZñÑá-úÁ-Ú')])),
    lastMotherName: new FormControl('', Validators.compose(
      [Validators.required,
      Validators.pattern('a-zA-ZñÑá-úÁ-Ú')])),
    lastFatherName: new FormControl('', Validators.compose(
        [Validators.required,
        Validators.pattern('a-zA-ZñÑá-úÁ-Ú')])),
    rfc: new FormControl('', Validators.compose(
          [Validators.required,
          Validators.pattern('^[A-Za-zñÑ&]{3,4}\d{6}\w{3}$')])),
    date: new FormControl('', Validators.compose(
            [Validators.required,
            Validators.pattern('/^\d{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])$/')])),
    work: new FormControl('', Validators.compose(
              [Validators.required,
              Validators.pattern('a-zA-ZñÑá-úÁ-Ú')])),
    grade: new FormControl('', Validators.compose(
      [Validators.required]))
    })

    public validationMessages = {
      names: [
        { type: 'pattern', message: 'Los nombres solo deben poseer letras' }
      ],
      lastFatherName: [
        { type: 'pattern', message: 'El apellido paterno solo deben poseer letras'  }],
      lastMotherName: [
        { type: 'pattern', message: 'El apellido materno solo deben poseer letras'  }],
      rfc: [
          { type: 'pattern', message: 'El rfc es invalido'  }],
      date: [
            { type: 'pattern', message: 'La fecha de nacimiento es invalida'  }],
      work: [
              { type: 'pattern', message: 'La profesión es inválida'  }],
      grade: [
            { type: 'pattern', message: 'El grado académico es inválido'  }]
      
      }

      evaluateForm():boolean{
        let result: boolean = false;
        if (  this.inversorGroup.valid ) {
          result = true;
        }
    
        return result;
      }


  ngOnInit(): void {
  }

}
