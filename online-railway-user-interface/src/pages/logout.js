import React, { Component } from 'react'

export class Logout extends Component {


  render() {

    localStorage.setItem('token', '');

    return (
      window.location.href = '/'
    )
  }


}


export default Logout