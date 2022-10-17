import React from 'react';
import TicketInfoForm from '../components/forms/TicketInfoForm'


const TicketInfo = () => {
  return (
    <>
    
    <div
      style={{
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'center',
        height: '50vh',
        marginTop: '15%'
      }}
    >
    <TicketInfoForm />
      
    </div>
    
    </>
  );
};

export default TicketInfo;