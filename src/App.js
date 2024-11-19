import './App.css';
import Navigation from './customer/components/navigation/navigation';
import HomePage from './customer/Pages/HomePage/HomePage';

function App() {
  return (
    <div className="App">
      <Navigation />
      <div>
        <HomePage />
      </div>
    </div>
  );
}

export default App;
