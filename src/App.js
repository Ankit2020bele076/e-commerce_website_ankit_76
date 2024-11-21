import './App.css';
import Footer from './customer/components/Footer/Footer';
import Navigation from './customer/components/navigation/navigation';
import HomePage from './customer/Pages/HomePage/HomePage';

function App() {
  return (
    <div className="App">
      <Navigation />
      <div>
        <HomePage />
      </div>
      <Footer />
    </div>
  );
}

export default App;
