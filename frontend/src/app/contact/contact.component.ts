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
  friendList: any;
  chatData: any;
  chatmsg :String ="";
  receiver : String ="";
  contectData :any;
  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute) { }
  
  ngOnInit() {
   this.user =  this.route.snapshot.params['name'];
   console.log(this.user);
    this.http.get('http://localhost:8080/getUser/'+this.user).subscribe(data => {
      this.contacts = data;
      this.friendList=data.friendList;
    console.log("friendList",this.friendList);
    });

    
  }

  userList = function(){
      this.router.navigate(['/customer',this.user ]);
  }
  
  requestList=function(){
      this.router.navigate(['/customer',this.user ]);
  }
  
  pendingRequest=function(contact){
      contact.staus = "1";
     this.http.put('http://localhost:8080/reqApproved',this.contacts).
     subscribe(result=>{
        console.log(result); 
     });
  }
  
  
  chat =function(contact){
      this.contectData = contact;
      this.receiver=contact.name;
      console.log(this.receiver);
     this.http.get('http://localhost:8080/getChat/'+this.user+'/'+this.receiver).
     subscribe(result=>{
         this.chatData=result;
        console.log(result); 
     });
  }
  
  
  sendMessage=function(){
      console.log("msg",this.user,this.receiver,this.chatmsg); 
      this.http.post('http://localhost:8080/saveChat/'+this.user+'/'+this.receiver,this.chatmsg).
      subscribe(result=>{
         console.log(result); 
      });
      this.chatmsg = "";
      this.chat(this.contectData);
   }
  
}


