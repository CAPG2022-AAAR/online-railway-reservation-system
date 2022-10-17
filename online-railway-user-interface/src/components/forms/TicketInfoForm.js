import React, {useState } from 'react'
import { Form } from 'reactstrap';
import axios from 'axios';
import {Link, Navigate} from 'react-router-dom';
import { useNavigate } from "react-router-dom";



import '../../styles/forms.css';





const TicketInfo = () => {

    const [f_name , setFName ] = useState();
    const [l_name , setLName] = useState();
    const [gender , setGender] = useState();
    const [address , setAddress] = useState();
    const [email , setEmail] = useState();
    const [seats, setSeats] = useState();
    const [amount , setAmount] = useState();
    const [age, setAge] = useState();
    const [c_id , setCId] = useState();
    const [train_number, setTrainNumber ] = useState();
    const [source_id, setSourceId] = useState();
    const [destination_id , setDestinationId] = useState();
    const [departure_time , ] = useState();
    const [date , setDate] = useState();

    const [form, setForm] = useState();


    const navigate = useNavigate();


        const handleSubmit = (event) => {

        event.preventDefault();
        //navigate('/available-train-info' , {state :{source_id,destination_id,date}});    
        axios.post('http://localhost:3000/bookticket' , 
        {f_name,l_name,gender,address,email,seats,amount,
            age,c_id,train_number,source_id,destination_id,departure_time , date})
            .then(response =>{

                alert(response.data.pnr);
                console.log(response.data);
               // window.location.href = '/';
               // response.data && alert(("Your Ticket has been created with PNR" + response.data.pnr));
            })
            .catch(err => {
            
        
                alert(err.messsage);
                console.log(err)
                
              });
    }

    return (
        <>
        <h1>Ticket Information</h1>
        <br></br>
        
            <form>

            <label>First Name: </label>
            <input type= "text" onChange = {(event) => setFName(event.target.value)} />
            <br></br>

            <label>Last Name: </label>
            <input type= "text" onChange = {(event) => setLName(event.target.value)} />
            <br></br>

            <label>Gender: </label>
            <input type= "text" onChange = {(event) => setGender(event.target.value)} />
            <br></br>

            <label>Address: </label>
            <input type= "text" onChange = {(event) => setAddress(event.target.value)} />
            <br></br>

            <label>Email: </label>
            <input type= "text" onChange = {(event) => setEmail(event.target.value)} />
            <br></br>

            <label>Seats: </label>
            <input type= "number" onChange = {(event) => setSeats(event.target.value)} />
            <br></br>

            <label>Amount: </label>
            <input type= "number" onChange = {(event) => setAmount(event.target.value)} />
            <br></br>

            <label>Age: </label>
            <input type= "number" onChange = {(event) => setAge(event.target.value)} />
            <br></br>


            <label>Customer Id: </label>
            <input type= "number" onChange = {(event) => setCId(event.target.value)} />
            <br></br>

            <label>Train Number: </label>
            <input type= "number" onChange = {(event) => setTrainNumber(event.target.value)} />
            <br></br>



            <label>Source Id: </label>
            <input type= "text" onChange = {(event) => setSourceId(event.target.value)} />
            <br></br>


            <label>Destination Id: </label>
            <input type= "text" onChange = {(event) => setDestinationId( event.target.value)} />
            <br></br>

            <label>Date: </label>
            <input type= "text" onChange = {(event) => setDate( event.target.value)} />
            <br></br>
            

            <button onClick={ handleSubmit }>Click here to book your ticket </button>
        </form>

        
        
        
        </>
      
    )
}
 
export default TicketInfo;
