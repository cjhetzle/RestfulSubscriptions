import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  private isNewUser: boolean = false;
  public password: string = "";
  public reEnterPassword: string = "";
  public emailAddress: string = "";
  public firstName: string = "";
  public lastName: string = "";

  constructor() { }

  ngOnInit(): void {
  }

  public IsNewUser(): boolean {
    return this.isNewUser
  }

  public OnSignUp(): void {
    this.isNewUser = true;
  }

  public OnSubmit(): void {
    
  }
}
