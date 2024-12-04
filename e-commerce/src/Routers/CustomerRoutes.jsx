import React from 'react';
import { Route, Routes } from 'react-router-dom';
import HomePage from '../customer/Pages/HomePage/HomePage'
import Cart from '../customer/components/Cart/Cart'
import Navigation from '../customer/components/navigation/navigation';
import Footer from '../customer/components/Footer/Footer';
import Product from '../customer/components/Product/Product';
import ProductDetails from '../customer/components/ProductDetails/ProductDetails';
import Checkout from '../customer/components/Checkout/Checkout';
import Order from '../customer/components/Order/Order';
import OrderDetails from '../customer/components/Order/OrderDetails';
import PaymentSuccess from '../customer/components/Payment/PaymentSuccess';

const CustomerRoutes = () => {
    return (
        <div>
            <div>
                <Navigation />
            </div>
            <Routes>
                
                <Route path='/' element={<HomePage />}></Route>
                <Route path='/login' element={<HomePage />}></Route>
                <Route path='/register' element={<HomePage />}></Route>
                <Route path='/cart' element={<Cart />}></Route>
                <Route path='/:levelOne/:levelTwo/:levelThree' element={<Product />} />
                <Route path='/product/:productId' element={<ProductDetails />} />
                <Route path='/checkout' element={<Checkout />} />
                <Route path='/account/order' element={<Order />} />
                <Route path='/account/order/:orderId' element={<OrderDetails />} />
                <Route path='/payment/:orderId' element={<PaymentSuccess />} />

                
                
                
            </Routes>
            <div>
                <Footer />
            </div>
        </div>
    )
}
export default CustomerRoutes;