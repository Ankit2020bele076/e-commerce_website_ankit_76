import { Button, Grid2, TextField } from "@mui/material";
import React, { useEffect } from "react";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import { login } from "../../State/Auth/Action";

const LoginForm = () => {

    const navigate = useNavigate();
    const dispatch = useDispatch();

    // useEffect(() => {
    //     if(jwt){
    //         dispatch(getUser(jwt))
    //     }
    // },[jwt, auth.jwt])
     
    const handleSubmit = (event) => {
        event.preventDefault();

        const data = new FormData(event.currentTarget);

        const userData = {
            email : data.get("email"),
            password : data.get("password")
        }
        dispatch(login(userData))
        console.log(userData);
    }

    return(
        <div>
            <form action="" onSubmit={handleSubmit}>
                <Grid2 container spacing={3}>
                    <Grid2 item size={{xs:12}}>
                        <TextField required id='email' name='email' label='Email' fullWidth autoComplete="email" />
                    </Grid2>
                    <Grid2 item size={{xs:12}}>
                        <TextField required id='password' name='password' label='Password' fullWidth autoComplete="password" />
                    </Grid2>
                    <Grid2 item size={{xs:12}}>
                        <Button className="bg-[#9155fd] w-full" type='submit' variant='contained' size='large' sx={{padding:"0.8rem 0", bgcolor:"#9155fd"}}>
                            Login
                        </Button>
                    </Grid2>
                </Grid2>
            </form>
            <div className="flex justify-center flex-col items-center">
                <div className="py-3 flex items-center">
                    <p>If you don't have account ?</p>
                    <Button onClick={()=>navigate("/register")} className='ml-5' size='small'>Register</Button>
                </div>
            </div>
        </div>
    )
}
export default LoginForm;