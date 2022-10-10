import React, { Component } from 'react'
import axios from 'axios'

export class RegistrationForm extends Component {


  constructor(props) {
    super(props)
  
    this.state = {
        fname: '',
        lname: '',
        email: '',
        password: '',
        address: '',
        age: '',
        gender: '',
        phoneNumber: ''
    }
  }

  handleFNameChange = (event) => {
    this.setState({
      fname: event.target.value
    })
  } 
  
  handleLNameChange = (event) => {
    this.setState({
      lname: event.target.value
    })
  } 
  handleEmailChange = (event) => {
    this.setState({
      email: event.target.value
    })
  } 
  handlePasswordChange = (event) => {
    this.setState({
      password: event.target.value
    })
  } 
  handleAddressChange = (event) => {
    this.setState({
      address: event.target.value
    })
  } 
  handleAgeChange = (event) => {
    this.setState({
      age: event.target.value
    })
  } 
  handleGenderChange = (event) => {
    this.setState({
      gender: event.target.value
    })
  } 
  handlePhoneNumberChange = (event) => {
    this.setState({
      phoneNumber: event.target.value
    })
  } 

  handleSubmit = (event) => {
  
    
    event.preventDefault()
    axios.post('http://localhost:3000/api/v1/registration' , this.state )
    .then( response =>{
      console.log(response)
    } )
    .catch(e => {
      console.log(e)
    })

  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <div>

          <label>
            First Name : 
          </label>
          <input type='text' value={this.state.fname} onChange = {this.handleFNameChange}  />
          

          <label>
            Last Name : 
          </label>
          <input type='text' value={this.state.lname} onChange = {this.handleLNameChange} >
          </input>

          <br></br>

          <label>
            Email : 
          </label>
          <input type='text'  value={this.state.email} onChange = {this.handleEmailChange} >
          </input>

          <br></br>

          <label>
            Password : 
          </label>
          <input type={'password'} value={this.state.password} onChange = {this.handlePasswordChange} >
          </input>

          <br></br>

          <label>
            Address : 
          </label>
          <input type='text'  value={this.state.address}  onChange = {this.handleAddressChange} >
          </input>

          <br></br>

          <label>
            Age : 
          </label>
          <input type='number' value={this.state.age} onChange = {this.handleAgeChange} >
          </input>

          <br></br>

          <label>
            Gender : 
          </label>
          <input type='text' value={this.state.gender} onChange = {this.handleGenderChange}>
          </input>

          <br></br>

          <label>
            Phone Number: 
          </label>
          <input type='text' value={this.state.phoneNumber} onChange = {this.handlePhoneNumberChange}>
          </input>


        </div>
        <button type='submit'> Submit</button>
      </form>
    )
  }
}

export default RegistrationForm