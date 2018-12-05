import { Component, OnInit } from '@angular/core';
import { HttpClient } from  '@angular/common/http';
@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
customers : any;
  constructor(private http:HttpClient) {
      
  }

  ngOnInit() {
      console.log("dataaaaaaaaaaaa",this.customers);
      this.http.get('http://localhost:8080/users').subscribe(data =>  {
          this.customers=data;
             console.log("data from list :: ",data);
          });
  }
 

}
