import React, { useState } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { useParams } from 'react-router-dom';
import { getOrderById } from '../../../State/Order/Action';
import { updatePayment } from '../../../State/Payment/Action';
import { Alert, AlertTitle } from '@mui/material';
import OrderTracker from '../Order/OrderTracker';

const PaymentSuccess = () => {

    const [paymentId, setPaymentId] = useState();
    const [referenceId, setReferenceId] = useState();
    const [paymentStatus, setPaymentStatus] = useState();
    const { orderId } = useParams();

    const dispatch = useDispatch();
    const { order } = useSelector(store => store);

    useEffect(() => {
        const urlParam = new URLSearchParams(window.location.search);

        setPaymentId(urlParam.get("razorpay_payment_link_id"))
        setPaymentStatus(urlParam.get("razorpay_payment_link_status"))
    }, [])

    useEffect(() => {
        const data = { orderId, paymentId }
        dispatch(getOrderById(orderId));
        dispatch(updatePayment(data));
    }, [orderId, paymentId])

    return (
        <div className="px-2 lg:px-36">
            <div className="flex flex-col justify-center items-center">
                <Alert variant='filled' severity='success' sx={{ mb: 6, width: "fit-content" }}>
                    <AlertTitle>Payment Success</AlertTitle>
                    Congratulations Your Order Got Placed
                </Alert>
            </div>
            <OrderTracker activeStep={1}></OrderTracker>

            <Grid2 container className="space-y-5 py-5 pt-20">

                {order.order?.orderItems.map((item) => {
                    <Grid2 container item className="shadow-xl rounded-md p-5" sx={{ alignItems: "center", justifyContent: "space-between" }}>
                        <Grid2 item size={{ xs: 6 }}>
                            <div className="flex items-center">
                                <img classname="w-[5rem] h-[5rem] object-cover object-top" src="https://rukminim1.flixcart.com/image/612/612/xif0q/kurta/i/v/x/xxl-br-ad-kt-105-adwyn-peter-original-imagj4zyd2q7t6cg.jpeg?q=70" alt="" />

                                <div>
                                    <p>{item.product.title}</p>
                                </div>
                            </div>
                        </Grid2>
                    </Grid2>
                })}
            </Grid2>

        </div>
    )
}

export default PaymentSuccess;