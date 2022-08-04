import React from 'react'
import "./Buscador.css";
import Button from "@mui/material/Button";
const Buscador = () => {
  return (
    <div className="buscador">
      <h1>Busca ofertas en autos, camionetas y mucho más</h1>
      <div className="buscador-inputs" >
        <Button sx={{ mr: 1 }} variant="outlined">A donde vamos</Button>
        <Button sx={{ mr: 1 }} variant="outlined">Check-in Check-Out</Button>
        <Button variant="outlined">Buscar</Button>
      </div>
    </div>
  );
}

export default Buscador