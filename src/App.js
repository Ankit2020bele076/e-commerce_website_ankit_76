import './App.css';
import Footer from './customer/components/Footer/Footer';
import Navigation from './customer/components/navigation/navigation';
import Product from './customer/components/Product/Product';
import ProductDetails from './customer/components/ProductDetails/ProductDetails';
import HomePage from './customer/Pages/HomePage/HomePage';

function App() {
  return (
    <div className="App">
      <Navigation />
      <div>
        {/* <HomePage /> */}
        {/* <Product /> */}
        <ProductDetails />
      </div>
      <Footer />
    </div>
  );
}

export default App;
