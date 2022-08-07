import './App.css';
import React from 'react';
//import { Login } from "./Paginas/Login/Login.jsx"
// import Registro  from "./Paginas/Registro/Registro.jsx"
import { Home } from './Paginas/Home/Home';
// import { BrowserRouter, Route,Routes } from "react-router-dom";
// import Header from './Paginas/Home/Header/Header';
// import Footer from './Paginas/Home/Footer/Footer';

function App() {
  return (
    <div className='App'>
        {/* <Header />
        <Routes>
          <Route path="/" element={<Home />} />
        </Routes>
        <Footer /> */}
        <Home/>
    </div>
  );
}

export default App;
