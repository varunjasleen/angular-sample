import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

 user  = {};
 abc={};
  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() {
  }

  saveuser(){
      console.log(this.user);
      this.http.post('http://localhost:8080/user',this.user)
      .subscribe(res=>{
          this.router.navigate(['/login',user])
      },(err)=>{
          consloe.log(err);
      }
      );
  }
}



