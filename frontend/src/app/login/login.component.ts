import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {HttpClient} from '@angular/common/http'


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
private user:any= {};
  constructor(private router:Router,private http:HttpClient) { }

          ngOnInit()     {
          }

          validateUser=function(){
              console.log("aaaaaaa",this.user);
      this.http.post('http://localhost:8080/login',this.user).
      subscribe(res => {
          if(res)
          this.router.navigate(['/contact',this.user ]);
          else
              this.router.navigate(['/signup',this.user  ]);
        }, (err) => {
          console.log(err);
        }
      );
      /*subscribe(data=>{
          if(data==true)
              this.router.navigateByUrl(['contact',]);
          else
              this.router.navigateByUrl(['signup',]);
      }
      );*/
  }
  
         
      btnClick= function () {
        this.router.navigateByUrl('signup');
};
}
