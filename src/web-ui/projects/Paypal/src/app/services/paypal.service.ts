import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {IUser} from '@paypal/services/api-interfaces/iuser';
import {ICartItem} from '@paypal/services/api-interfaces/icart-item';
import { IService } from './api-interfaces/iservice';

@Injectable({
  providedIn: 'root'
})
export class PaypalService {
  private user: IUser;
  private avaliableServices: IService[];
  private cart: ICartItem[] = [];

  public SetUser(emailAddress: string, firstName: string, lastName: string): void {
    console.log(emailAddress);
    this.user = {emailAddress, firstName, lastName};
    console.log(this.user);
  }

  public GetUser(): IUser {
    return this.user;
  }

  public IsLoggedIn(): boolean {
    return this.user !== undefined;
  }

  public GetAvaliableService(): IService[] {
    if (this.avaliableServices === undefined)
    {
      this.httpClient.get('/assets/services.json').subscribe((services: IService[]) => {
        this.avaliableServices = services;
      }, (error: any) => {
        // pass
      });
    }
    return this.avaliableServices;
  }

  public AddItemToCart(service: IService): void {
    const cartItem: ICartItem = {price: service.price, id: service.id, name:service.name};
    if (this.cart.filter((value: ICartItem) => value.id === cartItem.id).length > 0) {
      return;
    }
    this.cart.push(cartItem);
  }

  public RemoveItemFromCart(cartItem: ICartItem): void {
    const templist = [];
    while(this.cart.length > 0) {
      const item = this.cart.pop()
      if (item.id === cartItem.id) {
      }
      else {
        templist.push(item);
      }
    }
    this.cart = templist;
  }

  public GetCart(): ICartItem[] {
    return this.cart
  }

  public TotalCost(): number {
    var total = 0;
    this.cart.forEach(element => {
      total += element.price;
    });
    return total;
  }

  constructor(private httpClient: HttpClient) { }
}
