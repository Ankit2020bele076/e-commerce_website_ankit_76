import  Grid  from '@mui/material/Grid2';
import React, { useEffect } from 'react';
import OrderCard from './OrderCard';
import { useDispatch, useSelector } from 'react-redux';
import { getOrders } from '../../../State/Order/Action';

const orderStatus=[
    {label:"On The Way", value:"on_the_way"},
    {label:"Delivered",value:"delivered"},
    {label:"Cancelled",value:"cancelled"},
    {label:"Returned",value:"returned"}
]

const Order = () => {

    const {order} = useSelector(store => store);
    const dispatch = useDispatch();
    useEffect(()=>{
        dispatch(getOrders());
        console.log("orders: ",order.order);
    },[order.orders])
    return(
        <div className="lg:px-20 px-5">
            <Grid container sx={{justifyContent:"space-between"}}>
                <Grid item size={2.5}>
                    <div className="h-auto shadow-lg bg-white p-5 sticky top-5">
                        <h1 className="font-bold text-lg">Filter</h1>
                        <div className="space-y-4 mt-10">
                            <h1 className="font-semibold">ORDER STATUS</h1>
                            {orderStatus.map((option) => <div className="flex items-center">
                                <input defaultValue={option.value} type="checkbox" className="h-4 w-4 border-gray-300 text-indigo-600 focus:ring-indigo-500" />
                                <label className="ml-3 text-sm text-gray-600" htmlFor={option.value}>
                                    {option.label}
                                </label>
                            </div>)}
                        </div>
                    </div>
                </Grid>
                <Grid item size={9}>
                    <div className="space-y-5">
                    {order.order?.map((order) => (
                            <div key={order.id}>
                                {order.orderItems?.map((item) => (
                                    <OrderCard key={item.id} item={item} />
                                ))}
                            </div>
                        ))}
                    </div>
                </Grid>
            </Grid>
        </div>
    )
}

export default Order;