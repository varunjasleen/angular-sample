import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
a :any;
  constructor(private http:HttpClient,private router:Router,private route:ActivatedRoute) { }

  ngOnInit() {
this.getContact(this.route.snapshot.params['id']);
console.log("id",this.route.snapshot.params['id'])
 }
    
  getContact(id){
      console.log("enter")
 this.http.get('http://localhost:8080/customer/'+id).subscribe(data =>{
 this.a=data;
     console.log("data",data);
  }
  },

}
