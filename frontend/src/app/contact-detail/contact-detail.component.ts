import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-contact-detail',
  templateUrl: './contact-detail.component.html',
  styleUrls: ['./contact-detail.component.css']
})
export class ContactDetailComponent implements OnInit {

  contact = {};

  constructor(private route: ActivatedRoute,private router: Router, private http: HttpClient) { }

  ngOnInit() {
    this.getContactDetail(this.route.snapshot.params['id']);
  }

  getContactDetail(id) {
    this.http.get('http://localhost:8080/contacts/'+id).subscribe(data => {
      this.contact = data;
    });
  }
  deleteContact() {
    console.log("inside");
    this.http.delete('http://localhost:8080/contacts/'+this.route.snapshot.params['id'])
      .subscribe(res => {
          this.router.navigate(['/contact']);
        }, (err) => {
          console.log(err);
        }
      );
  }

}