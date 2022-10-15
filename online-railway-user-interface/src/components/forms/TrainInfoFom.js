import React, {useState } from 'react'
import { Form } from 'reactstrap';
import axios from 'axios';
import {Link, Navigate} from 'react-router-dom';
import { useNavigate } from "react-router-dom";


import '../../styles/forms.css';
import AvailableTrainInfo from '../../pages/availableTrainInfo';


const TrainInfo = () => {

    const [source_id , setSourceId] = useState();
    const [destination_id , setDestinationId] = useState();
    const [date , setDate] = useState();


    const navigate = useNavigate();


        const handleSubmit = (event) => {

        event.preventDefault();
        navigate('/available-train-info' , {state :{source_id,destination_id,date}});      
    }

    return (
        <>
        <h1>Train Information</h1>
        <br></br>
        
            <form>
            <label>Source: </label>
            <input type= "text" onChange = {(event) => setSourceId(event.target.value)} />
            <br></br>
            <label>Destination: </label>
            <input type= "text" onChange = {(event) => setDestinationId( event.target.value)} />
            <br></br>
            <label>Date: </label>
            <input type= "text" onChange = {(event) => setDate(event.target.value)} />
            <br></br>

            <button onClick={ handleSubmit }>Click here to get available trains!</button>
        </form>

        
        
        
        </>
      
    )
}
 
export default TrainInfo;


















    

        

    