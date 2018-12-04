import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {HttpClient} from '@angular/common/http'


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
user ={};
  constructor(private router:Router,private http:HttpClient) { }

          ngOnInit()     {
          }
  
          validateUser=function(){
              console.log(this.user);
      this.http.get('http://localhost:8080/login',this.user.name).
      subscribe(data=>{
          if(data==true)
              this.router.navigateByUrl(['contact',]);
          else
              this.router.navigateByUrl(['signup',]);
      }
      );
  }
  
         
      btnClick= function () {
        this.router.navigateByUrl('signup');
};
}
