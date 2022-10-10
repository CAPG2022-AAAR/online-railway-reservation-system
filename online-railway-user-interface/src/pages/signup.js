// import React from 'react';
import React, { useEffect, useState } from 'react';
import RegistrationForm from '../components/forms/RegistrationForm';
import { toast } from 'react-toastify';
import { Button, Col, Row } from 'reactstrap';
import { Form } from 'reactstrap';
import { FormGroup } from 'reactstrap';
import { Label } from 'reactstrap';
import { Input } from 'reactstrap';
import { Card, Container, CardHeader, CardBody } from 'reactstrap';
import { userSignUp } from '../service/userService';

const SignUp = () => {


  const [data, setData] = useState({
    fname: '',
    lname: '',
    email: '',
    password: '',
    address: '',
    age: '',
    gender: '',
    phoneNumber: '',
  })

  const [error, setError] = useState({
    errors: {},
    isError: false
  })

  // useEffect(() => {
  //   console.log(data)
  // }, [data])


  const handleChange = (event, property) => {
    setData({ ...data, [property]: event.target.value })
  }

  const handleSubmit = (event) => {


    event.preventDefault()
    if (error.isError) {
      toast.error("form data is invalid");
      return;
    }
    console.log(data)
    //data validate

    //call server api
    userSignUp(data).then((resp) => {
      console.log(resp)
      console.log("success")
      setError({ ...error, isError: false, errors: "" });
      toast.success("User is registered successfully")
      setData({
        fname: '',
        lname: '',
        email: '',
        password: '',
        address: '',
        age: '',
        gender: '',
        phoneNumber: '',
      })
    }).catch((error) => {
      console.log(error)
      //handle errors
      setError({
        errors: error,
        isError: true,
      })
    })



    // event.preventDefault()
    // axios.post('http://localhost:3000/api/v1/registration' , this.state )
    // console.log(data)
    // .then(response => {
    //   console.log(response)
    // })
    // .catch(e => {
    //   console.log(e)
    // })

  }

  const resetData = () => {
    setData({
      fname: '',
        lname: '',
        email: '',
        password: '',
        address: '',
        age: '',
        gender: '',
        phoneNumber: '',
    })
  }

  return (
    <Container>
      <Row className='mt-4'>
        <Col sm={{ size: 6, offset: 3 }}>
          <Card color='dark' inverse>
            <CardHeader className='text-center'>
              <h2>User Registeration</h2>
            </CardHeader>
            <CardBody>
              <Form onSubmit={handleSubmit}>
                <FormGroup>
                  <Label>
                    First Name :
                  </Label>
                  <Input type='text' onChange={(e) => handleChange(e, 'fname')} value={data.fname} />
                </FormGroup>
                <FormGroup>
                  <Label>
                    Last Name :
                  </Label>
                  <Input type='text' onChange={(e) => handleChange(e, 'lname')} value={data.lname} >
                  </Input>
                </FormGroup>
                <FormGroup>
                  <Label>
                    Email :
                  </Label>
                  <Input type='text' onChange={(e) => handleChange(e, 'email')} value={data.email} >
                  </Input>
                </FormGroup>
                <FormGroup>
                  <Label>
                    Password :
                  </Label>
                  <Input type='password' onChange={(e) => handleChange(e, 'password')} value={data.password} >
                  </Input>
                </FormGroup>
                <FormGroup>
                  <Label>
                    Address :
                  </Label>
                  <Input type='text' onChange={(e) => handleChange(e, 'address')} value={data.address} >
                  </Input>
                </FormGroup>
                <FormGroup>
                  <Label>
                    Age :
                  </Label>
                  <Input type='number' value={data.age} onChange={(e) => handleChange(e, 'age')} >
                  </Input>
                </FormGroup>
                <FormGroup>
                  <Label>
                    Gender :
                  </Label>
                  <Input type='text' value={data.gender} onChange={(e) => handleChange(e, 'gender')}>
                  </Input>
                </FormGroup>
                <FormGroup>
                  <Label>
                    Phone Number:
                  </Label>
                  <Input type='text' value={data.phoneNumber} onChange={(e) => handleChange(e, 'phoneNumber')}>
                  </Input>
                </FormGroup>
                <Container className='text-center'>
                  <Button color="light" outline>Register</Button>
                  <Button onClick={resetData} color="secondary" type="reset" className="ms-2">Reset</Button>
                </Container>
              </Form>
            </CardBody>
          </Card>
        </Col>
      </Row>
    </Container>
  );
};

// return (
// <div
//   style={{
//     display: 'flex',
//     justifyContent: 'center',
//     alignItems: 'center',
//     height: '90vh',
//   }}
// >

// < RegistrationForm />

// </div>

// );
// };


export default SignUp;
