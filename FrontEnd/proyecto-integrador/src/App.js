
import "./App.css";
import React from "react";
import { Login } from "./Paginas/Login/Login.js";
import Registro from "./Paginas/Registro/Registro.js";
import { Home } from "./Paginas/Home/Home";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./Paginas/Home/Header/Header";
import Footer from "./Paginas/Home/Footer/Footer";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/registro" element={<Registro />} />
        </Routes>
        <Footer />
      </BrowserRouter>

    </div>
  );
}

export default App;
