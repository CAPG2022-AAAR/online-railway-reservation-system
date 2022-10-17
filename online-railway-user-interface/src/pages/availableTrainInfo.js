import { useLocation } from "react-router-dom";
import axios from "axios";
import React from "react";
import { useEffect, useState } from "react";
import { Table } from "antd";
import 'antd/dist/antd.css'






const AvailableTrainInfo = () => {

    const location = useLocation();

    const [data , setData] = useState([]);

    useEffect(()=>{

        
        if(location.state!=null)
        getAvailableTrains();

    }, []);

    const columns = [
        {
            title: "Train Number",
            dataIndex: 'trainId',
            key: "Train Number"
        },
        {
            title: "Train Name",
            dataIndex: 'trainName',
            key: "Train Number"
        },
        {
            title: "Source",
            dataIndex: 'source',
            key: "Train Number"
        },
        {
            title: "Departure",
            dataIndex:  'sourceDepartureTime' ,
            key: "Train Number"
        },
        {
            title: "Destination",
            dataIndex: 'destination',
            key: "Train Number"
        },
        {
            title: "Arrival",
            dataIndex: 'destinationArrivalTime',
            key: "Train Number"
        },
        {
            title: "Fare Per Kilometer",
            dataIndex: 'fare',
            key: "Train Number"
        }
    ]

    

    
    

    //console.log(query);

    const getAvailableTrains = () =>{

        const query = {
            source_id: location.state.source_id,
            destination_id: location.state.destination_id,
            date: location.state.date
        }

        axios.post("http://localhost:3000/getavailabletrains", query)
        .then(response => {

            const responseList = response.data.list;
            console.log("the response is  ");

            setData(responseList);
            

        })
        .catch(err => {
            
        
            alert(err.messsage);
            console.log(err);
            
          });
    }

    

        console.log(data);
    
    return (


        
            /* <table>
               <tr>
                   <th>Train Number</th>
                    <th>Train Name</th>
                    <th>Source </th>
                    <th>Departure</th>
                    <th>Destination </th>
                    <th>Arrival</th>
                    <th>Fare Per Km</th>
                </tr>

                

                 {
                    data.map((train)=> <tr>

                                <td>{train.trainId}</td>
                                <td>{train.trainName}</td>
                                <td>{train.source} </td>
                                <td>{train.sourceDepartureTime}</td>
                                <td>{train.destination} </td>
                                <td>{train.destinationArrivalTime}</td>
                                <td>{train.fare}</td>
                                
                            </tr>)


                    
                 }

                 </table>  */
                 
            
                
                    <Table
                    dataSource={data}
                    columns = {columns}
                    pagination = {false}
                    >

                    </Table>
                 
                
            
        
    )
}
 
export default AvailableTrainInfo;