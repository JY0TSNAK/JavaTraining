import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ResponseDetails } from './testbody/ResponseDetails';

@Injectable({
  providedIn: 'root'
})
export class PostalDetailsService {

  constructor(private myHttp: HttpClient) { }

  fetchPostalDetailsService(pincode: string) : Observable<ResponseDetails> {
    return this.myHttp.get<ResponseDetails>("https://api.postalpincode.in/pincode/" + pincode);
  }
}
