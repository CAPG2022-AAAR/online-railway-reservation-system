import React, { Component } from 'react';

import { Button, Checkbox, Form, Input } from 'antd';

import axios from 'axios';

import { setAuthToken } from '../service/setAuthToken';

import 'antd/dist/antd.css'





export class Login extends Component {

    constructor(props){
      super();


      this.state = {
        userName : '',
        password : ''
      }

    }





    render() {

          const handleSubmit = (values) => {
    
          const loginPayload = {
            userName: values.username,
            password: values.password
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

      <div style={{ marginTop:'10vh' , paddingRight:'15%'}}>

      <Form
          name="basic"
          labelCol={{
            span: 8,
          }}
      wrapperCol={{
        span: 16,
      }}
      initialValues={{
        remember: true,
      }}
      onFinish={handleSubmit}
      
      autoComplete="off"
    >
      <Form.Item
        label="Username"
        name="username"
        rules={[
          {
            required: true,
            message: 'Please input your username!',
          },
        ]}
      >
        <Input />
      </Form.Item>

      <Form.Item
        label="Password"
        name="password"
        rules={[
          {
            required: true,
            message: 'Please input your password!',
          },
        ]}
      >
        <Input.Password />
      </Form.Item>

      

      <Form.Item
        wrapperCol={{
          offset: 8,
          span: 16,
        }}
      >
        <Button type="primary" htmlType="submit">
          Submit
        </Button>
      </Form.Item>
      </Form>

      </div>

      {/* <div> <h1>Login</h1>

      <input type = "text" onChange = {(event)=> this.setState({userName: event.target.value})} />
      <input type = "password" onChange = {(event)=> this.setState({password: event.target.value})} />

      <button onClick={ handleSubmit }>Click here to Login</button>
      </div> */}


        

      

      </>

      
    
      


      
        
      
      
    );
  }
}

export default Login