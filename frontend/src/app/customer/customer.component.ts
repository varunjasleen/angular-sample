import { Component, OnInit } from '@angular/core';
import { HttpClient } from  '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
customers : any;
user:any;
  constructor(private http:HttpClient,private router:Router,private route:ActivatedRoute) {
      
  }

  ngOnInit() {
      this.user=this.route.snapshot.params['id'];
      this.http.get('http://localhost:8080/users').subscribe(data =>  {
          this.customers=data;
          
          this.customers.forEach(obj => {
             if( indexOf(obj.name==this.user)){
                 console.log("childObj >>",obj);
                  /*obj.forEach(childObj=> {
                      console.log("childObj >>",childObj);
                   });*/
              }
            
            
          });
          console.log("data from list :: ",data);
          });
  }
 
  addFriend = function(name){
      console.log("abc",this.user,name);
      this.http.get('http://localhost:8080/addFriend/'+this.user+'/'+name).subscribe(data =>  {
             console.log("data from list :: ",data);
          });
  }

}
