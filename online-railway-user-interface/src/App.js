import React, { useEffect } from 'react';
import './App.css';
import Navbar from './components/Navbar';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './pages';
import About from './pages/about';
import Contact from './pages/contact';
import SignUp from './pages/signup';
import Login from './pages/login';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import TrainInfo from './pages/traininfo';
import { setAuthToken } from './service/setAuthToken';
import Logout from './pages/logout';
import AvailableTrainInfo from './pages/availableTrainInfo';
import TicketInfo from './pages/ticketInfo';



function App() {

  useEffect(() => {
    document.title = 'Online Railways';
  });


  const token = localStorage.getItem("token");
 if (token) {
     setAuthToken(token);
 }

  return (
  
    <Router>
      <ToastContainer position="bottom-center" />
      <Navbar />

      
        <Routes>

        <Route path='/' exact element={<Home />} />
        <Route path='/about' element={<About />} />
        <Route path='/traininfo' element={ <TrainInfo />} />
        <Route path='/contact-us' element={<Contact />} />
        <Route path='/sign-up' element={<SignUp />} />
        <Route path='/login' element={<Login />} />
        <Route path='/logout' element={<Logout />} />
        <Route path='/available-train-info' element={ <AvailableTrainInfo/>} />
        <Route path='/ticketinfo' element={<TicketInfo />} />

      </Routes>
      </Router>
      

  
    
  );
}

export default App;
