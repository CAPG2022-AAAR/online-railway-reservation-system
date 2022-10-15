import React, { Component } from 'react';

import axios from 'axios';

import { setAuthToken } from '../service/setAuthToken';




export class Login extends Component {

    constructor(props){
      super();


      this.state = {
        userName : '',
        password : ''
      }

    }





    render() {

          const handleSubmit = () => {
    
          const loginPayload = {
            userName: this.state.userName,
            password: this.state.password
          }

          axios.post("http://localhost:3000/authenticate", loginPayload)
            .then(response => {
            
              const token  =  response.data;
              localStorage.setItem("token", token);
              setAuthToken(token);
              console.log("Here comes JWT" + token);
              window.location.href = '/'
    
            })
          .catch(err => {
            
        
            alert(err.messsage);
            console.log(err)
            
          });

          

        }


      if(localStorage.getItem('token')){
        window.location.href = '/'
      }else{

        delete axios.defaults.headers.common["Authorization"];

        

      };

    return (

      

      

      <>

      <div> <h1>Login</h1>

      <input type = "text" onChange = {(event)=> this.setState({userName: event.target.value})} />
      <input type = "password" onChange = {(event)=> this.setState({password: event.target.value})} />

      <button onClick={ handleSubmit }>Click here to get Jwt</button>
      </div>

      </>


      
        
      
      
    );
  }
}

export default Login