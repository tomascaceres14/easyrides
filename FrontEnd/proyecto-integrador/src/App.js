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
import { AuthProvider } from "./Context/AuthContext";
import Producto from "./Paginas/Home/Listado/Producto/Producto";

function App() {
  const initialState = useInitialState();
  return (
    <div className="App">
      <AppContext.Provider value={initialState}>
        <AuthProvider>
            <BrowserRouter>
              <Header user={initialState} />
              <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/login" element={<Login />} />
                <Route path="/registro" element={<Registro />} />
                <Route path="/producto" element={<Producto />} />
              </Routes>
              <Footer />
            </BrowserRouter>
        </AuthProvider>
      </AppContext.Provider>
    </div>
  );
}

export default App;
