import  React , {Component} from 'react';
import {
  Nav,
  NavLink,
  Bars,
  NavMenu,
  NavBtn,
  NavBtnLink
} from './NavbarElements';

import "../../styles/images.css";

import axios from 'axios';

const Navbar = () => {

  return (
    <>
      <Nav>
        <NavLink to='/'>
          <img className="logo-img" src={require('../../images/trainlogo.png')} alt='logo' />
        </NavLink>
        <Bars />
        <NavMenu>
          <NavLink to='/about' activeStyle>
            About
          </NavLink>
          <NavLink to='/traininfo' activeStyle>
            Train Information
          </NavLink>
          <NavLink to='/contact-us' activeStyle>
            Contact Us
          </NavLink>
          
          {/* Second Nav */}
          {/* <NavBtnLink to='/sign-in'>Sign In</NavBtnLink> */}
        </NavMenu>

        {
            localStorage.getItem('token')?

          
            <NavBtn>
            <NavBtnLink to='/logout'>Logout</NavBtnLink>
            </NavBtn>

            
            

            :
            <>

            
            <NavLink to='/sign-up' activeStyle>
            Sign Up
            </NavLink>


            <NavBtn>
            <NavBtnLink to='/login'>Login</NavBtnLink>
            </NavBtn>
 
            

            </ >
}
        

       
        
        
      </Nav>
    </>
  );
};

export default Navbar;
