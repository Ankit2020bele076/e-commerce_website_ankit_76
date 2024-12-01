import { Routes, Route } from 'react-router-dom';
import './App.css';
import Cart from './customer/components/Cart/Cart';
import Checkout from './customer/components/Checkout/Checkout';
import Footer from './customer/components/Footer/Footer';
import Navigation from './customer/components/navigation/navigation';
import Order from './customer/components/Order/Order';
import OrderDetails from './customer/components/Order/OrderDetails';
import Product from './customer/components/Product/Product';
import ProductDetails from './customer/components/ProductDetails/ProductDetails';
import HomePage from './customer/Pages/HomePage/HomePage';
import CustomerRoutes from './Routers/CustomerRoutes';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path='/*' element={<CustomerRoutes />}></Route>
      </Routes>
      
    </div>
  );
}

export default App;
