import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {

  constructor(private fb: FormBuilder) { }
  userForm:FormGroup= this.fb.group({
    email: new FormControl('', Validators.compose([
      Validators.required,
      Validators.email])),
    password: new FormControl('', Validators.compose([
      Validators.required,
      Validators.minLength(8),
      Validators.pattern("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,24}$")]))
  ,
      passwordConfirm: new FormControl('', Validators.compose([
        Validators.required
      ]))
  });

  public validationMessages = {
    email: [
      { type: 'email', message: 'El correo no es valido.' }
    ],
    password: [
      { type: 'minLength', message: 'Tu contraseña debe contener al menos 8 caracteres.' },
      { type: 'pattern', message: ' Tu contraseña debe contener al menos un digito, una minúscula, una mayúscula y un caracter especial.' }]
  }

  ngOnInit(): void {
  }

  validatePasswords(): boolean {
    let value: boolean = false;
    let password = this.userForm.get('password')?.value.toString()
    let passwordConfirm = this.userForm.get('passwordConfirm')?.value.toString()

    if ((password != "" && passwordConfirm != "") && this.equalPasswords()) {
      value = true;
    }
    return value;
  }
  
  
  equalPasswords(): boolean {
    let value: boolean = false;
    let password = this.userForm.get('password')?.value.toString()
    let passwordConfirm = this.userForm.get('passwordConfirm')?.value.toString()

    if (password == passwordConfirm) {
      value = true;
    }


    return value;
  }

  evaluateAccount(): boolean {
    let result: boolean = false;
    if (  this.userForm.valid && this.validatePasswords()) {
      result = true;
    }

    return result;
  }
}
