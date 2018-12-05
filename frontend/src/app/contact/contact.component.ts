import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  contacts: any;
  user ={};
  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute) { }
  ngOnInit() {
   this.user =  this.route.snapshot.params['name'];
    this.http.get('http://localhost:8080/getUser/'+this.user).subscribe(data => {
      this.contacts = data;
    console.log(data.toString);
    });

  }

  userList = function(){
      this.router.navigate(['/customer',this.user ]);
  }
}


