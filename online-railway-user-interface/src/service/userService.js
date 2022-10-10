import { BASE_URL, myAxios } from "./helper";

export const userSignUp = (user) => {
    return myAxios.post('/api/v1/registration', user).then((response) => response.data)
}

// export const loginUser=(loginDetail)=>{
//     return myAxios.post('/users/authenticate',loginDetail).then((response)=>response.data)
// }