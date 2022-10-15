import React from 'react';
import TrainInfoForm from '../components/forms/TrainInfoFom';

const TrainInfo = () => {
  return (
    <>
    
    <div
      style={{
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'center',
        height: '50vh'
      }}
    >
    
      <TrainInfoForm />
    </div>
    
    </>
  );
};

export default TrainInfo;
