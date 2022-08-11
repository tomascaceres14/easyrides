
import "./App.css";
import React from "react";
import { Login } from "./Paginas/Login/Login.js";
import Registro from "./Paginas/Registro/Registro.js";
import { Home } from "./Paginas/Home/Home";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./Paginas/Home/Header/Header";
import Footer from "./Paginas/Home/Footer/Footer";
import { useInitialState } from "./Hooks/useInitialState";
import AppContext from "./Context/AppContext";


function App() {
  const initialState = useInitialState()
  return (
    <div className="App">
      <AppContext.Provider value={initialState}>
        <BrowserRouter>
            <Header user={initialState}  />
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/login" element={<Login />} />
              <Route path="/registro" element={<Registro />} />
            </Routes>
            <Footer />
        </BrowserRouter>
      </AppContext.Provider>
      

    </div>
  );
}

export default App;
